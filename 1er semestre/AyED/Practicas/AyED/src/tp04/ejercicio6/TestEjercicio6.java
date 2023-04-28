package tp04.ejercicio6;

import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio6 {
	public static void main(String[] args) {
		ArbolGeneral<Integer> a = ArbolGeneral.crearArbolConValoresEnteros();
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				System.out.println(i + " es ancestro de " + j + ": " + a.esAncestro(i, j));
			}
		}
	}
}
