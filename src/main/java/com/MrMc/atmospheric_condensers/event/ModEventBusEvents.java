package com.MrMc.atmospheric_condensers.event;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;
import com.MrMc.atmospheric_condensers.recipe.CircuitPressRecipe;
import com.MrMc.atmospheric_condensers.recipe.Condenser1Recipe;
import com.MrMc.atmospheric_condensers.recipe.TransistorFactoryRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = AtmosphericCondensers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, TransistorFactoryRecipe.Type.ID, TransistorFactoryRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, CircuitPressRecipe.Type.ID, CircuitPressRecipe.Type.INSTANCES);

        Registry.register(Registry.RECIPE_TYPE, Condenser1Recipe.Type.ID, Condenser1Recipe.Type.INSTANCES1);
    }


}