#!/usr/bin/env sh
set -eu
java -version 2>&1 | grep -q '25\.' || { echo 'Java 25 is required.'; exit 1; }
./gradlew build
mods_dir="${HOME}/.minecraft/mods"
mkdir -p "$mods_dir"
cp "build/libs/SchematicOpener-1.0.0.jar" "$mods_dir/"
echo "Built and copied SchematicOpener-1.0.0.jar to $mods_dir"
