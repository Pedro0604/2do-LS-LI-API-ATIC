package primerParcial.AyED_Redictado_4_12_2012;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class TramiteInterminable {
	public static Dato tramiteInterminable(ArbolGeneral<String> a) {
		ListaGenerica<String> lReturn = new ListaEnlazadaGenerica<String>();
		if (!a.esVacio()) {
			ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
			tramiteInterminable(a, lReturn, camino);
		}
		return new Dato(lReturn);
	}

	private static void tramiteInterminable(ArbolGeneral<String> a, ListaGenerica<String> lReturn,
			ListaGenerica<String> camino) {
		camino.agregarFinal(a.getDato());
		if (a.esHoja()) {
			if (camino.tamanio() > lReturn.tamanio() && a.getDato() == "QueEncajonaTodo") {
				while (!lReturn.esVacia()) {
					lReturn.eliminarEn(1);
				}
				camino.comenzar();
				while (!camino.fin()) {
					lReturn.agregarFinal(camino.proximo());
				}
			}
		} else {
			ListaGenerica<ArbolGeneral<String>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				tramiteInterminable(hijos.proximo(), lReturn, camino);
			}
		}
		camino.eliminarEn(camino.tamanio());
	}
}
