#!/usr/bin/env bash

echo KotlinUtils CI All Build Script

# Build Client Server
echo "Building KotlinUtils"

./gradlew build
./gradlew test
./gradlew dokka
./gradlew shadowJar

echo "Finished Building KotlinUtils"
