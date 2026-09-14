@echo off
setlocal

if not exist build\classes mkdir build\classes
dir /s /b *.java > build\sources.txt
javac -d build\classes @build\sources.txt

if errorlevel 1 (
    echo Build failed.
    exit /b 1
)

echo Build succeeded. Class files are in build\classes.
