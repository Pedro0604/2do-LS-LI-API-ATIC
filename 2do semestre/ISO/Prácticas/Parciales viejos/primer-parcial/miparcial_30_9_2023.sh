#!/bin/bash
# Crear un array con los nombres de los archivos regulares que se encuentran en un directorio pasado por parametro
# Crear una funcion que elimine un archivo del array y también lo elimine físicamente
# Crear una funcion que imprima el índice de un archivo en el array
# Crear una funcion que imprima la cantidad de archivos en el array
# Crear una funcion que liste los archivos del array
# Crear un menú que permita ejecutar las funciones anteriores
# El menú debe tener una opción para salir
# Al finalizar informar la cantidad de veces que se ejecutó una operación sobre el directorio (array)

if [ $# -ne 1 ]; then
    echo "Error: Cantidad de parametros erronea"
    exit 1
fi

if [ ! -d $1 ]; then
    echo "Error: El parametro '$1' no es un directorio"
    exit 2
fi

array=()

for archivo in $(ls $1); do
    if [ -f "$1/$archivo" ]; then
        array+=($archivo)
    fi
done

directorio=$1

delete() {
    echo "Ingrese el nombre del archivo a eliminar"
    read nombre
    for ((i = 0; i < ${#array[*]}; i++)); do
        if [ ${array[i]} = $nombre ]; then
            rm "$directorio/$nombre"
            unset array[$i]
            array=(${array[*]}) # Compactar el array
            echo "Archivo '$nombre' eliminado"
            return 0
        fi
    done
    echo "Error: El archivo '$nombre' no existe"
    return 1
}

index() {
    echo "Ingrese el nombre de un archivo"
    read nombre
    for ((i = 0; i < ${#array[*]}; i++)); do
        if [ ${array[i]} = $nombre ]; then
            echo $i
            return 0
        fi
    done
    echo "Error: El archivo '$nombre' no existe"
    return 1
}

size() {
    echo ${#array[*]}
    return 0
}

list() {
    for archivo in ${array[*]}; do
        echo $archivo
    done
    return 0
}

cant_veces=0
select opcion in "delete" "index" "size" "list" "exit"; do
    case $opcion in
    "delete")
        let cant_veces++
        delete
        ;;
    "index")
        let cant_veces++
        index
        ;;
    "size")
        let cant_veces++
        size
        ;;
    "list")
        let cant_veces++
        list
        ;;
    "exit")
        break
        ;;
    *)
        echo "Opcion invalida"
        ;;
    esac
done

echo "Muchas gracias. Ud a ejecutado $cant_veces acciones sobre el directorio $directorio"
exit 0
