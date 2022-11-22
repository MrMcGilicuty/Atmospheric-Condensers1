package com.MrMc.atmospheric_condensers.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelType  extends Item {

    public  FuelType(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return 4000; // 4000 / 20 = 200 seconds?
    }

}
