package com.MrMc.atmosphericcondensers1.init;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.init.fluid.gas.GasInit;
import com.MrMc.atmosphericcondensers1.item.FuelType;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, atmosphericcondensers1.MOD_ID);

    public static final RegistryObject<Item> BITUMEN_ITEM = register("raw_bitumen",
            () -> new FuelType(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> TRANS_ITEM = register("transistor",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB).stacksTo(1).durability(12)));

    public static final RegistryObject<Item> NITROGEN_BUCKET = register("liquid_nitrogen_bucket",
            () -> new BucketItem(GasInit.LIQUID_NITROGEN_FLUID, new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TRANS_HEAD = register("transistor_head",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> TRANS_PRONG = register("transistor_feet",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> RAW_BOARD = register("raw_circuit_board",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> LV1_BOARD = register("circuit_board_lv1",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> LV2_BOARD = register("circuit_board_lv2",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> SILICA_ITEM = register("silica_dust",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> SILICA_MIXTURE = register("silicon_mixture",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    public static final RegistryObject<Item> SILICON = register("silicon",
            () -> new Item(new Item.Properties().tab(atmosphericcondensers1.ATMO_TAB)));

    private static <T extends Item>RegistryObject<T> register(final String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }
}
