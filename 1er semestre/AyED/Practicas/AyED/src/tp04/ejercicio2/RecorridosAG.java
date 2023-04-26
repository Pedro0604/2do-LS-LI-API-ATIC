package tp04.ejercicio3;

import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class RecorridosAG {
	private ArbolGeneral<Integer> arbol;

	public RecorridosAG(ArbolGeneral<Integer> a) {
		arbol = a;
	}

	public RecorridosAG(Integer n) {
		arbol = new ArbolGeneral<Integer>(n);
	}

	public ArbolGeneral<Integer> getArbol() {
		return this.arbol;
	}

	//retorna numeros impares mayores que n en PreOrden
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		privateNumerosImparesMayoresQuePreOrden(l, n, this.getArbol());
		return l;
	}

	private void privateNumerosImparesMayoresQuePreOrden(ListaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		if(a.getDato()%2 ==1 && a.getDato()>n) {
			l.agregarFinal(a.getDato());
		}
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			privateNumerosImparesMayoresQuePreOrden(l, n, hijos.proximo());
		}
	}
	
	//retorna numeros impares mayores que n en InOrden
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		privateNumerosImparesMayoresQueInOrden(l, n, this.getArbol());
		return l;
	}

	private void privateNumerosImparesMayoresQueInOrden(ListaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		if (!hijos.esVacia())
			privateNumerosImparesMayoresQueInOrden(l, n, hijos.proximo());
		if(a.getDato()%2 ==1 && a.getDato()>n) {
			l.agregarFinal(a.getDato());
		}
		while (!hijos.fin()) {
			privateNumerosImparesMayoresQueInOrden(l, n, hijos.proximo());
		}
	}

	//retorna numeros impares mayores que n en PostOrden
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		privateNumerosImparesMayoresQuePostOrden(l, n, this.getArbol());
		return l;
	}

	private void privateNumerosImparesMayoresQuePostOrden(ListaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			privateNumerosImparesMayoresQuePostOrden(l, n, hijos.proximo());
		}
		if(a.getDato()%2 ==1 && a.getDato()>n) {
			l.agregarFinal(a.getDato());
		}
	}
	
	//retorna numeros impares mayores que n por niveles
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		cola.encolar(a);
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if(aux.getDato()%2 ==1 && aux.getDato()>n) {
				l.agregarFinal(aux.getDato());
			}
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				cola.encolar(hijos.proximo());
			}
		}
		return l;
	}
}






















