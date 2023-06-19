package org.shadowmaster435.solar_apocalypse.client;

import net.fabricmc.api.ClientModInitializer;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;

public class SolarApocalypseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlocks.init_client();
    }
}
