package com.MrMc.atmosphericcondensers1.init.fluid.gas;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.init.BlockInit;
import com.MrMc.atmosphericcondensers1.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GasInit {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, atmosphericcondensers1.MOD_ID);


    public static final RegistryObject<FlowingFluid> LIQUID_NITROGEN_FLUID
            = FLUIDS.register("liquid_nitrogen_fluid", () -> new ForgeFlowingFluid.Source(GasInit.NITROGEN_PROPERTIES));

    public static final RegistryObject<FlowingFluid> LIQUID_NITROGEN_FLOWING
            = FLUIDS.register("liquid_nitrogen_flowing", () -> new ForgeFlowingFluid.Flowing(GasInit.NITROGEN_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NITROGEN_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_NITROGEN_FLUID.get(), () -> LIQUID_NITROGEN_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(1).viscosity(2).sound(SoundEvents.BUCKET_EMPTY).overlay(WATER_OVERLAY_RL).temperature(-320).gaseous()
            .color(0xFFa6fbfc)).slopeFindDistance(4).levelDecreasePerBlock(1)
            .block(() -> GasInit.NITROGEN_BLOCK.get()).bucket(() -> ItemInit.NITROGEN_BUCKET.get());

    public static final RegistryObject<LiquidBlock> NITROGEN_BLOCK = BlockInit.BLOCKS.register("nitrogen",
            () -> new LiquidBlock(() -> GasInit.LIQUID_NITROGEN_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}














