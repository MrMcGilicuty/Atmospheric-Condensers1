package com.MrMc.atmospheric_condensers.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
public class ModPlacedFeatures {

    public static final Holder<PlacedFeature> BITUMEN_ORE_PLACED = PlacementUtils.register("bitumen_ore_placed",
            ModConfiguredFeatures.ORE_BITUMEN, ModOrePlacement.commonOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(150))));

    public static final Holder<PlacedFeature> SILICA_ORE_PLACED = PlacementUtils.register("bitumen_ore_placed",
            ModConfiguredFeatures.ORE_SILICA, ModOrePlacement.commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(62))));
}
