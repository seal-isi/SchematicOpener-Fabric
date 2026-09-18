package com.example.schematiicopener;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

final class KeyHandler {
    private static final KeyMapping OPEN_FOLDER = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.schematiicopener.open_folder",
            new KeyEvent(GLFW.GLFW_KEY_K, GLFW.GLFW_KEY_UNKNOWN),
            KeyMapping.Category.register("key.category.schematiicopener")
    ));

    private KeyHandler() { }

    static void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_FOLDER.consumeClick()) {
                FileOpener.openSchematicsFolder(client);
            }
        });
    }
}
