package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {

	// retorna numeros impares mayores que n en PreOrden
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePreOrden(l, n, a);
		return l;
	}

	private void numerosImparesMayoresQuePreOrden(ListaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		if (a.getDato() % 2 == 1 && a.getDato() > n) {
			l.agregarFinal(a.getDato());
		}
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			numerosImparesMayoresQuePreOrden(l, n, hijos.proximo());
		}
	}

	// retorna numeros impares mayores que n en InOrden
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQueInOrden(l, n, a);
		return l;
	}

	private void numerosImparesMayoresQueInOrden(ListaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		if (!hijos.esVacia())
			numerosImparesMayoresQueInOrden(l, n, hijos.proximo());
		if (a.getDato() % 2 == 1 && a.getDato() > n) {
			l.agregarFinal(a.getDato());
		}
		while (!hijos.fin()) {
			numerosImparesMayoresQueInOrden(l, n, hijos.proximo());
		}
	}

	// retorna numeros impares mayores que n en PostOrden
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePostOrden(l, n, a);
		return l;
	}

	private void numerosImparesMayoresQuePostOrden(ListaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			numerosImparesMayoresQuePostOrden(l, n, hijos.proximo());
		}
		if (a.getDato() % 2 == 1 && a.getDato() > n) {
			l.agregarFinal(a.getDato());
		}
	}

	// retorna numeros impares mayores que n por niveles
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		cola.encolar(a);
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux.getDato() % 2 == 1 && aux.getDato() > n) {
				l.agregarFinal(aux.getDato());
			}
			ListaGenerica<ArbolGeneral<Integer>> hijos = aux.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				cola.encolar(hijos.proximo());
			}
		}
		return l;
	}
}
