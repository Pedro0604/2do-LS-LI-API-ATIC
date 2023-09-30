#!/bin/bash

cant_veces=0
while [ true ]; do
    if [ $(ps -e | grep -w "apache" | wc -l) -gt 1 ]; then
        let cant_veces++
        if [ $cant_veces -eq 10 ]; then
            killall apache
            break
        fi
    fi
    sleep 5
done
echo "Apache fue detectado corriendo diez veces"
exit 50
