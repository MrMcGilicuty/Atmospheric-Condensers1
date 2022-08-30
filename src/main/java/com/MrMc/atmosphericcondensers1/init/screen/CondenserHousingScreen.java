package com.MrMc.atmosphericcondensers1.init.screen;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.init.entity.custom.CondenserHousing1BlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class CondenserHousingScreen extends AbstractContainerScreen<CondenserHousingMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(atmosphericcondensers1.MOD_ID, "textures/gui/condenser_housing_gui.png");

    private int leftPos = 0, topPos = 0;
    private int energy;

    public CondenserHousingScreen(CondenserHousingMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        inventoryLabelY = +75;
        titleLabelY = +5;
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if (menu.isCrafting()) {
            blit(pPoseStack, x + 72, y + 17, 176, 0, 18, menu.getScaledProgress());
        }
    }

    /**
    *Cool
    *Energy Stuff. None of which I understand.
    */
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float delta) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderBackground(stack);
        super.render(stack, mouseX, mouseY, delta);
        renderTooltip(stack, mouseX, mouseY);
//        bindTexture();

        final int energyStored = this.energy;
        final int maxEnergy = 32000;
        final int scaledEnergy = (int) mapNumber(energyStored, 0, maxEnergy, 0, 122);
//        bindTexture();
//        blit(stack, x + 16, y + 16 - scaledEnergy, 227, 58 - scaledEnergy, 58, scaledEnergy);

//        this.font.draw(stack, this.title, x + 7, y + 3, 0x404040);
        this.font.draw(stack, this.energy + "RF", x + 34, y + 57, 0x404040);
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }



    public static double mapNumber(double value, double rangeMin, double rangeMax, double resultMin, double resultMax) {
        return (value - rangeMin) / (rangeMax - rangeMin) * (resultMax - resultMin) + resultMin;
    }
}
