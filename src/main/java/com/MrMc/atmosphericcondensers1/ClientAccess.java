package com.MrMc.atmosphericcondensers1;

import com.MrMc.atmosphericcondensers1.init.screen.CondenserHousingScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

@SuppressWarnings("resource")
public class ClientAccess {

    public static void updateEnergyStorage(int energy) {
        final Screen screen = Minecraft.getInstance().screen;
        if (screen instanceof final CondenserHousingScreen energyStorage) {
            energyStorage.setEnergy(energy);
        }
    }
}
