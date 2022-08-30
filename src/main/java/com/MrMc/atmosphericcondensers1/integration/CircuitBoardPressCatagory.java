package com.MrMc.atmosphericcondensers1.integration;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.init.BlockInit;
import com.MrMc.atmosphericcondensers1.recipe.CircuitPressRecipe;
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

public class CircuitBoardPressCatagory implements IRecipeCategory<CircuitPressRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(atmosphericcondensers1.MOD_ID, "pressing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(atmosphericcondensers1.MOD_ID, "textures/gui/circuit_board_press_jei_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final ItemStack renderStack = new ItemStack(BlockInit.CIRCUIT_PRESS.get());

    public CircuitBoardPressCatagory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, renderStack);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends CircuitPressRecipe> getRecipeClass() {
        return CircuitPressRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Circuit Press");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CircuitPressRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT,  80, 33).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,  53, 33).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,  80, 6).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT,  80, 60).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT,  107, 33).addIngredients(recipe.getIngredients().get(4));

        builder.addSlot(RecipeIngredientRole.OUTPUT,  152, 33).addItemStack(recipe.getResultItem());
    }
}
