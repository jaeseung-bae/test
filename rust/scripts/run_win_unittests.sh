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

for file in *; do
  if [ -x "$file" ]; then
    ./"$file"
  fi
done

