package primerParcial.modulo1_AyED_2022.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class CaminoPorValorDeCadaNodo {
	public ListaGenerica<ArbolGeneral<Dato>> caminoPorValorDeCadaNodo(ArbolGeneral<Dato> a) {
		ListaGenerica<ArbolGeneral<Dato>> l = new ListaEnlazadaGenerica<ArbolGeneral<Dato>>();
		if (!a.esVacio())
			caminoPorValorDeCadaNodo(a, l, a.getDato().getValor());
		return l;
	}

	private void caminoPorValorDeCadaNodo(ArbolGeneral<Dato> a, ListaGenerica<ArbolGeneral<Dato>> l,
			int caminoASeguir) {
		l.agregarFinal(a);
		if (!a.esHoja()) {
			ListaGenerica<ArbolGeneral<Dato>> hijos = a.getHijos();
			ArbolGeneral<Dato> hijoAct = null;
			hijos.comenzar();
			if (a.tieneHijos()) {
				while (!hijos.fin() && caminoASeguir > 0) {
					hijoAct = hijos.proximo();
					caminoASeguir--;
				}
				caminoPorValorDeCadaNodo(hijoAct, l, hijoAct.getDato().getValor());
			}
		}
	}
}
