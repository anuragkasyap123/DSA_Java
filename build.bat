@echo off
setlocal

if not exist build\classes mkdir build\classes
javac -d build\classes Arrays\*.java

if errorlevel 1 (
    echo Build failed.
    exit /b 1
)

echo Build succeeded. Class files are in build\classes.
