package tp03.ejercicio5;

import java.util.Arrays;

import tp03.ejercicio1.ArbolBinario;

public class TestEjercicio5 {

	public static void main(String[] args) {
		int[] data = { 23, 12, 245, 12, 23, 235, 724, 22, 222, 1, 123, 14, 544, 53, 4 };
		Integer[] arr = Arrays.stream(data).boxed().toArray(Integer[]::new);
		ArbolBinario<Integer> a = new ArbolBinario<Integer>().createTestTree(arr);
		a.printTree();
		ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario(a);
		System.out.println(p.sumaElementosProfundidad(0));
		System.out.println(p.sumaElementosProfundidad(1));
		System.out.println(p.sumaElementosProfundidad(2));
		System.out.println(p.sumaElementosProfundidad(3));
	}

}
