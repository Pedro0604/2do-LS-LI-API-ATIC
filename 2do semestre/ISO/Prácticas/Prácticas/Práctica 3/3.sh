#!/bin/bash
# Comentarios acerca de lo que hace el script
# Siempre comento mis scripts, si no hoy lo hago
# y mañana ya no me acuerdo de lo que quise hacer
echo "Introduzca su nombre y apellido:"
read nombre apellido
echo "Fecha y hora actual:"
date
echo "Su apellido y nombre es:"
echo "$apellido $nombre"
echo "Su usuario es: " $(whoami)
echo "Su directorio actual es: $(pwd)"
echo "Ingrese el numero de lineas que desea imprimir del archivo passwd:"
read nro_lineas
echo "El contenido de las ultimas $nro_lineas lineas del directorio /etc/passwd es:"
cat /etc/passwd | tail -n $nro_lineas
echo "El espacio restante en el disco es:"
df -h /dev/sda1
echo "Introduzca pais - provincia - ciudad y caca"
read pais provincia ciudad caca
echo "Pais: $pais - Provincia: $provincia - Ciudad: $ciudad - Caca: $caca"
