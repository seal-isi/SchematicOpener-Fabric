package com.example.schematiicopener;

import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.network.chat.Component;

final class ScreenHandler {
    private ScreenHandler() { }

    static void initialize() {
        ScreenEvents.AFTER_INIT.register((client, screen, width, height) -> {
            if (screen instanceof PauseScreen) {
                screen.addRenderableWidget(Button.builder(
                                Component.translatable("screen.schematiicopener.open_folder"),
                                button -> FileOpener.openSchematicsFolder(client))
                        .bounds(width / 2 - 100, height / 2 + 40, 200, 20)
                        .build());
            }
        });
    }
}
