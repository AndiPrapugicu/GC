#!/bin/zsh
set -euo pipefail

echo "== Android environment check =="

if [[ -d "/Applications/Android Studio.app" ]]; then
  echo "Android Studio app: OK"
else
  echo "Android Studio app: MISSING (/Applications/Android Studio.app)"
fi

SDK_DEFAULT="$HOME/Library/Android/sdk"
if [[ -d "$SDK_DEFAULT" ]]; then
  echo "SDK dir: OK ($SDK_DEFAULT)"
else
  echo "SDK dir: MISSING ($SDK_DEFAULT)"
fi

ADB="$SDK_DEFAULT/platform-tools/adb"
EMU="$SDK_DEFAULT/emulator/emulator"

if [[ -x "$ADB" ]]; then
  echo "adb: OK"
  "$ADB" --version | head -n 1
else
  echo "adb: MISSING ($ADB)"
fi

if [[ -x "$EMU" ]]; then
  echo "emulator: OK"
  "$EMU" -version | head -n 1
else
  echo "emulator: MISSING ($EMU)"
fi

echo "\nIf sdk tools are missing:"
echo "1) Open Android Studio"
echo "2) More Actions -> SDK Manager"
echo "3) Install Android SDK Platform-Tools and Android Emulator"
