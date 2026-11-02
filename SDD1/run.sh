#!/usr/bin/env bash
# Small helper so you do not need an IDE. Needs a JDK (8 or newer).
#
#   ./run.sh test     compile and run the unit tests
#   ./run.sh demo     run bookstore.Main
#   ./run.sh check    run the convention checker on bookstore and on legacy
#   ./run.sh extra    run the checker with the extra rules of exercise 3
set -euo pipefail
cd "$(dirname "$0")"

LIBS="lib/junit-4.13.2.jar:lib/hamcrest-all-1.0.jar"
OUT=out

build() {
  rm -rf "$OUT"
  mkdir -p "$OUT/main" "$OUT/test"
  javac --release 8 -Xlint:-options -d "$OUT/main" $(find src -name '*.java')
  javac --release 8 -Xlint:-options -cp "$OUT/main:$LIBS" -d "$OUT/test" $(find test -name '*.java')
}

case "${1:-test}" in
  test)
    build
    java -cp "$OUT/main:$OUT/test:$LIBS" org.junit.runner.JUnitCore \
      bookstore.service.BookServiceTest checker.ConventionCheckerTest
    ;;
  demo)
    build
    java -cp "$OUT/main" bookstore.Main
    ;;
  check)
    build
    java -cp "$OUT/main" checker.ConventionChecker "$OUT/main" bookstore || true
    echo
    java -cp "$OUT/main" checker.ConventionChecker "$OUT/main" legacy || true
    ;;
  extra)
    build
    java -cp "$OUT/main" solutions.CheckAll "$OUT/main" bookstore
    ;;
  *)
    echo "Usage: $0 [test|demo|check|extra]"
    exit 2
    ;;
esac
