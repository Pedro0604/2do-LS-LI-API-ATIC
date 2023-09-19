if [ $# -ne 1 ]; then
    echo "El numero de parametros debe ser 1"
    exit 1
fi

usuarios=$(cut "/etc/passwd" -d":" -f 1 | grep -w $1 | wc -l)

if [ $usuarios -eq 0 ]; then
    echo "El usuario $1 no existe en el sistema"
    exit 2
fi

while [ true ]; do
    if [ $(users | grep -w $1 | wc -l) -gt 0 ]; then
        echo "Usuario $1 logueado en el sistema"
        exit 0
    fi
    sleep 10
done

exit 0
