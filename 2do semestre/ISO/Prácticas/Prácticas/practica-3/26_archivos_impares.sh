if [ $# -eq 0 ]; then
    echo "Se debe ingresar al menos un parametro"
    exit 1
fi

inexistentes=0

for ((i = 1; i <= $#; i++)); do
    if [ $(expr $i % 2) -ne 0 ]; then
        eval parametro=\$$i
        if [ -e $parametro ]; then
            if [ -f $parametro ]; then
                echo "El archivo '$parametro' es un archivo normal"
            elif [ -d $parametro ]; then
                echo "El archivo '$parametro' es un directorio"
            else
                echo "El archivo '$parametro' es otro tipo de archivo"
            fi
        else
            let inexistentes++
            echo "El archivo '$parametro' no existe"
        fi
    fi
done

echo
echo "Cantidad de archivos inexistentes: $inexistentes"

exit 0
