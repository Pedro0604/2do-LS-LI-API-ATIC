package tp04.ejercicio4;

import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio4 {

	public static void main(String[] args) {
		System.out.println("Altura: " + ArbolGeneral.crearArbolConValoresEnteros().altura());
		System.out.println("Nivel del nodo con valor 1: " + ArbolGeneral.crearArbolConValoresEnteros().nivel(12));
		System.out.println("Ancho: " + ArbolGeneral.crearArbolConValoresEnteros().ancho());
	}

}
