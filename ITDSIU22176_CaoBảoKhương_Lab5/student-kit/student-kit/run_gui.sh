#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

"$ROOT_DIR/compile.sh"

java -cp "$ROOT_DIR/lib/micromouse-framework.jar:$ROOT_DIR/out" \
  mazechallenge.Main \
  student.StudentSolverImpl
