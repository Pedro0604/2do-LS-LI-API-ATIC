package primerParcial.modulo1_AyED_2022.ejercicio8;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class SumaNodosNumeroImparDeHijos {
	ArbolGeneral<Integer> a;

	public SumaNodosNumeroImparDeHijos(ArbolGeneral<Integer> a) {
		this.a = a;
	}

	public ListaGenerica<Integer> resolver() {
		ListaGenerica<Integer> lReturn = new ListaEnlazadaGenerica<Integer>();
		if (!this.a.esVacio()) {
			resolver(this.a, lReturn);
		}
		return lReturn;
	}

	public void resolver(ArbolGeneral<Integer> a, ListaGenerica<Integer> lReturn) {
		if (!a.esHoja()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
			boolean cantImpHijos;
			ArbolGeneral<Integer> aux;
			int suma = 0;
			hijos = a.getHijos();
			cantImpHijos = (hijos.tamanio() % 2) == 1;
			hijos.comenzar();
			while (!hijos.fin()) {
				aux = hijos.proximo();
				resolver(aux, lReturn);
				if (cantImpHijos) {
					suma += aux.getDato();
				}
			}
			if (cantImpHijos)
				lReturn.agregarFinal(suma);

		}
	}
}
