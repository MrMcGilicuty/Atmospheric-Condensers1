package com.MrMc.atmosphericcondensers1.world.feature;

import com.MrMc.atmosphericcondensers1.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;

import java.util.List;

public class ModConfiguredFeatures {

    //Bitumen
    public static final RuleTest SANDSTONE = new TagMatchTest(Tags.Blocks.SANDSTONE);
    public static final List<OreConfiguration.TargetBlockState> ORE_BITUMEN_TARGET_LIST = List.of(
            OreConfiguration.target(SANDSTONE, BlockInit.BITUMEN_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_BITUMEN = FeatureUtils.register("ore_bitumen",
            Feature.ORE, new OreConfiguration(ORE_BITUMEN_TARGET_LIST, 10));

    //Silica
    public static final RuleTest SAND = new TagMatchTest(Tags.Blocks.SAND);
    public static final List<OreConfiguration.TargetBlockState> ORE_SILICA_TARGET_LIST = List.of(
            OreConfiguration.target(SAND, BlockInit.SILICA_BLOCK.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SILICA = FeatureUtils.register("ore_silica",
            Feature.ORE, new OreConfiguration(ORE_SILICA_TARGET_LIST, 33));
}
