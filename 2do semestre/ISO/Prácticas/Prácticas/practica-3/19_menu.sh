help() {
    echo "AL ELEGIR UNA DE LAS OPCIONES DISPONIBLES"
    echo "SE EJECUTARA EL SCRIPT ELEGIDO"
}

archivos=$(basename -a $(find "/home/pepox0604/practicas/practica-3" -name "*.sh"))

echo "MENU DE COMANDOS AMIGABLES CON EL USUARIO"
select archivo in "salir" "limpiar y salir" "limpiar" "ayuda" $archivos; do
    case $archivo in
    ayuda)
        help
        ;;
    limpiar)
        clear
        ;;
    salir)
        break
        ;;
    "limpiar y salir")
        clear
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
                if [ $parametros = "exit" ]; then
                    break
                fi
                if [ $parametros = "clear" ]; then
                    clear
                    break
                fi
                bash /home/pepox0604/practicas/practica-3/$archivo $parametros
            done
        else
            echo "Opcion invalida"
        fi
        ;;
    esac
done

exit 0
