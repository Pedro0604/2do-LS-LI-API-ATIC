if [ $# -ne 1 ]; then
    echo "引数が必要です。"
    echo "Debe ingresar un parametro"
    exit 1
fi

if [ -e $1 ]; then
    str="El nombre del archivo existe y es"
    if [ -f $1 ]; then
        echo "$str un archivo regular"
    elif [ -d $1 ]; then
        echo "$str un directorio"
    else
        echo "$str otro tipo de archivo"
    fi
else
    echo "El nombre del archivo no existe"
    mkdir -p $1
    if [ $? -ne 0 ]; then
        echo "No se pudo crear el directorio $1"
        exit 2
    else
        echo "El directorio $1 fue creado"
    fi
fi

exit 0
