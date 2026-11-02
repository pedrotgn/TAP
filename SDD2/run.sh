#!/usr/bin/env bash
# Small helper so you do not need an IDE. Needs a JDK (8 or newer).
#
#   ./run.sh test                  unit + characterization tests (they pass today)
#   ./run.sh acceptance [Class]    acceptance tests (they FAIL until you do the task)
#   ./run.sh demo                  run bookstore.Main
#   ./run.sh reproduce-author      reproduce the bug shown in class
#   ./run.sh reproduce-lowstock    reproduce the bug of exercise E2
#   ./run.sh perf                  measure OrderService.quote (exercise E4)
#   ./run.sh solutions             check every reference solution
set -euo pipefail
cd "$(dirname "$0")"

LIBS="lib/junit-4.13.2.jar:lib/hamcrest-all-1.0.jar"
UNIT_TESTS="bookstore.service.BookServiceTest bookstore.service.OrderServiceCharacterizationTest"
ALL_ACCEPTANCE="AuthorCaseAcceptanceTest LowStockAcceptanceTest PriceRangeAcceptanceTest QuotePerformanceAcceptanceTest"

# build <out-dir> [overlay-dir]: compile src (+ overlay files on top), test and acceptance
build() {
  local out=$1 overlay=${2:-}
  rm -rf "$out"
  mkdir -p "$out/main" "$out/test" "$out/acceptance"
  local srcs
  srcs=$(mktemp -d)
  cp -r src/. "$srcs"
  if [ -n "$overlay" ]; then cp -r "$overlay"/. "$srcs"; fi
  javac --release 8 -Xlint:-options -d "$out/main" $(find "$srcs" -name '*.java')
  javac --release 8 -Xlint:-options -cp "$out/main:$LIBS" -d "$out/test" $(find test -name '*.java')
  javac --release 8 -Xlint:-options -cp "$out/main:$LIBS" -d "$out/acceptance" $(find acceptance -name '*.java')
  rm -rf "$srcs"
}

junit() {  # junit <out-dir> <class>...
  local out=$1; shift
  java -cp "$out/main:$out/test:$out/acceptance:$LIBS" org.junit.runner.JUnitCore "$@"
}

prefix() { for c in "$@"; do printf 'bookstore.service.%s ' "$c"; done; }

case "${1:-test}" in
  test)
    build out
    junit out $UNIT_TESTS
    ;;
  acceptance)
    build out
    if [ -n "${2:-}" ]; then junit out "bookstore.service.$2" || true
    else junit out $(prefix $ALL_ACCEPTANCE) || true; fi
    ;;
  demo)
    build out; java -cp out/main bookstore.Main ;;
  reproduce-author)
    build out; java -cp out/main tools.ReproduceAuthorBug ;;
  reproduce-lowstock)
    build out; java -cp out/main tools.ReproduceLowStock ;;
  perf)
    build out; java -cp out/main tools.PerfCheck ;;
  solutions)
    # Each reference solution replaces some files of src/. All the normal tests
    # must still pass and the acceptance test of that task must pass too.
    check() {  # check <solution-dir> <acceptance classes...>
      local name=$1; shift
      echo "=== solution: $name"
      build "out-$name" "solutions/$name/src"
      junit "out-$name" $UNIT_TESTS $(prefix "$@") | tail -3
      rm -rf "out-$name"
    }
    check bugfix-author   AuthorCaseAcceptanceTest
    check bugfix-lowstock LowStockAcceptanceTest
    check feature         PriceRangeAcceptanceTest
    check perf            QuotePerformanceAcceptanceTest
    check refactor        # no acceptance test: the unit tests are the invariant
    ;;
  *)
    echo "Usage: $0 [test|acceptance|demo|reproduce-author|reproduce-lowstock|perf|solutions]"
    exit 2
    ;;
esac
