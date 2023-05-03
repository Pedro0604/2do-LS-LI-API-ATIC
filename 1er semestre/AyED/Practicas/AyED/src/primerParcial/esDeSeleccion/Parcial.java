package primerParcial.esDeSeleccion;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	public boolean esDeSeleccion(ArbolGeneral<Integer> arbol) {
		boolean esDeS = false;
		if (!arbol.esVacio()) {
			if (arbol.esHoja()) {
				esDeS = true;
			} else {
				int min = Integer.MAX_VALUE;
				ArbolGeneral<Integer> proxHijo;
				ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
				hijos.comenzar();
				boolean hijosSonDeSeleccion = true;
				while (!hijos.fin() && hijosSonDeSeleccion) {
					proxHijo = hijos.proximo();
					min = Math.min(min, proxHijo.getDato());
					hijosSonDeSeleccion = hijosSonDeSeleccion && esDeSeleccion(proxHijo);
				}
				if (arbol.getDato() == min) {
					esDeS = true;
				}
				esDeS = esDeS && hijosSonDeSeleccion;
			}
		}
		return esDeS;
	}
}
