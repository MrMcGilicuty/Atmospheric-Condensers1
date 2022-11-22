package com.MrMc.atmospheric_condensers.integration;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;
import com.MrMc.atmospheric_condensers.init.BlockInit;
import com.MrMc.atmospheric_condensers.recipe.TransistorFactoryRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;


import javax.annotation.Nonnull;

public class TransistorFactoryRecipeCatagory implements IRecipeCategory<TransistorFactoryRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(AtmosphericCondensers.MOD_ID, "transistor_fabrication");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(AtmosphericCondensers.MOD_ID, "textures/gui/transistor_factory_jei_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final ItemStack renderStack = new ItemStack(BlockInit.TRANSISTOR_FACTORY.get());

        public TransistorFactoryRecipeCatagory(IGuiHelper helper) {
            this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
            this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, renderStack);
        }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends TransistorFactoryRecipe> getRecipeClass() {
        return TransistorFactoryRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Transistor Factory");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull TransistorFactoryRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT,  80, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,  62, 58).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,  80, 62).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,  98, 58).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT,  152, 33).addItemStack(recipe.getResultItem());
    }

}

