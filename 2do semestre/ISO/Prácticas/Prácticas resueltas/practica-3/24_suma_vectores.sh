vector1=(1 80 65 35 2)
vector2=(5 98 3 41 8)

if [ ${#vector1[*]} -ne ${#vector1[*]} ]; then
    echo "Ambos vectores deben tener la misma longitud"
    exit 1
fi

for ((i = 0; i < ${#vector1[*]}; i++)); do
    echo "La suma de los elementos de la posición $i de los vectores es $(expr ${vector1[i]} + ${vector2[i]})"
done

exit 0
