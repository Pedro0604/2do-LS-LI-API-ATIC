array=()
directorio="/home/pepox0604/docs/"

verArchivo() {
    for archivo in ${array[*]}; do
        if [ $(basename $archivo .doc) = $1 ] || [ $(basename $archivo) = $1 ]; then
            echo $archivo
            return 0
        fi
    done
    echo "Archivo no encontrado"
    return 5
}

borrarArchivo() {
    echo "Desea borrar el archivo logicamente?(S/N)"
    read respuesta

    for ((i = 0; i < ${#array[*]}; i++)); do
        if [ $(basename ${array[i]} .doc) = $1 ] || [ $(basename ${array[i]}) = $1 ]; then
            if [ $respuesta = "S" ] || [ $respuesta = "s" ]; then
                unset array[$i]
                echo "Archivo borrado logicamente"
            else
                rm ${array[i]}
                unset array[$i]
                echo "Archivo borrado fisicamente"
            fi
            return 0
        fi
    done

    echo "Archivo no encontrado"
    return 5
}

for archivo in $(find $directorio -type f -name "*.doc"); do
    array+=($archivo)
done

select opcion in "Ver archivo" "Borrar archivo" "length" "print" "salir"; do
    case $opcion in
    "Ver archivo")
        echo "Ingrese el nombre del archivo"
        read archivo
        verArchivo $archivo
        ;;
    "Borrar archivo")
        echo "Ingrese el nombre del archivo"
        read archivo
        borrarArchivo $archivo
        ;;
    length)
        echo ${#array[*]}
        ;;
    print)
        if [ ${#array[*]} -ne 0 ]; then
            echo ${array[*]}
        else
            echo "El directorio $directorio no tiene ningun archivo .doc"
        fi
        ;;
    salir)
        break
        ;;
    *)
        echo "Opcion invalida"
        ;;
    esac
done

exit 0
