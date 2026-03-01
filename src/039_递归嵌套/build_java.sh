#!/usr/bin/env bash
set -euo pipefail

# Script location: .../src/039_递归嵌套
# Project root:    .../AlgorithmLearning
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/../.." && pwd)"
OUT_DIR="$PROJECT_ROOT/out/production/AlgorithmLearning"

usage() {
  cat <<'USAGE'
Usage:
  ./build_java.sh
  ./build_java.sh <MainClass>

Examples:
  ./build_java.sh
  ./build_java.sh recursion_038.Code_07_TowerOfHanoi
USAGE
}

if [[ "${1:-}" == "-h" || "${1:-}" == "--help" ]]; then
  usage
  exit 0
fi

mkdir -p "$OUT_DIR"

# Collect all Java files under src/ (compatible with older bash versions)
JAVA_FILES=()
while IFS= read -r file; do
  JAVA_FILES+=("$file")
done < <(find "$PROJECT_ROOT/src" -type f -name "*.java" | sort)

if [[ ${#JAVA_FILES[@]} -eq 0 ]]; then
  echo "No .java files found under $PROJECT_ROOT/src"
  exit 1
fi

echo "Compiling ${#JAVA_FILES[@]} Java files to: $OUT_DIR"
javac -encoding UTF-8 -d "$OUT_DIR" "${JAVA_FILES[@]}"
echo "Compile finished."

if [[ $# -ge 1 ]]; then
  MAIN_CLASS="$1"
  echo "Running: $MAIN_CLASS"
  java -cp "$OUT_DIR" "$MAIN_CLASS"
fi
