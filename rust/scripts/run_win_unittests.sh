#!/bin/bash
# Iterate over the executables and run them
#for executable in $executables; do
#    echo "Running $executable"
#    output=$($executable 2>&1)
#    if [ $? -ne 0 ]; then
#      echo "::error file=$executable,line=1,col=0,endColumn=10::$output"
#      exit 1
#    fi
#done
#

source $GITHUB_ENV

echo "win unittests=${WIN_UNITTESTS}"
for executable in $WIN_UNITTESTS; do
    echo "Running $WIN_UNITTESTS"
    output=$($executable 2>&1)
    if [ $? -ne 0 ]; then
      echo "::error file=$WIN_UNITTESTS,line=1,col=0,endColumn=10::$output"
      exit 1
    fi
done

