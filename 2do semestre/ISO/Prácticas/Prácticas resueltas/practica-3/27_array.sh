inicializar() {
    array=()
}

agregar_elemento() {
    array=(${array[*]} $1)
}

eliminar_elemento() {
    if [ $1 -lt ${#array[*]} ]; then
        if [ -n ${array[$1]} ]; then
            echo "El elemento" ${array[$1]} "ha sido eliminado"
            unset array[$1]
        else
            echo "La posicion $1 esta vacia"
        fi
    else
        echo "La posicion $1 no es una posicion valida"
        return 1
    fi
}

longitud() {
    echo ${#array[*]}
}

imprimir() {
    echo ${array[*]}
}

inicializar_con_valores() {
    if [ $# -lt 2 ]; then
        echo "Debe ingresar dos valores"
        return 1
    fi
    array=()
    for i in $(seq 0 $(expr $1 - 1)); do
        array[$i]=$2
    done
}

select opcion in "inicializar" "agregar_elemento" "eliminar_elemento" "longitud" "imprimir" "inicializar_con_valores" "salir"; do
    case $opcion in
    inicializar)
        inicializar
        ;;
    agregar_elemento)
        echo "Ingrese elemento para agregar al arreglo:"
        read elemento
        agregar_elemento $elemento
        ;;
    eliminar_elemento)
        echo "Ingrese la posicion del elemento a eliminar del arreglo:"
        read elemento
        eliminar_elemento $elemento
        ;;
    longitud)
        longitud
        ;;
    imprimir)
        imprimir
        ;;
    inicializar_con_valores)
        echo "Ingrese el valor de el tamaño del nuevo arreglo:"
        read tamanio
        echo "Ingrese el valor a insertar en todas las posiciones del arreglo:"
        read valor
        inicializar_con_valores $tamanio $valor
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
