if [ $# -ne 1 ]; then
    echo "Debe ingresar una extension como parametro" >&2
    exit 1
fi

if [ $(echo $1 | cut -c 1) != "." ]; then
    echo "El parametro ingresado '$1' no es una extension"
    echo "Deberia ser de la forma .ejemplo"
    exit 2
fi

if [ ! -f "./16_reporte.txt" ]; then
    echo "Creando reporte '$(pwd)/16_reporte.txt'"
else
    echo "Abriendo reporte '$(pwd)/16_reporte.txt'"
fi

users_homes=$(cut -d":" -f1,6 /etc/passwd)

echo "Cargando datos al reporte"
echo "Extension: '$1'" >>"./16_reporte.txt"
for user_home in $users_homes; do
    user=$(echo $user_home | cut -d":" -f1)
    home=$(echo $user_home | cut -d":" -f2)
    if [ -d $home ]; then
        cant_lineas=$(sudo find $home -name "*$1" 2>&1 | grep -v "Permiso denegado" | wc -l)
        echo "    Usuario: '$user' - Home: '$home' - Cantidad de lineas: '$cant_lineas'" >>"./16_reporte.txt"
    fi
done
echo "" >>"./16_reporte.txt"
echo "" >>"./16_reporte.txt"

echo "Abriendo el archivo '$(pwd)/16_reporte.txt'"
cat ./16_reporte.txt

exit 0
