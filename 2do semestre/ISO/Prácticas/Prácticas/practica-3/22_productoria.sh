num=(10 3 5 7 9 3 5 4)
producto=-1

productoria() {
    if [ -n $num ]; then
        producto=1
        for n in ${num[*]}; do
            producto=$(expr $n \* $producto)
        done
    fi
}

productoria
echo $producto

exit 0
