#!/bin/bash

# colors for Cosmetic Appearance
GREEN='\033[1;32m'
RED='\033[1;31m'
YELLOW='\033[1;33m'
CYAN='\033[1;36m'
RESET='\033[0m'

# Metadata
SRC_DIR="src"
OUT_DIR="out"
LIB_DIR="lib"
SOURCES_FILE="sources.txt"

echo -e "${CYAN}🔧 Building Crypto Token Manager...${RESET}"

# Step 1: Clean previous build
echo -e "${YELLOW}🧹 Cleaning old build...${RESET}"
rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR"

# Step 2: Compile Java sources
echo -e "${CYAN}📦 Compiling source files...${RESET}"
javac -d "$OUT_DIR" -cp "$LIB_DIR/*" @"$SOURCES_FILE"

# Step 3: Check build status
if [ $? -eq 0 ]; then
    echo -e "${GREEN}✅ Build successful! Classes saved in ${OUT_DIR}/ ${RESET}"
else
    echo -e "${RED}❌ Build failed. Please check for compilation errors.${RESET}"
    exit 1
fi
