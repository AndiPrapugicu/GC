#!/bin/zsh
set -euo pipefail

# Auto-detects Android project roots by folder name and settings.gradle* presence,
# then calls apply_solutions_to_android_projects.sh.

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

find_project_root() {
  local name="$1"
  local found

  found=$(find "$HOME" -type f \( -name "settings.gradle" -o -name "settings.gradle.kts" \) \
    -path "*/$name/*" 2>/dev/null | head -n 1 || true)

  if [[ -z "$found" ]]; then
    echo ""
    return
  fi

  dirname "$found"
}

HELLO_ROOT="$(find_project_root "HelloWorld")"
SQUARE_ROOT="$(find_project_root "BouncySquare")"
CUBE_ROOT="$(find_project_root "BouncyCube")"
INTRO_ROOT="$(find_project_root "MyFirstApp")"

if [[ -z "$HELLO_ROOT" || -z "$SQUARE_ROOT" || -z "$CUBE_ROOT" || -z "$INTRO_ROOT" ]]; then
  echo "Could not detect all projects automatically."
  echo "Detected:"
  echo "HelloWorld: ${HELLO_ROOT:-NOT_FOUND}"
  echo "BouncySquare: ${SQUARE_ROOT:-NOT_FOUND}"
  echo "BouncyCube: ${CUBE_ROOT:-NOT_FOUND}"
  echo "MyFirstApp: ${INTRO_ROOT:-NOT_FOUND}"
  echo "Create missing projects in Android Studio, then run again."
  exit 1
fi

echo "Detected project roots:"
echo "HelloWorld: $HELLO_ROOT"
echo "BouncySquare: $SQUARE_ROOT"
echo "BouncyCube: $CUBE_ROOT"
echo "MyFirstApp: $INTRO_ROOT"

"$SCRIPT_DIR/apply_solutions_to_android_projects.sh" \
  "$HELLO_ROOT" \
  "$SQUARE_ROOT" \
  "$CUBE_ROOT" \
  "$INTRO_ROOT"
