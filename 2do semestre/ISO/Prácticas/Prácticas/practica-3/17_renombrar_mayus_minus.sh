for archivo in $(ls); do
    echo $(basename $archivo | tr -d "a" | tr a-zA-Z A-Za-z)
done

exit 0
