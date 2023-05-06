package primerParcial.AyED_Redictado_15_10_2022_Tema1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class CantidadParesDelCaminoMayorOIgual {
	public static ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min) {
		ListaGenerica<Integer> lReturn = new ListaEnlazadaGenerica<Integer>();
		if (!ab.esVacio()) {
			ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<Integer>();
			int cantPares = 0;
			resolver(ab, min, lReturn, camino, cantPares);
		}
		return lReturn;
	}

	private static void resolver(ArbolBinario<Integer> a, int min, ListaGenerica<Integer> lReturn,
			ListaGenerica<Integer> camino, int cantPares) {
		camino.agregarFinal(a.getDato());
		if (a.esHoja()) {
			if (cantPares >= min) {
				camino.comenzar();
				while (!camino.fin()) {
					lReturn.agregarFinal(camino.proximo());
				}
			}
		} else {
			if (a.getDato() % 2 == 0) {
				cantPares++;
			}
			if (a.tieneHijoIzquierdo()) {
				resolver(a.getHijoIzquierdo(), min, lReturn, camino, cantPares);
			}
			if (lReturn.tamanio() == 0 && a.tieneHijoDerecho()) {
				resolver(a.getHijoDerecho(), min, lReturn, camino, cantPares);
			}
		}
		camino.eliminarEn(camino.tamanio());
	}
}
