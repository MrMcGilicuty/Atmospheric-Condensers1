package com.MrMc.atmosphericcondensers1.event;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.recipe.CircuitPressRecipe;
import com.MrMc.atmosphericcondensers1.recipe.Condenser1Recipe;
import com.MrMc.atmosphericcondensers1.recipe.TransistorFactoryRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = atmosphericcondensers1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, TransistorFactoryRecipe.Type.ID, TransistorFactoryRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, CircuitPressRecipe.Type.ID, CircuitPressRecipe.Type.INSTANCES);

        Registry.register(Registry.RECIPE_TYPE, Condenser1Recipe.Type.ID, Condenser1Recipe.Type.INSTANCES1);
    }


}