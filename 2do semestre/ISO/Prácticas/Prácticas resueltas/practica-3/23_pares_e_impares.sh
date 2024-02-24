arreglo=(2 3 4 5 5 94849 39394 8217328 731 345 56 3547 537 57 52 345)
cant_impares=0

for num in ${arreglo[*]}; do
    if [ $(expr $num % 2) -eq 0 ]; then
        echo $num
    else
        cant_impares=$(expr $cant_impares + 1)
    fi
done

echo
echo "Cantidad impares:"
echo $cant_impares

exit 0
