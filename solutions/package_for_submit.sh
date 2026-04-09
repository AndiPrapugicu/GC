#!/bin/zsh
set -euo pipefail

# Creeaza o arhiva cu toate fisierele de predare.
OUT="predare_cg_solutions.zip"
BASE_DIR="$(cd "$(dirname "$0")" && pwd)"

cd "$BASE_DIR"
rm -f "$OUT"

zip -r "$OUT" \
  README.md \
  SUBMISSION_READY.md \
  DEMO_SCRIPT.md \
  lab1 \
  lab2 \
  lab3 \
  intro_android

echo "Arhiva creata: $BASE_DIR/$OUT"
