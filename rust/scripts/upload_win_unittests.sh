#!/bin/bash
cargo test --no-run # To check cargo test itself

# Run cargo test and retrieve the executable names
#executables=$(cargo test --target=x86_64-pc-windows-gnu --no-run --features mocksgx --message-format=json | jq -r "select(.profile.test == true) | .executable")
executables=$(cargo test --no-run --message-format=json | jq -r "select(.profile.test == true) | .executable")

# Check the exit code of cargo test
if [ $? -ne 0 ]; then
  echo "::error file=run_unittest.sh,line=6,col=0,endColumn=10::error script"
  exit 1
fi

#executables=$( IFS=:; printf '%s' "${executables[*]}" )
#WIN_UNITTESTS=$( IFS=:; printf '%s' "${executables[*]}" )
#echo $WIN_UNITTESTS
#echo "WIN_UNITTESTS=$( IFS=:; printf '%s' "${executables[*]}" )" >> "$GITHUB_ENV"
#echo "$GITHUB_ENV"
echo "WIN_UNITTESTS=$(echo $executables)" >> "$GITHUB_ENV"

## Iterate over the executables and run them
#for executable in $executables; do
#    echo "Running $executable"
#    output=$($executable 2>&1)
#    if [ $? -ne 0 ]; then
#      echo "::error file=$executable,line=1,col=0,endColumn=10::$output"
#      exit 1
#    fi
#done
