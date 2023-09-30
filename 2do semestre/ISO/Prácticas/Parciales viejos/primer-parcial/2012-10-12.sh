#!/bin/bash

extension=".conf"
directorio="/etc"

array=()
for archivo in $(sudo find $directorio -type f -name "*$extension"); do
    array+=($archivo)
done

cantidad() {
    echo "La cantidad de archivos $extension en '$directorio' es: ${#array[*]}"
}

verArchivos() {
    for archivo in ${array[*]}; do
        echo $archivo
    done
}

existe() {
    for archivo in ${array[*]}; do
        if [ $(basename $archivo) = $(basename $1) ]; then
            echo "El archivo '$1' existe"
            return 0
        fi
    done
    echo "El archivo '$1' no existe"
    return 1
}

eliminar() {
    for ((i = 0; i < ${#array[*]}; i++)); do
        if [ $(basename ${array[i]}) = $(basename $1) ]; then
            case $2 in
            "logico")
                unset array[$i]
                echo "Archivo '$1' eliminado logicamente"
                array=(${array[*]})
                return 0
                ;;
            "fisico")
                sudo rm ${array[i]}
                unset array[$i]
                echo "Archivo '$1' eliminado fisicamente"
                array=(${array[*]})
                return 0
                ;;
            *)
                echo "Operacion incorrecta"
                return 1
                ;;
            esac
        fi
    done
    echo "El archivo '$1' no existe"
    return 2
}

select opcion in "cantidad" "verArchivos" "existe" "eliminar"; do
    case $opcion in
    cantidad)
        cantidad
        ;;
    verArchivos)
        verArchivos
        ;;
    existe)
        echo "Ingrese el nombre de un archivo con la extension $extension"
        read archivo
        existe $archivo
        ;;
    eliminar)
        echo "Ingrese el nombre de un archivo con la extension $extension"
        read archivo
        echo "Quiere eliminar el archivo '$archivo' logica o fisicamente? (logico/fisico)"
        read tipo_eliminacion
        eliminar $archivo $tipo_eliminacion
        ;;
    *)
        echo "Opción incorrecta"
        ;;
    esac
done
exit 0
