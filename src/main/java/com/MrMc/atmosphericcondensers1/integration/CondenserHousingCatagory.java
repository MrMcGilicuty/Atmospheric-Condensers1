package com.MrMc.atmosphericcondensers1.integration;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.init.BlockInit;
import com.MrMc.atmosphericcondensers1.recipe.Condenser1Recipe;
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

public class CondenserHousingCatagory implements IRecipeCategory<Condenser1Recipe> {
    public final static ResourceLocation UID = new ResourceLocation(atmosphericcondensers1.MOD_ID, "condensing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(atmosphericcondensers1.MOD_ID, "textures/gui/condenser_housing_jei_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final ItemStack renderStack = new ItemStack(BlockInit.CONDENSER.get());

    public CondenserHousingCatagory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, renderStack);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends Condenser1Recipe> getRecipeClass() {
        return Condenser1Recipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Atmospheric Condenser");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull Condenser1Recipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT,  51, 29).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,  80, 56).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,  106, 56).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 143, 8).addItemStack(recipe.getResultItem());
    }
}
