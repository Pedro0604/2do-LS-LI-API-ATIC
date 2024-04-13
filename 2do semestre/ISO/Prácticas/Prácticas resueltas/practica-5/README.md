# Funcionameinto de la [Práctica 5 resuelta en Google Sheets](https://docs.google.com/spreadsheets/d/1OYUBnHMzc5M91hLytQbsMbJOzQNoKoH9U2qrHm7tAQE/edit?usp=sharing)
### El modelo es una hoja general con todos los algoritmos usados

## Funcionalidades
* La serie de páginas de memoria debe ser ingresada en el rectangulo de arriba del todo para que las mismas se coloquen en cada una de las casillas correspondientes de manera automática
* Si los page faults se marcan con una 'X' en la fila PF, serán contados automáticamente
* Los números de página se colorean automáticamente, y rellenan los espacios de atrás con verde oscuro (los colores están predeterminados hasta el 15 y varían según el número por lo que si hay dos procesos A y B, sus páginas Ax y Bx tendrán el mismo color)
* En el ejercicio 7, las dos tablas más oscuras de la derecha son una especie de calculadoras que (haciendo uso del tamaño de página, número de marco relativo al número de página y tamaño del proceso) traducen direcciones físicas a lógicas y viceversa (anotando también los valores de los pasos intermedios)
* En el ejercicio 17 también hay una tabla como la del ejercicio 7 (que hace uso del valor del bit V relativo al número de página, junto con el tamaño de página y el número de marco relativo al número de página) para calcular la dirección física, a partir de la lógica
* En el ejercicio 19 también hay una tabla que hace las veces de calculadora para calcular la cantidad de marcos asignados a cada proceso (de manera equitativa y proporcional)
