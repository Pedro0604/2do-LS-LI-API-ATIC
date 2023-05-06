package primerParcial.modulo1_AyED_2022.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class CaminosPares {
	public static ListaGenerica<ListaGenerica<Character>> caminosPares(ArbolGeneral<Character> arbol) {
		ListaGenerica<ListaGenerica<Character>> lReturn = new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		if (!arbol.esVacio()) {
			ListaGenerica<Character> camino = new ListaEnlazadaGenerica<Character>();
			caminosPares(arbol, lReturn, camino);
		}
		return lReturn;
	}

	private static void caminosPares(ArbolGeneral<Character> arbol, ListaGenerica<ListaGenerica<Character>> lReturn,
			ListaGenerica<Character> camino) {
		camino.agregarFinal(arbol.getDato());
		if (arbol.esHoja()) {
			if (camino.tamanio() % 2 == 0) {
				lReturn.agregarFinal(camino.clonar());
			}
		} else {
			ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				caminosPares(hijos.proximo(), lReturn, camino);
			}
		}
		camino.eliminarEn(camino.tamanio());
	}
}