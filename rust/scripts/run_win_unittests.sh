#!/bin/bash

directory_path=$1

if [ -z "$directory_path" ]; then
  echo "Please provide the directory path."
  exit 1
fi

cd "$directory_path"

for file in *; do
  if [ -x "$file" ]; then
    "./$file"
  fi
done
cd -