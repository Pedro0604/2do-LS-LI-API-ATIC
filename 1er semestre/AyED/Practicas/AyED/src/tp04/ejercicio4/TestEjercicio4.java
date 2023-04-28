package tp04.ejercicio4;

import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio4 {

	public static void main(String[] args) {
		System.out.println(ArbolGeneral.crearArbolConValoresEnteros().altura());
		System.out.println(ArbolGeneral.crearArbolConValoresEnteros().nivel(1));
		System.out.println(ArbolGeneral.crearArbolConValoresEnteros().ancho());
	}

}
