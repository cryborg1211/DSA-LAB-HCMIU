#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
mkdir -p "$ROOT_DIR/out"

javac --release 17 -cp "$ROOT_DIR/lib/micromouse-framework.jar" \
  -d "$ROOT_DIR/out" \
  "$ROOT_DIR/src/student/StudentSolverImpl.java"

echo "Compiled student solver to $ROOT_DIR/out"
