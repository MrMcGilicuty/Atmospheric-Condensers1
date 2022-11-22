package com.MrMc.atmospheric_condensers.init;

import java.util.function.Function;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;

import com.MrMc.atmospheric_condensers.block.CircuitBoardPressBlock;
import com.MrMc.atmospheric_condensers.block.CondenserHousingBlock;
import com.MrMc.atmospheric_condensers.block.TransistorFactoryBlock;


import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            AtmosphericCondensers.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    //This adds 1 block
    public static final RegistryObject<Block> BITUMEN_ORE = register("bitumen_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).strength(2.0f)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(AtmosphericCondensers.ATMO_TAB)));

    public static final RegistryObject<Block> TRANSISTOR_FACTORY = register("transistor_factory",
            () -> new TransistorFactoryBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_GRAY).strength(1.5f)
                    .sound(SoundType.METAL).dynamicShape()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(AtmosphericCondensers.ATMO_TAB)));

    public static final RegistryObject<Block> CONDENSER = register("condenser_housing",
            () -> new CondenserHousingBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_GRAY).strength(2.0f)
                    .sound(SoundType.METAL).dynamicShape()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(AtmosphericCondensers.ATMO_TAB)));

    public static final RegistryObject<Block> CIRCUIT_PRESS = register("circuit_board_press",
            () -> new CircuitBoardPressBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_BLACK).strength(1.5f)
                    .sound(SoundType.METAL).dynamicShape()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(AtmosphericCondensers.ATMO_TAB)));

    public static final RegistryObject<Block> SILICA_BLOCK = register("silica_sand",
            () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_LIGHT_BLUE).strength(0.5f)
                    .sound(SoundType.SAND)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(AtmosphericCondensers.ATMO_TAB)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block){
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item){
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
