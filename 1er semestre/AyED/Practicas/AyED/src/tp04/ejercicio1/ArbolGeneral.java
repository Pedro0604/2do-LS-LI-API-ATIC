package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

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

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
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
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
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
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> aux;
			ListaGenerica<ArbolGeneral<T>> hijos;
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
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> aux;
			ListaGenerica<ArbolGeneral<T>> hijos;
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

	public static ArbolGeneral<Integer> crearArbolConValoresEnteros() {
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> n = new ArbolGeneral<Integer>(14);
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
		ListaGenerica<ArbolGeneral<T>> hijos;
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
		ColaGenerica<ArbolGeneral<T>> c = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> a = null;
		ListaGenerica<ArbolGeneral<T>> hijos;
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

	@Override
	public String toString() {
		String st = "";
		ColaGenerica<ArbolGeneral<T>> c = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> a = null;
		ListaGenerica<ArbolGeneral<T>> hijos;
		c.encolar(this);
		c.encolar(null);
		while (!c.esVacia()) {
			a = c.desencolar();
			if (a != null) {
				st += a.getDato() + " ";
				hijos = a.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					c.encolar(hijos.proximo());
				}
			} else {
				if (!c.esVacia()) {
					st += "\n";
					c.encolar(null);
				}
			}
		}
		return st;
	}
}
