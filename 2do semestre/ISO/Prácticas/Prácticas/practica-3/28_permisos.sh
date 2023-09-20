if [ $# -ne 1 ]; then
    echo "Ingrese un argumento"
    exit 1
fi

if [ ! -d $1 ]; then
    echo "El parametro '$1' no es un directorio"
    exit 4
fi

cant_arch_rw=0

pushd $1
for archivo in $(ls); do
    if [ -f $archivo ]; then
        if [ -w $archivo ] && [ -r $archivo ]; then
            let cant_arch_rw++
        fi
    fi
done
popd

echo "Cantidad de archivos con permisos de lectura y escritura en '$1' para $(whoami): $cant_arch_rw"
exit 0
