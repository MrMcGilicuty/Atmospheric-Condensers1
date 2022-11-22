package com.MrMc.atmospheric_condensers.init.entity.custom;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;
import com.MrMc.atmospheric_condensers.core.network.ClientboundUpdateEnergyStorageScreenPacket;
import com.MrMc.atmospheric_condensers.init.PacketHandler;
import com.MrMc.atmospheric_condensers.init.entity.ModBlockEntities;
import com.MrMc.atmospheric_condensers.recipe.Condenser1Recipe;
import com.MrMc.atmospheric_condensers.init.screen.CondenserHousingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

/**
 * started working on power recipes 8/19/22.
 * I stopped #/##/##
 */
public class CondenserHousing1BlockEntity extends BlockEntity implements MenuProvider {

    public final EnergyStorage energyStorage;
    private LazyOptional<EnergyStorage> energy;
    private int maxPower = 32000, maxReceived = 1000;
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private int power = 0;
    private int recipePower = 1000;

    public CondenserHousing1BlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.CONDENSER_HOUSING_1_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.energyStorage = createEnergyStorage();
        this.energy = LazyOptional.of(() -> this.energyStorage);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return CondenserHousing1BlockEntity.this.progress;
                    case 1:
                        return CondenserHousing1BlockEntity.this.maxProgress;
                    case 2:
                        return CondenserHousing1BlockEntity.this.power;
                    case 3:
                        return CondenserHousing1BlockEntity.this.energyStorage.getMaxEnergyStored();
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        CondenserHousing1BlockEntity.this.progress = value;
                        break;
                    case 1:
                        CondenserHousing1BlockEntity.this.maxProgress = value;
                        break;
                    case 2:
                        CondenserHousing1BlockEntity.this.power = value;
                        break;
                    case 3:
                        CondenserHousing1BlockEntity.this.maxPower = value;
                        break;
                }
            }

            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Atmo Condenser");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new CondenserHousingMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == CapabilityEnergy.ENERGY ? this.energy.cast() : super.getCapability(cap, side);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.energy.invalidate();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("condenser_housing_press.progress", progress);
        tag.putInt("condenser_housing_press.power", this.energyStorage.getEnergyStored());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("condenser_housing_press.progress");
        power = nbt.getInt("condenser_housing_press.power");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CondenserHousing1BlockEntity pBlockEntity) {
        if (hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            pBlockEntity.energyStorage.extractEnergy(5, true);
            setChanged(pLevel, pPos, pState);
            if (pBlockEntity.progress > pBlockEntity.maxProgress && pBlockEntity.power > pBlockEntity.recipePower) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress(pBlockEntity);
            setChanged(pLevel, pPos, pState);
        }

    }

    private static boolean hasRecipe(CondenserHousing1BlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<Condenser1Recipe> match = level.getRecipeManager()
                .getRecipeFor(Condenser1Recipe.Type.INSTANCES1, inventory, level);

        return match.isPresent() && energyRequirement(entity) && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
    }

    private static void craftItem(CondenserHousing1BlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<Condenser1Recipe> match = level.getRecipeManager()
                .getRecipeFor(Condenser1Recipe.Type.INSTANCES1, inventory, level);

        if (match.isPresent()) {
            if(entity.itemHandler.getStackInSlot(2).hurt(1, new Random(), null)) {
                entity.itemHandler.extractItem(2,1, false);
            }
            entity.itemHandler.extractItem(1, 1, false);
            entity.itemHandler.extractItem(2, 1, false);


            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + 1));

            entity.resetProgress(entity);
        }
    }

    private void resetProgress(CondenserHousing1BlockEntity entity) {
        this.progress = 0;
        this.power -= 5;
    }

    private static boolean energyRequirement(CondenserHousing1BlockEntity entity){
        return entity.energyStorage.getEnergyStored() > 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }

    /**
     *          Energy Receiving Magic
     *
     */

    private EnergyStorage createEnergyStorage() {
        return new EnergyStorage(maxPower, maxReceived, 0, 0) {
//            @Override
//            public int extractEnergy(int maxExtract, boolean simulate) {
//                final int e = super.extractEnergy(maxExtract, simulate);
////                PacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(),
////                        new ClientboundUpdateEnergyStorageScreenPacket(this.energy));
//                return e;
//            }

            /**
             * @param maxReceive
             *            Maximum amount of energy to be inserted.
             * @param simulate
             *            If TRUE, the insertion will only be simulated.
             * @return super.receiveEnergy(maxReceive, simulate)
             *            Returns normal receiveEnergy but updates the block before.
             */
            @Override
            public int receiveEnergy(int maxReceive, boolean simulate) {
                final int e = super.receiveEnergy(maxReceive, simulate);
//                PacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(),
//                        new ClientboundUpdateEnergyStorageScreenPacket(this.energy));
//                atmospheric_condensers.LOGGER.info("Received: {}", e);
//                atmospheric_condensers.LOGGER.info("Current: {}", this.energy);
                return e;
            }
        };
    }
}




