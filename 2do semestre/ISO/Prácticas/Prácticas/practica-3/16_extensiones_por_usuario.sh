if [ $# -ne 1 ]; then
    echo "Debe ingresar un parametro"
    exit 1
fi

if [ $(echo $1 | cut -c 1) != "." ]; then
    echo "El parametro ingresado '$1' no es una extension"
    echo "Deberia ser de la forma .ejemplo"
    exit 2
fi

if [ ! -f "./16_reporte.txt" ]; then
    echo "Usuario  |  Extension  |  Cantidad de lineas" >"./16_reporte.txt"
fi

users=$(cut -d":" -f1 /etc/passwd)

for user in $users; do
    if [ -d /home/$user ]; then
        cant_lineas=$(sudo find "/home/$user" -name "*$1" -user $user 2>&1 | grep -v "Permiso denegado" | wc -l)
        echo "$user  |  $1  |  $cant_lineas" >>"./16_reporte.txt"
    fi
done

exit 0
