if [ $# -ne 3 ]; then
    echo "Se necesitan 3 parametros"
    exit 1
fi

if [ ! -d $1 ]; then
    echo "El primer parametro '$1' no es un directorio"
    exit 2
fi

if [ "$2" != "-a" ] && [ "$2" != "-b" ]; then
    echo "El flag pasado como segundo parametro '$2' debe ser -a o -b"
    exit 3
fi

for archivo in $(ls $1); do
    if [ -f $archivo ]; then
        if [ $2 = "-a" ]; then
            mv $1/$archivo $1/$archivo$3
        else
            mv $1/$archivo $1/$3$archivo
        fi
    fi
done

exit 0
