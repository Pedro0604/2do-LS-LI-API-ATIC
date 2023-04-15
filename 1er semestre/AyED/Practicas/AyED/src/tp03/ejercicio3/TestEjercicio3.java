package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class TestEjercicio3 {

	public static void main(String[] args) {
		ContadorArbol c = new ContadorArbol();
		c.createTestTree();
		c.getA().printTree();
		ListaEnlazadaGenerica<Integer> l1 = c.numerosParesIO();
		ListaEnlazadaGenerica<Integer> l2 = c.numerosParesPO();
		System.out.println(l1);
		System.out.println(l2);
	}

}
