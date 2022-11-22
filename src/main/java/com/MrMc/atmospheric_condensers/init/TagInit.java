package com.MrMc.atmospheric_condensers.init;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TagInit {
    public static final class Blocks{

        private static TagKey<Block> mod(String path){
            return BlockTags.create(new ResourceLocation(AtmosphericCondensers.MOD_ID, path));
        }
    }

    public static final class Items {

        public static final TagKey<Item> FACTORY_BLOCKS = mod("factory_blocks");
        public static final TagKey<Item> Quartz_Dust = mod("quartz_dust");
        public static final TagKey<Item> Bitumen = mod("bitumen");
        public static final TagKey<Item> Circuit_Board = mod("circuit_board");
        public static final TagKey<Item> Transistors = mod("transistors");

        private static TagKey<Item> mod(String path){
            return ItemTags.create(new ResourceLocation(AtmosphericCondensers.MOD_ID, path));
        }
    }
}
