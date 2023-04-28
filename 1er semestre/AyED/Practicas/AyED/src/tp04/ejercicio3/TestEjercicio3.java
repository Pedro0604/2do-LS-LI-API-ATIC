package tp04.ejercicio3;

import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio3 {

	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol = ArbolGeneral.crearArbolConValoresEnteros();
		RecorridosAG rec = new RecorridosAG();
		System.out.println("Pre orden: ");
		System.out.println(rec.numerosImparesMayoresQuePreOrden(arbol, 0));
		System.out.println("Post orden: ");
		System.out.println(rec.numerosImparesMayoresQuePostOrden(arbol, 0));
		System.out.println("In orden: ");
		System.out.println(rec.numerosImparesMayoresQueInOrden(arbol, 0));
		System.out.println("Por niveles: ");
		System.out.println(rec.numerosImparesMayoresQuePorNiveles(arbol, 0));
	}

}
