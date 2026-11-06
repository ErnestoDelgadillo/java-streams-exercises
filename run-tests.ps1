param (
    [string]$level = "all"
)

Write-Host "Compilando proyecto Java Streams Exercises..." -ForegroundColor Cyan

# Crear carpeta bin si no existe
if (-not (Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
}

# Compilar clases principales
$mainFiles = (Get-ChildItem -Recurse -Filter *.java -Path src\main\java).FullName
javac -encoding UTF-8 -d bin $mainFiles
if ($LASTEXITCODE -ne 0) {
    Write-Host "Error al compilar src/main/java" -ForegroundColor Red
    exit $LASTEXITCODE
}

$junitJar = "lib\junit-platform-console-standalone-1.10.2.jar"
if (-not (Test-Path $junitJar)) {
    Write-Host "Descargando JUnit Platform Standalone..." -ForegroundColor Yellow
    New-Item -ItemType Directory -Force -Path "lib" | Out-Null
    Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar" -OutFile $junitJar
}

# Compilar tests
$testFiles = (Get-ChildItem -Recurse -Filter *.java -Path src\test\java).FullName
javac -encoding UTF-8 -cp "bin;$junitJar" -d bin $testFiles
if ($LASTEXITCODE -ne 0) {
    Write-Host "Error al compilar src/test/java" -ForegroundColor Red
    exit $LASTEXITCODE
}

Write-Host "Ejecutando tests de JUnit 5 (Nivel: $level)..." -ForegroundColor Green

switch ($level.ToLower()) {
    "easy" {
        java -jar $junitJar execute -cp bin --select-class com.exercise.EasyStreamExercisesTest
    }
    "intermediate" {
        java -jar $junitJar execute -cp bin --select-class com.exercise.IntermediateStreamExercisesTest
    }
    "advanced" {
        java -jar $junitJar execute -cp bin --select-class com.exercise.AdvancedStreamExercisesTest
    }
    "exam" {
        java -jar $junitJar execute -cp bin --select-class com.exercise.StreamExamTest
    }
    default {
        java -jar $junitJar execute -cp bin --select-package com.exercise
    }
}

