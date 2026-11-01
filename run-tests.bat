@echo off
set LEVEL=%1
if "%LEVEL%"=="" set LEVEL=all

echo Compilando codigo...
if not exist bin mkdir bin

javac -encoding UTF-8 -d bin src\main\java\com\exercise\model\*.java src\main\java\com\exercise\data\*.java
if %ERRORLEVEL% NEQ 0 (
    echo Error al compilar src/main/java
    exit /b %ERRORLEVEL%
)

if not exist lib mkdir lib
if not exist lib\junit-platform-console-standalone-1.10.2.jar (
    echo Descargando JUnit Platform Standalone...
    powershell -Command "Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar' -OutFile 'lib\junit-platform-console-standalone-1.10.2.jar'"
)

javac -encoding UTF-8 -cp "bin;lib\junit-platform-console-standalone-1.10.2.jar" -d bin src\test\java\com\exercise\*.java
if %ERRORLEVEL% NEQ 0 (
    echo Error al compilar src/test/java
    exit /b %ERRORLEVEL%
)

echo Ejecutando tests...
if /I "%LEVEL%"=="easy" (
    java -jar lib\junit-platform-console-standalone-1.10.2.jar execute -cp bin --select-class com.exercise.EasyStreamExercisesTest
) else if /I "%LEVEL%"=="intermediate" (
    java -jar lib\junit-platform-console-standalone-1.10.2.jar execute -cp bin --select-class com.exercise.IntermediateStreamExercisesTest
) else if /I "%LEVEL%"=="advanced" (
    java -jar lib\junit-platform-console-standalone-1.10.2.jar execute -cp bin --select-class com.exercise.AdvancedStreamExercisesTest
) else (
    java -jar lib\junit-platform-console-standalone-1.10.2.jar execute -cp bin --select-package com.exercise
)

