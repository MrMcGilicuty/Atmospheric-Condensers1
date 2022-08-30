package com.MrMc.atmosphericcondensers1.world;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.world.gen.ModOreGeneration;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = atmosphericcondensers1.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
    }
}
