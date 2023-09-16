#!/bin/bash
if [ 2 -ne $# ]; then
    echo "Debe ingresar dos parametros"
    exit 1
fi

echo "Multiplicacion: $(expr $1 \* $2)"
echo "Suma: $(expr $1 + $2)"
echo "Resta: $(expr $1 - $2)"
echo "Division: $(expr $1 / $2)"
if [ $1 -gt $2 ]; then
    echo "El mayor es: $1"
elif [ $2 -gt $1 ]; then
    echo "El mayor es: $2"
else
    echo "Los numeros son iguales"
fi
