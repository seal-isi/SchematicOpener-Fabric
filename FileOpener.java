package com.example.schematiicopener;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

final class FileOpener {
    private FileOpener() { }

    static void openSchematicsFolder(Minecraft client) {
        Path folder = resolveFolder();
        try {
            Files.createDirectories(folder);
            open(folder);
            if (client.player != null) {
                client.player.displayClientMessage(Component.literal("Opened schematics folder."), true);
            }
        } catch (IOException | UnsupportedOperationException exception) {
            if (client.player != null) {
                client.player.displayClientMessage(Component.literal("Could not open schematics folder: " + exception.getMessage()), false);
            }
        }
    }

    private static Path resolveFolder() {
        Path gameDirectory = FabricLoader.getInstance().getGameDir();
        List<Path> candidates = List.of(
                gameDirectory.resolve("Litematica").resolve("Schematics"),
                gameDirectory.resolve("schematics")
        );
        return candidates.stream().filter(Files::isDirectory).findFirst().orElse(candidates.getFirst());
    }

    private static void open(Path folder) throws IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            Desktop.getDesktop().open(folder.toFile());
            return;
        }

        String os = System.getProperty("os.name", "").toLowerCase();
        if (os.contains("win")) {
            new ProcessBuilder("explorer.exe", folder.toString()).start();
        } else if (os.contains("mac")) {
            new ProcessBuilder("open", folder.toString()).start();
        } else {
            new ProcessBuilder("xdg-open", folder.toString()).start();
        }
    }
}
