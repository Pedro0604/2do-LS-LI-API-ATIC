#!/bin/bash
if [ 3 -ne $# ]; then
    echo "Debe ingresar tres parametros"
    exit 1
fi

case $2 in
+)
    echo "Suma: $(expr $1 + $3)"
    ;;
-)
    echo "Resta: $(expr $1 - $3)"
    ;;
\*)
    echo "Multiplicacion: $(expr $1 \* $3)"
    ;;
/)
    echo "Division: $(expr $1 / $3)"
    ;;
*)
    echo "Operacion no valida"
    ;;
esac

exit 0
