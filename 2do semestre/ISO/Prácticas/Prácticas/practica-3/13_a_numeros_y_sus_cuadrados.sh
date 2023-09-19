#!/bin/bash

echo " N° | ^2"
for ((i = 1; i <= 100; i++)); do
    echo " $i | $(expr $i \* $i)"
done

exit 0
