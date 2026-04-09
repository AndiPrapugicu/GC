#!/bin/zsh
set -euo pipefail

# Usage:
# ./apply_solutions_to_android_projects.sh \
#   /path/to/HelloWorld \
#   /path/to/BouncySquare \
#   /path/to/BouncyCube \
#   /path/to/MyFirstApp

if [[ $# -ne 4 ]]; then
  echo "Usage: $0 <HelloWorldRoot> <BouncySquareRoot> <BouncyCubeRoot> <MyFirstAppRoot>"
  exit 1
fi

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
HELLO_ROOT="$1"
SQUARE_ROOT="$2"
CUBE_ROOT="$3"
INTRO_ROOT="$4"

assert_project() {
  local root="$1"
  if [[ ! -d "$root/app/src/main" ]]; then
    echo "Invalid Android project path: $root"
    echo "Expected folder app/src/main to exist."
    exit 1
  fi
}

copy_java_file() {
  local src="$1"
  local project_root="$2"
  local package_path="$3"
  local file_name="$4"

  local dst_dir="$project_root/app/src/main/java/$package_path"
  mkdir -p "$dst_dir"
  cp "$src" "$dst_dir/$file_name"
}

patch_manifest_activity() {
  local project_root="$1"
  local activity_name="$2"
  local manifest="$project_root/app/src/main/AndroidManifest.xml"

  if [[ ! -f "$manifest" ]]; then
    echo "Manifest not found for $project_root; skipping manifest patch."
    return
  fi

  # Replace common default launcher activity if present.
  # This is intentionally conservative to avoid breaking custom manifests.
  sed -i '' 's/android:name="\.MainActivity"/android:name="\.'"$activity_name"'"/g' "$manifest"
}

run_gradle_check() {
  local project_root="$1"
  if [[ -x "$project_root/gradlew" ]]; then
    (cd "$project_root" && ./gradlew :app:assembleDebug >/dev/null)
    echo "Build OK: $project_root"
  else
    echo "No gradlew in $project_root; skipped build check."
  fi
}

assert_project "$HELLO_ROOT"
assert_project "$SQUARE_ROOT"
assert_project "$CUBE_ROOT"
assert_project "$INTRO_ROOT"

echo "Applying Lab 1 files..."
copy_java_file "$SCRIPT_DIR/lab1/HelloWorldActivity.java" "$HELLO_ROOT" "cg/helloworld" "HelloWorldActivity.java"
copy_java_file "$SCRIPT_DIR/lab1/HelloWorldRenderer.java" "$HELLO_ROOT" "cg/helloworld" "HelloWorldRenderer.java"
patch_manifest_activity "$HELLO_ROOT" "HelloWorldActivity"

echo "Applying Lab 2 files..."
copy_java_file "$SCRIPT_DIR/lab2/BouncySquareActivity.java" "$SQUARE_ROOT" "cg/bouncysquare" "BouncySquareActivity.java"
copy_java_file "$SCRIPT_DIR/lab2/SquareRenderer.java" "$SQUARE_ROOT" "cg/bouncysquare" "SquareRenderer.java"
copy_java_file "$SCRIPT_DIR/lab2/Square.java" "$SQUARE_ROOT" "cg/bouncysquare" "Square.java"
patch_manifest_activity "$SQUARE_ROOT" "BouncySquareActivity"

echo "Applying Lab 3 files..."
copy_java_file "$SCRIPT_DIR/lab3/BouncyCubeActivity.java" "$CUBE_ROOT" "cg/bouncycube" "BouncyCubeActivity.java"
copy_java_file "$SCRIPT_DIR/lab3/CubeRenderer.java" "$CUBE_ROOT" "cg/bouncycube" "CubeRenderer.java"
copy_java_file "$SCRIPT_DIR/lab3/Cube.java" "$CUBE_ROOT" "cg/bouncycube" "Cube.java"
patch_manifest_activity "$CUBE_ROOT" "BouncyCubeActivity"

echo "Applying Intro Android files..."
copy_java_file "$SCRIPT_DIR/intro_android/MainActivity.java" "$INTRO_ROOT" "com/example/myfirstapp" "MainActivity.java"
mkdir -p "$INTRO_ROOT/app/src/main/res/layout"
cp "$SCRIPT_DIR/intro_android/activity_main.xml" "$INTRO_ROOT/app/src/main/res/layout/activity_main.xml"

echo "Optional local build checks..."
run_gradle_check "$HELLO_ROOT"
run_gradle_check "$SQUARE_ROOT"
run_gradle_check "$CUBE_ROOT"
run_gradle_check "$INTRO_ROOT"

echo "Done. Open projects in Android Studio and Run on emulator."
