#!/bin/bash

echo "Introduzca dos numeros:"
read num1 num2


echo "Multiplicacion: $(expr $num1 \* $num2)"
echo "Suma: $(expr $num1 + $num2)"
echo "Resta: $(expr $num1 - $num2)"
echo "Division: $(expr $num1 / $num2)"
if [ $num1 -gt $num2 ]; then
    echo "El mayor es: $num1"
elif [ $num2 -gt $num1 ]; then
    echo "El mayor es: $num2"
else
    echo "Los numeros son iguales"
fi
