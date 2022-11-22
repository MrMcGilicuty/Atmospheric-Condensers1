package com.MrMc.atmospheric_condensers.world.gen;

import com.MrMc.atmospheric_condensers.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.BITUMEN_ORE_PLACED);

        List<Holder<PlacedFeature>> bases =
                event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION);

        bases.add(ModPlacedFeatures.SILICA_ORE_PLACED);
    }
}
