help() {
    echo "AL ELEGIR UNA DE LAS OPCIONES DISPONIBLES"
    echo "SE EJECUTARA EL SCRIPT ELEGIDO"
}

archivos=$(basename -a $(find "/home/pepox0604/practicas/practica-3" -name "*.sh"))

echo "MENU DE COMANDOS AMIGABLES CON EL USUARIO"
select archivo in "ayuda" "salir" $archivos; do
    case $archivo in
    ayuda)
        help
        ;;
    salir)
        break
        ;;
    *)
        if [ -f "/home/pepox0604/practicas/practica-3/$archivo" ]; then
            echo "Ingrese los parametros necesarios: "
            read parametros
            bash /home/pepox0604/practicas/practica-3/$archivo $parametros
            while [ $? -ne 0 ]; do
                echo "Ingrese los parametros necesarios: "
                read parametros
                bash /home/pepox0604/practicas/practica-3/$archivo $parametros
            done
        else
            echo "Opcion invalida"
        fi
        ;;
    esac
done

exit 0
