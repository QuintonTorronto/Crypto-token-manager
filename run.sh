#!/bin/bash 

# Colors for Cosmetic Appearance 
GREEN='\033[1;32m'
RED='\033[1;31m'
CYAN='\033[1;36m'
RESET='\033[0m'

MAIN_CLASS="com.crypto.tokenmanager.app.CryptoTokenApp"
OUT_DIR="out"
LIB_DIR="lib"
SRC_DIR="src"
SOURCES_FILE="sources.txt"

echo -e "${CYAN}🚀 Launching Crypto Token Manager...${RESET}"

# Detect platform-specific classpath separator (MacOS/Linux/Windows)
SEP=":"
case "$(uname -s)" in
    CYGWIN*|MINGW*|MSYS*|Windows_NT)
        SEP=";"
        ;;
esac

# Check if compiled .class files exist
if [ ! -f "$OUT_DIR/${MAIN_CLASS//.//}.class" ]; then
    echo -e "${CYAN}🔍 Build artifacts not found. Building first...${RESET}"
    ./build.sh || {
        echo -e "${RED}❌ Build failed. Aborting run.${RESET}"
        exit 1
    }
fi

# Load environment variables
if [ -f .env ]; then
    export $(grep -v '^#' .env | xargs)
    echo -e "${CYAN}📦 .env variables loaded successfully.${RESET}"
else
    echo -e "${RED}⚠️  .env file not found. DB connection may fail!${RESET}"
fi

# Run the compiled Java app
echo -e "${CYAN}🧠 Starting application...${RESET}"
java -cp "$LIB_DIR/*${SEP}${OUT_DIR}" "$MAIN_CLASS"

# End
echo -e "${GREEN}✅ Application exited.${RESET}"
