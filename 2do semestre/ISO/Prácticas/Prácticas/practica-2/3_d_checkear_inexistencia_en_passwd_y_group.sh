name="$1"

if [ $(cat /etc/passwd | cut -d":" -f1 | grep -w "$name" | wc -l) -eq 0 ];then
	echo "$name not found in /etc/passwd"
else
	echo "$name still exists in /etc/passwd"
fi

if [ $(cat /etc/group | cut -d":" -f4 | grep -w "$name" | wc -l ) -eq 0 ] && [ $(cat /etc/group | cut -d":" -f1 | grep -w "$name" | wc -l) -eq 0 ];then
	echo "$name not found in /etc/group"
else
	echo "$name still exists in /etc/group"
fi
exit 0
