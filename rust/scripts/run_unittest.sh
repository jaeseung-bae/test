#!/bin/bash

# Run cargo test and retrieve the executable names
#executables=$(cargo test --target=x86_64-pc-windows-gnu --no-run --features mocksgx --message-format=json | jq -r "select(.profile.test == true) | .executable")
executables=$(cargo test --no-run --message-format=json | jq -r "select(.profile.test == true) | .executable")

# Check the exit code of cargo test
if [ $? -ne 0 ]; then
  echo "::error file=run_win_unittest.sh,line=0,col=0,endColumn=0::cargo test --no-run failed"
  exit 1
fi

# Iterate over the executables and run them
for executable in $executables; do
    echo "Running $executable"
    output=$($executable 2>&1)
    if [ $? -ne 0 ]; then
      echo "::error file=$executable,line=0,col=0,endColumn=0::$output"
    fi
done
