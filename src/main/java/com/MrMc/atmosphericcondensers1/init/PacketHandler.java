package com.MrMc.atmosphericcondensers1.init;

import com.MrMc.atmosphericcondensers1.atmosphericcondensers1;
import com.MrMc.atmosphericcondensers1.core.network.ClientboundUpdateEnergyStorageScreenPacket;
import com.MrMc.atmosphericcondensers1.core.network.ServerboundGetEnergyStoredPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public final class PacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(atmosphericcondensers1.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    private PacketHandler() {
    }

    public static void init() {
        int index = 0;

        INSTANCE
                .messageBuilder(ClientboundUpdateEnergyStorageScreenPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(ClientboundUpdateEnergyStorageScreenPacket::encode)
                .decoder(ClientboundUpdateEnergyStorageScreenPacket::new)
                .consumer(ClientboundUpdateEnergyStorageScreenPacket::handle).add();
        INSTANCE.messageBuilder(ServerboundGetEnergyStoredPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ServerboundGetEnergyStoredPacket::encode).decoder(ServerboundGetEnergyStoredPacket::new)
                .consumer(ServerboundGetEnergyStoredPacket::handle).add();
        atmosphericcondensers1.LOGGER.info("Registered {} packets for mod '{}'", index, atmosphericcondensers1.MOD_ID);
    }
}
