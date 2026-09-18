@echo off
setlocal
where java >nul 2>nul || (echo Java 25 is required. Install a JDK 25 and try again.& exit /b 1)
java -version 2>&1 | findstr /C:"25." >nul || (echo Java 25 is required. Install a JDK 25 and try again.& exit /b 1)
call gradlew.bat build
if errorlevel 1 exit /b %errorlevel%
if not exist "%APPDATA%\.minecraft\mods" mkdir "%APPDATA%\.minecraft\mods"
copy /Y "build\libs\SchematicOpener-1.0.0.jar" "%APPDATA%\.minecraft\mods\"
echo Built and copied SchematicOpener-1.0.0.jar to your Minecraft mods folder.
