if [ $# -ne 1 ]; then
    echo "Ingrese un argumento"
    exit 1
fi

if [ ! -d $1 ]; then
    echo "El argumento no existe o no es un directorio"
    exit 4
fi

cant_arch_rw=0

pushd $1
for archivo in $(ls); do
    if [ -w $archivo ] && [ -r $archivo ]; then
        let cant_arch_rw++
    fi
done
popd

echo "Cantidad de archivos con permisos de lectura y escritura para $(whoami): $cant_arch_rw"
exit 0
