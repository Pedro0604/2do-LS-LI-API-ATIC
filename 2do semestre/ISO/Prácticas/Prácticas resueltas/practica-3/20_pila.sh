pila=($*)
length=$#

select opcion in "push" "pop" "length" "print" "salir"; do
    case $opcion in
    push)
        echo "Ingrese elemento a pushear en la pila:"
        read elemento
        pila[$length]=$elemento
        length=$(expr $length + 1)
        ;;
    pop)
        if [ $length -ne 0 ]; then
            length=$(expr $length - 1)
            echo ${pila[length]}
            unset pila[$length]
        else
            echo "La pila esta vacia"
        fi
        ;;
    length)
        echo $length
        ;;
    print)
        if [ $length -ne 0 ]; then
            echo ${pila[*]}
        else
            echo "La pila esta vacia"
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
