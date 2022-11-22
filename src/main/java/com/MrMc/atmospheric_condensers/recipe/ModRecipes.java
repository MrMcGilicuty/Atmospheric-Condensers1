package com.MrMc.atmospheric_condensers.recipe;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AtmosphericCondensers.MOD_ID);

    public static final RegistryObject<RecipeSerializer<TransistorFactoryRecipe>> TRANSISTOR_FACTORY_SERIALIZER =
            SERIALIZERS.register("transistor_fabrication", () -> TransistorFactoryRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CircuitPressRecipe>> CIRCUIT_PRESS_SERIALIZER =
            SERIALIZERS.register("pressing", () -> CircuitPressRecipe.Serializer.INSTANCES);

    public static final RegistryObject<RecipeSerializer<Condenser1Recipe>> CONDENSER_HOUSING_SERIALIZER =
            SERIALIZERS.register("condensing", () -> Condenser1Recipe.Serializer.INSTANCES1);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

}

