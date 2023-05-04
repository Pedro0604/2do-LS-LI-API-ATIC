package primerParcial.modulo1_AyED_2022.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneralCreciente<T> {

	private T dato;

	private ListaGenerica<ArbolGeneralCreciente<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneralCreciente<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneralCreciente<T>> hijos) {
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneralCreciente<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneralCreciente(T dato) {
		this.dato = dato;
	}

	public ArbolGeneralCreciente(T dato, ListaGenerica<ArbolGeneralCreciente<T>> hijos) {
		this(dato);
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneralCreciente<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneralCreciente<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneralCreciente<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneralCreciente<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneralCreciente<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}

	public Integer altura() {
		Integer a = -1;
		Integer max = Integer.MIN_VALUE;
		if (!this.esVacio()) {
			a = 0;
			if (!this.esHoja()) {
				ListaGenerica<ArbolGeneralCreciente<T>> hijos = this.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					max = Math.max(max, hijos.proximo().altura());
				}
				a = max + 1;
			}
		}
		return a;
	}

	public Integer nivel(T dato) {
		boolean encontrado = false;
		Integer n = 0;
		if (!this.esVacio()) {
			ColaGenerica<ArbolGeneralCreciente<T>> cola = new ColaGenerica<ArbolGeneralCreciente<T>>();
			ArbolGeneralCreciente<T> aux;
			ListaGenerica<ArbolGeneralCreciente<T>> hijos;
			cola.encolar(this);
			cola.encolar(null);
			while (!cola.esVacia() && !encontrado) {
				aux = cola.desencolar();
				if (aux != null) {
					encontrado = aux.getDato() == dato;
					hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				} else {
					if (!cola.esVacia()) {
						n++;
						cola.encolar(null);
					}
				}
			}
		}
		if (!encontrado)
			n = -1;
		return n;
	}

	public Integer ancho() {
		Integer max = -1;
		if (!this.esVacio()) {
			Integer cantNodosNivel = 0;
			ColaGenerica<ArbolGeneralCreciente<T>> cola = new ColaGenerica<ArbolGeneralCreciente<T>>();
			ArbolGeneralCreciente<T> aux;
			ListaGenerica<ArbolGeneralCreciente<T>> hijos;
			cola.encolar(this);
			cola.encolar(null);
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux != null) {
					cantNodosNivel++;
					hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				} else {
					max = Math.max(max, cantNodosNivel);
					if (!cola.esVacia()) {
						cantNodosNivel = 0;
						cola.encolar(null);
					}
				}
			}
		}
		return max;
	}

	public static ArbolGeneralCreciente<Integer> crearArbolConValoresEnteros() {
		ArbolGeneralCreciente<Integer> a = new ArbolGeneralCreciente<Integer>(1);
		ArbolGeneralCreciente<Integer> b = new ArbolGeneralCreciente<Integer>(2);
		ArbolGeneralCreciente<Integer> c = new ArbolGeneralCreciente<Integer>(3);
		ArbolGeneralCreciente<Integer> d = new ArbolGeneralCreciente<Integer>(4);
		ArbolGeneralCreciente<Integer> e = new ArbolGeneralCreciente<Integer>(5);
		ArbolGeneralCreciente<Integer> f = new ArbolGeneralCreciente<Integer>(6);
		ArbolGeneralCreciente<Integer> g = new ArbolGeneralCreciente<Integer>(7);
		ArbolGeneralCreciente<Integer> h = new ArbolGeneralCreciente<Integer>(8);
		ArbolGeneralCreciente<Integer> i = new ArbolGeneralCreciente<Integer>(9);
		ArbolGeneralCreciente<Integer> j = new ArbolGeneralCreciente<Integer>(10);
		ArbolGeneralCreciente<Integer> k = new ArbolGeneralCreciente<Integer>(11);
		ArbolGeneralCreciente<Integer> l = new ArbolGeneralCreciente<Integer>(12);
		ArbolGeneralCreciente<Integer> m = new ArbolGeneralCreciente<Integer>(13);
		ArbolGeneralCreciente<Integer> n = new ArbolGeneralCreciente<Integer>(14);
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		a.agregarHijo(e);
		c.agregarHijo(f);
		c.agregarHijo(g);
		d.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);
		d.agregarHijo(k);
		g.agregarHijo(l);
		j.agregarHijo(m);
		j.agregarHijo(n);
		return a;
	}

	public Boolean esAncestro(T a, T b) {
		Boolean esAnc = false;
		if (!this.esVacio()) {
			esAnc = esAncestro(a, b, false);
		}
		return esAnc;
	}

	private Boolean esAncestro(T a, T b, Boolean encontreA) {
		Boolean encontreB = false;
		ListaGenerica<ArbolGeneralCreciente<T>> hijos;
		if (!this.esVacio()) {
			if (encontreA) {
				encontreB = this.getDato() == b;
			} else {
				encontreA = this.getDato() == a;
			}
			if (!encontreB) {
				hijos = this.getHijos();
				hijos.comenzar();
				while (!hijos.fin() && !encontreB) {
					encontreB = hijos.proximo().esAncestro(a, b, encontreA);
				}
			}
		}
		return encontreB;
	}

	public void printTree() {
		ColaGenerica<ArbolGeneralCreciente<T>> c = new ColaGenerica<ArbolGeneralCreciente<T>>();
		ArbolGeneralCreciente<T> a = null;
		ListaGenerica<ArbolGeneralCreciente<T>> hijos;
		c.encolar(this);
		c.encolar(null);
		while (!c.esVacia()) {
			a = c.desencolar();
			if (a != null) {
				System.out.print(a.getDato() + " ");
				hijos = a.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					c.encolar(hijos.proximo());
				}
			} else {
				if (!c.esVacia()) {
					System.out.println();
					c.encolar(null);
				}
			}
		}

		System.out.println();
	}

	public ArbolGeneralCreciente<T> arbolGeneralCreciente() {
		ArbolGeneralCreciente<T> arbolMaxCantHijos = null;
		if (!this.esVacio()) {
			ColaGenerica<ArbolGeneralCreciente<T>> cola = new ColaGenerica<ArbolGeneralCreciente<T>>();
			ListaGenerica<ArbolGeneralCreciente<T>> hijos;
			ArbolGeneralCreciente<T> aux;
			int nivel = 0;
			int cantNodosNivel = 0;
			int maxCantHijos = -1;
			int cantHijosActual;
			boolean esCreciente = true;
			cola.encolar(this);
			cola.encolar(null);
			while (!cola.esVacia() && esCreciente) {
				aux = cola.desencolar();
				if (aux != null) {
					cantNodosNivel++;
					hijos = aux.getHijos();
					cantHijosActual = hijos.tamanio();
					if (cantHijosActual > maxCantHijos) {
						maxCantHijos = cantHijosActual;
						arbolMaxCantHijos = aux;
					}
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				} else {
					esCreciente = (nivel + 1) == cantNodosNivel;
					if (!cola.esVacia()) {
						nivel++;
						cola.encolar(null);
						cantNodosNivel = 0;
					}
				}
			}
			if (!esCreciente) {
				arbolMaxCantHijos = null;
			}
		}
		return arbolMaxCantHijos;
	}
}
