package com.MrMc.atmospheric_condensers.init.entity;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;
import com.MrMc.atmospheric_condensers.init.BlockInit;
import com.MrMc.atmospheric_condensers.init.entity.custom.CircuitPressBlockEntity;
import com.MrMc.atmospheric_condensers.init.entity.custom.CondenserHousing1BlockEntity;
import com.MrMc.atmospheric_condensers.init.entity.custom.TransistorFactoryBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITYS =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, AtmosphericCondensers.MOD_ID);
    public static final RegistryObject<BlockEntityType<CircuitPressBlockEntity>> CIRCUIT_PRESS_BLOCK_ENTITY =
            BLOCK_ENTITYS.register("circuit_press_block_entity", () ->
                    BlockEntityType.Builder.of(CircuitPressBlockEntity::new,
                            BlockInit.CIRCUIT_PRESS.get()).build(null));
    public static final RegistryObject<BlockEntityType<TransistorFactoryBlockEntity>> TRANSISTOR_FACTORY_BLOCK_ENTITY =
            BLOCK_ENTITYS.register("transistor_factory_block_entity", () ->
                    BlockEntityType.Builder.of(TransistorFactoryBlockEntity::new,
                            BlockInit.TRANSISTOR_FACTORY.get()).build(null));
    public static final RegistryObject<BlockEntityType<CondenserHousing1BlockEntity>> CONDENSER_HOUSING_1_BLOCK_ENTITY =
            BLOCK_ENTITYS.register("condenser_housing_1_block_entity", () ->
                    BlockEntityType.Builder.of(CondenserHousing1BlockEntity::new,
                            BlockInit.CONDENSER.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITYS.register(eventBus);
    }
}
