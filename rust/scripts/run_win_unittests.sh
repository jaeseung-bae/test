#!/bin/bash
for executable in *; do
  if [ -x "$executable" ]; then
    ./"$executable"
  fi
done

