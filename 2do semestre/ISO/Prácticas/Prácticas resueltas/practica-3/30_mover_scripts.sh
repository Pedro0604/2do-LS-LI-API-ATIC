cant_copiados=0

if [ ! -d "$HOME/bin" ]; then
    mkdir "$HOME/bin"
fi

for archivo in $(ls); do
    if [ -f $archivo ] && [ -x $archivo ]; then
        sudo cp $archivo $HOME/bin
        echo "El archivo '$(basename $archivo)' fue movido al directorio '$HOME/bin'"
        let cant_copiados++
    fi
done

if [ $cant_copiados -gt 0 ]; then
    echo "$cant_copiados archivos fueron copiados"
else
    echo "Ningun archivo fue copiado"
fi

exit 0
