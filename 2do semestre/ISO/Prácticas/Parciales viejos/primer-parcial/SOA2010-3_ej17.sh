#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Error: Debe introducir al menos un parametro" >&2
    exit 1
fi

cant_inexistentes=0

for i in $(seq 1 $#); do
    if [ $(($i % 2)) -ne 0 ]; then
        if [ -e ${!i} ]; then
            if [ -f ${!i} ]; then
                echo "'${!i}' es un archivo"
            elif [ -d ${!i} ]; then
                echo "'${!i}' es un directorio"
            else
                echo "'${!i}' es otro tipo de archivo"
            fi
        else
            echo "'${!i}' no existe"
            let cant_inexistentes++
        fi
    fi
done

echo "Cantidad de archivos inexistentes: $cant_inexistentes"

exit 0
