package com.MrMc.atmosphericcondensers1.event;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.init.BlockInit;
import com.MrMc.atmosphericcondensers1.init.fluid.gas.GasInit;
import com.MrMc.atmosphericcondensers1.init.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = atmosphericcondensers1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {


    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {

        MenuScreens.register(ModMenuTypes.CIRCUIT_PRESS_MENU.get(), CircuitPressScreen::new);
        MenuScreens.register(ModMenuTypes.TRANSISTOR_FACTORY_MENU.get(), TransistorFactoryScreen::new);
        MenuScreens.register(ModMenuTypes.CONDENSER_HOUSING_MENU.get(), CondenserHousingScreen::new);

        ItemBlockRenderTypes.setRenderLayer(GasInit.NITROGEN_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(GasInit.LIQUID_NITROGEN_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(GasInit.LIQUID_NITROGEN_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.CONDENSER.get(), RenderType.translucent());

    }

}




