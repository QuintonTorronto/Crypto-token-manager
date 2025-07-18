#!/bin/bash

# colors for Cosmetic Appearance
GREEN='\033[1;32m'
CYAN='\033[1;36m'
RESET='\033[0m'

echo -e "${CYAN}🧹 Cleaning project workspace...${RESET}"

# Remove build output
rm -rf out

# Remove temporary files if needed
find . -type f \( -name "*.log" -o -name "*.class" \) -delete

echo -e "${GREEN}✅ Clean complete. Project is now fresh.${RESET}"
