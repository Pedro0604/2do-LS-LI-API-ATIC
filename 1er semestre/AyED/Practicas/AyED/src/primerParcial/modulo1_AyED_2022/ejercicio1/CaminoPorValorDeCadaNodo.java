package primerParcial.modulo1_AyED_2022.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class CaminoPorValorDeCadaNodo {
	public ListaGenerica<ArbolGeneral<Integer>> caminoPorValorDeCadaNodo(ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> l = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		if (!a.esVacio())
			caminoPorValorDeCadaNodo(a, l, a.getDato());
		return l;
	}

	private void caminoPorValorDeCadaNodo(ArbolGeneral<Integer> a, ListaGenerica<ArbolGeneral<Integer>> l,
			int caminoASeguir) {
		l.agregarFinal(a);
		if (!a.esHoja()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			ArbolGeneral<Integer> hijoAct = null;
			hijos.comenzar();
			if (a.tieneHijos()) {
				while (!hijos.fin() && caminoASeguir > 0) {
					hijoAct = hijos.proximo();
					caminoASeguir--;
				}
				caminoPorValorDeCadaNodo(hijoAct, l, hijoAct.getDato());
			}
		}
	}
}
