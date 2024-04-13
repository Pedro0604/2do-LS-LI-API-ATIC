# Funcionameinto de la [Práctica 4 resuelta en Google Sheets](https://docs.google.com/spreadsheets/d/1jrI0PM7C8r88W7rHsgzcwTy1V1eCkyGTN0vbkiD0W5w/edit?usp=sharing)
### Los modelos son hojas generales con todos los algoritmos de planificación usados (con y sin E/S)

## Funcionalidades
* En los diagramas si se hace un uso correcto de los caracteres '>' y '<', así como del tiempo de CPU:
  * Se realiza el coloreo automático de casillas: Rojo cuando no se hizo uso de la CPU (solo se colorea la casilla con el '>' automáticamente :( ) y verde cuando se usó la CPU
  * Se realiza el cálculo de tiempos de retorno y espera, así como sus promedios, de manera automática (basándose en la posición de los '>' y '<', y el tiempo de CPU indicado)
  * Se indica con la palabra 'CPU' en la columna TR cuando se cerró la ejecución de un proceso con el caracter '<', pero no se alcanzó el tiempo de CPU indicado

* Para los diagramas SRTF:
  * Se calcula automáticamente el tiempo restante para completar el uso de la CPU
  * Se indica con la palabra 'MAL' en la casilla RT, cuando se usó más CPU que la especificada

* En los diagramas con E/S se colorean automáticamente las casillas que hacen uso de recursos de E/S si estas se nombran R1, R2 o R3


