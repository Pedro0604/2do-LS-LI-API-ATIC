users=()

if [ $# -gt 2 ]; then
    echo "Cantidad erronea de parametros"
    exit1
fi

for user in $(cat "/etc/group" | grep "users" | cut -d":" -f4); do
    users[${#users[*]}]=$user
done

if [ $# -ge 1 ]; then
    if [ $1 = "-b" ]; then
        if [ $# -ne 2 ]; then
            echo "Si ingresa el flag -b, debe ingresar un segundo parametro"
            echo "que indique la posicion del elemento a imprimir"
            exit 2
        elif [ $2 -lt ${#users[*]} ]; then
            echo ${users[$2]}
        else
            echo "La posicion '$2' no corresponde al arreglo"
            exit 3
        fi
    elif [ $1 = -l ]; then
        echo ${#users[*]}
    elif [ $1 = -i ]; then
        echo ${users[*]}
    else
        echo "El flag ingresado no es valido"
        exit 4
    fi
fi

exit 0
