# Funcionameinto de la [Calculadora de movimientos](https://github.com/Pedro0604/2do-LS-LI-API-ATIC/blob/main/2do%20semestre/ISO/Pr%C3%A1cticas/Pr%C3%A1cticas%20resueltas/practica-6/calculadora_movimientos.py)
### Tiene cargada la información necesaria para los ejercicios 13, 15 y 16, pero se pueden agregar más ejercicios
#### Para cada ejercicio que se desee agregar hay que especificar:
* inicio: donde inicia la cabeza (no me acuerdo porque lo hice hace un tiempo pero parece que es un string y ni ganas de cambiarlo😵)
* previo: requerimiento previo (es un entero)
* requerimientosArray (aunque es un string xdxd, pero despues se hace array 😎): un string con los requerimientos ordenados por llegada y con el siguiente formato: llegada1-{lote1}/llegada2-{lote2}/llegada3-{lote3}...)
* maxRango: el máximo rango permitido (es un entero) (el mínimo es siempre 0)

## Funcionalidades
### Calcula los movimientos de la cabeza para los requerimientos y algoritmo indicados:
  * Para cada requerimiento imprime en consola:
    ```
    Desde: <posicion_inicial> - Hasta: <posición_final> [PF]
    Movimientos: <cantidad_movimientos>
    ```
    (En caso de que el requerimiento sea de page fault, esto se indica mediante PF)
    
  * Cuando llega un nuevo lote de requerimientos imprime el número de lote y el número de movimiento en que llegó
  * Al finalizar todos los requerimientos imprime el total de movimientos
