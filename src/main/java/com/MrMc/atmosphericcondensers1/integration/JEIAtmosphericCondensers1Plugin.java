package com.MrMc.atmosphericcondensers1.integration;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.recipe.CircuitPressRecipe;
import com.MrMc.atmosphericcondensers1.recipe.Condenser1Recipe;
import com.MrMc.atmosphericcondensers1.recipe.TransistorFactoryRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import mezz.jei.api.recipe.RecipeType;


import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIAtmosphericCondensers1Plugin extends BlockLoot implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(atmosphericcondensers1.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                TransistorFactoryRecipeCatagory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                CircuitBoardPressCatagory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                CondenserHousingCatagory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<TransistorFactoryRecipe> recipes = rm.getAllRecipesFor(TransistorFactoryRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(TransistorFactoryRecipeCatagory.UID, TransistorFactoryRecipe.class), recipes);

        List<CircuitPressRecipe> recipesC = rm.getAllRecipesFor(CircuitPressRecipe.Type.INSTANCES);
        registration.addRecipes(new RecipeType<>(CircuitBoardPressCatagory.UID, CircuitPressRecipe.class), recipesC);

        List<Condenser1Recipe> recipesB = rm.getAllRecipesFor(Condenser1Recipe.Type.INSTANCES1);
        registration.addRecipes(new RecipeType<>(CondenserHousingCatagory.UID, Condenser1Recipe.class), recipesB);
    }
}





























