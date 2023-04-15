package tp03.ejercicio1;

import tp02.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * 
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public int contarHojas() {

		int cant = 0;
		if (this.esHoja() && !this.esVacio())

			cant = 1;
		else {

			cant += this.tieneHijoIzquierdo() ? this.getHijoIzquierdo().contarHojas() : 0;

			cant += this.tieneHijoDerecho() ? this.getHijoDerecho().contarHojas() : 0;
		}

		return cant;

	}

	public ArbolBinario<T> espejo() {
		if (!this.esVacio()) {

			ArbolBinario<T> a = new ArbolBinario<T>(this.getDato());

			a.agregarHijoDerecho(this.tieneHijoIzquierdo() ? this.getHijoIzquierdo().espejo() : null);

			a.agregarHijoIzquierdo(this.tieneHijoDerecho() ? this.getHijoDerecho().espejo() : null);

			return a;
		}
		return this;
	}

	public void entreNiveles(int n, int m) {
		ColaGenerica<ArbolBinario<T>> c = new ColaGenerica<ArbolBinario<T>>();
		ArbolBinario<T> a = null;
		int nivel = 0;
		c.encolar(this);
		c.encolar(null);
		while (!c.esVacia()) {
			a = c.desencolar();
			if (a != null) {
				if (n <= nivel && nivel <= m) {
					System.out.print(a.getDato() + " ");
				}
				if (a.tieneHijoIzquierdo()) {
					c.encolar(a.getHijoIzquierdo());
				}
				if (a.tieneHijoDerecho()) {
					c.encolar(a.getHijoDerecho());
				}
			} else {
				if (!c.esVacia()) {
					System.out.println();
					nivel++;
					c.encolar(null);
				}
			}
		}
		System.out.println();
	}

	public void printTree() {
		ColaGenerica<ArbolBinario<T>> c = new ColaGenerica<ArbolBinario<T>>();
		ArbolBinario<T> a = null;
		c.encolar(this);
		c.encolar(null);
		while (!c.esVacia()) {
			a = c.desencolar();
			if (a != null) {
				System.out.print(a.getDato() + " ");
				if (a.tieneHijoIzquierdo()) {
					c.encolar(a.getHijoIzquierdo());
				}
				if (a.tieneHijoDerecho()) {
					c.encolar(a.getHijoDerecho());
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

	public ArbolBinario<Integer> createTestIntegerTree() {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(7);
		d.agregarHijoIzquierdo(new ArbolBinario<Integer>(8));
		d.agregarHijoDerecho(new ArbolBinario<Integer>(9));
		e.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		e.agregarHijoDerecho(new ArbolBinario<Integer>(11));
		f.agregarHijoIzquierdo(new ArbolBinario<Integer>(12));
		f.agregarHijoDerecho(new ArbolBinario<Integer>(13));
		g.agregarHijoIzquierdo(new ArbolBinario<Integer>(14));
		g.agregarHijoDerecho(new ArbolBinario<Integer>(15));
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		return a;
	}

	public ArbolBinario<T> createTestTree(T[] arr) {
		ArbolBinario<T> a = new ArbolBinario<T>(arr[0]);
		ArbolBinario<T> b = new ArbolBinario<T>(arr[1]);
		ArbolBinario<T> c = new ArbolBinario<T>(arr[2]);
		ArbolBinario<T> d = new ArbolBinario<T>(arr[3]);
		ArbolBinario<T> e = new ArbolBinario<T>(arr[4]);
		ArbolBinario<T> f = new ArbolBinario<T>(arr[5]);
		ArbolBinario<T> g = new ArbolBinario<T>(arr[6]);
		g.agregarHijoIzquierdo(new ArbolBinario<T>(arr[13]));
		g.agregarHijoDerecho(new ArbolBinario<T>(arr[14]));
		f.agregarHijoIzquierdo(new ArbolBinario<T>(arr[11]));
		f.agregarHijoDerecho(new ArbolBinario<T>(arr[12]));
		e.agregarHijoIzquierdo(new ArbolBinario<T>(arr[9]));
		e.agregarHijoDerecho(new ArbolBinario<T>(arr[10]));
		d.agregarHijoIzquierdo(new ArbolBinario<T>(arr[7]));
		d.agregarHijoDerecho(new ArbolBinario<T>(arr[8]));
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		return a;
	}
}
