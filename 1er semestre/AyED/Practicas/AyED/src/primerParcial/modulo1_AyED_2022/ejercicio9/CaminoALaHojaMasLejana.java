package primerParcial.modulo1_AyED_2022.ejercicio9;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class CaminoALaHojaMasLejana {
	public static ListaGenerica<ArbolGeneral<Integer>> caminoALaHojaMasLejana(ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> lReturn = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		if (!a.esVacio()) {
			ListaGenerica<ArbolGeneral<Integer>> camino = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
			caminoALaHojaMasLejana(a, lReturn, camino);
		}
		return lReturn;
	}

	private static void caminoALaHojaMasLejana(ArbolGeneral<Integer> a, ListaGenerica<ArbolGeneral<Integer>> lReturn,
			ListaGenerica<ArbolGeneral<Integer>> camino) {
		camino.agregarFinal(a);
		if (a.esHoja()) {
			if (camino.tamanio() > lReturn.tamanio()) {
				while (!lReturn.esVacia()) {
					lReturn.eliminarEn(1);
				}
				camino.comenzar();
				while (!camino.fin()) {
					lReturn.agregarFinal(camino.proximo());
				}
			}
		} else {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				caminoALaHojaMasLejana(hijos.proximo(), lReturn, camino);
			}
		}
		camino.eliminarEn(camino.tamanio());
	}
}
