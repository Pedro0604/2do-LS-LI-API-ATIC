package tp03.ejercicio2;

import tp03.ejercicio1.ArbolBinario;

public class TestEjercicio2 {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>();
		a = a.createTestIntegerTree();
		a.printTree();
		System.out.println(a.contarHojas());
		System.out.println();
		a.entreNiveles(2, 3);
		a = a.espejo();
		a.printTree();
		System.out.println(a.contarHojas());
		System.out.println();
		a.entreNiveles(1, 2);
	}

}
