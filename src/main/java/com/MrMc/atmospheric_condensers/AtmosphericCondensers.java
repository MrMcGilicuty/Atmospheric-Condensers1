package com.MrMc.atmospheric_condensers;

import com.MrMc.atmospheric_condensers.init.BlockInit;
import com.MrMc.atmospheric_condensers.init.ItemInit;

import com.MrMc.atmospheric_condensers.init.entity.ModBlockEntities;
import com.MrMc.atmospheric_condensers.init.fluid.gas.GasInit;
import com.MrMc.atmospheric_condensers.recipe.ModRecipes;
import com.MrMc.atmospheric_condensers.init.screen.ModMenuTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.slf4j.Log4jLogger;



@Mod(AtmosphericCondensers.MOD_ID)
public class AtmosphericCondensers {


    public static final String MOD_ID = "atmospheric_condensers";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static final CreativeModeTab ATMO_TAB = new CreativeModeTab(MOD_ID) {

        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.TRANSISTOR_FACTORY.get());
        }
    };

    public AtmosphericCondensers() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(eventBus);
        BlockInit.BLOCKS.register(eventBus);

        ModMenuTypes.register(eventBus);
        ModBlockEntities.register(eventBus);

        ModRecipes.register(eventBus);

        GasInit.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

}



























