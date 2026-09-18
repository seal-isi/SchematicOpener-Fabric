package com.example.schematiicopener;

import net.fabricmc.api.ClientModInitializer;

public final class SchematicOpenerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyHandler.initialize();
        ScreenHandler.initialize();
    }
}
