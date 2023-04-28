package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	ArbolGeneral<Integer> arbol = ArbolGeneral.crearArbolConValoresEnteros();

	public double minimoCaudal(double caudal) {
		double min = Integer.MAX_VALUE;
		if (!arbol.esVacio()) {
			min = minimoCaudal(caudal, min, arbol);
		} else {
			min = -1;
		}
		return min;
	}

	private double minimoCaudal(double caudal, double min, ArbolGeneral<Integer> a) {
		min = Math.min(caudal, min);
		if (!a.esHoja()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			double caudalParaCadaHijo = caudal / hijos.tamanio();
			hijos.comenzar();
			while (!hijos.fin()) {
				min = minimoCaudal(caudalParaCadaHijo, min, hijos.proximo());
			}
		}
		return min;
	}
}
