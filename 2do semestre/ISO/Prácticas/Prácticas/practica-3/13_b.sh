select opcion in "Listar" "Donde estoy" "Quien esta" "Salir"; do
    case $opcion in
    "Listar")
        ls -la
        ;;
    "Donde estoy")
        pwd
        ;;
    "Quien esta")
        who
        ;;
    "Salir")
        exit 0
        ;;
    *)
        echo "Opcion incorrecta"
        ;;
    esac
done

exit 0
