# Schematic Opener (Fabric)

Client-side Fabric mod for Minecraft 26.2. It adds **Open Schematics Folder** to the pause menu and a customizable **K** keybind.

## Build

Install JDK 25, then generate the Gradle wrapper once with Gradle 9.5.1 (`gradle wrapper`) or copy the wrapper files from the official Fabric example project. Run `BUILD_MOD.bat` on Windows or `./BUILD_MOD.sh` on macOS/Linux. The finished JAR is `build/libs/SchematicOpener-1.0.0.jar`.

The mod looks first for `Litematica/Schematics` in the active Minecraft game directory, then falls back to `schematics`; it creates the chosen folder if needed.
