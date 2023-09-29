name="$1"

if [ $(cat /etc/passwd | grep -w "$name" | wc -l) -eq 0 ]; then
	echo "$name not found in /etc/passwd"
else
	echo "$name still exists in /etc/passwd"
fi

if [ $(cat /etc/group grep -w "$name" | wc -l) -eq 0 ]; then
	echo "$name not found in /etc/group"
else
	echo "$name still exists in /etc/group"
fi
exit 0
