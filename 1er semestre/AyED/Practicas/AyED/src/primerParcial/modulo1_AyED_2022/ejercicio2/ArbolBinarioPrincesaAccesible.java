package primerParcial.modulo1_AyED_2022.ejercicio2;

import tp02.ejercicio3.ColaGenerica;

public class ArbolBinarioPrincesaAccesible<T> {
	private T dato;
	private ArbolBinarioPrincesaAccesible<T> hijoIzquierdo;
	private ArbolBinarioPrincesaAccesible<T> hijoDerecho;

	public ArbolBinarioPrincesaAccesible() {
		super();
	}

	public ArbolBinarioPrincesaAccesible(T dato) {
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
	public ArbolBinarioPrincesaAccesible<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinarioPrincesaAccesible<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinarioPrincesaAccesible<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinarioPrincesaAccesible<T> hijo) {
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

	public ArbolBinarioPrincesaAccesible<T> espejo() {
		if (!this.esVacio()) {

			ArbolBinarioPrincesaAccesible<T> a = new ArbolBinarioPrincesaAccesible<T>(this.getDato());

			a.agregarHijoDerecho(this.tieneHijoIzquierdo() ? this.getHijoIzquierdo().espejo() : null);

			a.agregarHijoIzquierdo(this.tieneHijoDerecho() ? this.getHijoDerecho().espejo() : null);

			return a;
		}
		return this;
	}

	public void entreNiveles(int n, int m) {
		ColaGenerica<ArbolBinarioPrincesaAccesible<T>> c = new ColaGenerica<ArbolBinarioPrincesaAccesible<T>>();
		ArbolBinarioPrincesaAccesible<T> a = null;
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
		ColaGenerica<ArbolBinarioPrincesaAccesible<T>> c = new ColaGenerica<ArbolBinarioPrincesaAccesible<T>>();
		ArbolBinarioPrincesaAccesible<T> a = null;
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

	public ArbolBinarioPrincesaAccesible<Integer> createTestIntegerTree() {
		ArbolBinarioPrincesaAccesible<Integer> a = new ArbolBinarioPrincesaAccesible<Integer>(1);
		ArbolBinarioPrincesaAccesible<Integer> b = new ArbolBinarioPrincesaAccesible<Integer>(2);
		ArbolBinarioPrincesaAccesible<Integer> c = new ArbolBinarioPrincesaAccesible<Integer>(3);
		ArbolBinarioPrincesaAccesible<Integer> d = new ArbolBinarioPrincesaAccesible<Integer>(4);
		ArbolBinarioPrincesaAccesible<Integer> e = new ArbolBinarioPrincesaAccesible<Integer>(5);
		ArbolBinarioPrincesaAccesible<Integer> f = new ArbolBinarioPrincesaAccesible<Integer>(6);
		ArbolBinarioPrincesaAccesible<Integer> g = new ArbolBinarioPrincesaAccesible<Integer>(7);
		d.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<Integer>(8));
		d.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<Integer>(9));
		e.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<Integer>(10));
		e.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<Integer>(11));
		f.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<Integer>(12));
		f.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<Integer>(13));
		g.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<Integer>(14));
		g.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<Integer>(15));
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		return a;
	}

	public ArbolBinarioPrincesaAccesible<T> createTestTree(T[] arr) {
		ArbolBinarioPrincesaAccesible<T> a = new ArbolBinarioPrincesaAccesible<T>(arr[0]);
		ArbolBinarioPrincesaAccesible<T> b = new ArbolBinarioPrincesaAccesible<T>(arr[1]);
		ArbolBinarioPrincesaAccesible<T> c = new ArbolBinarioPrincesaAccesible<T>(arr[2]);
		ArbolBinarioPrincesaAccesible<T> d = new ArbolBinarioPrincesaAccesible<T>(arr[3]);
		ArbolBinarioPrincesaAccesible<T> e = new ArbolBinarioPrincesaAccesible<T>(arr[4]);
		ArbolBinarioPrincesaAccesible<T> f = new ArbolBinarioPrincesaAccesible<T>(arr[5]);
		ArbolBinarioPrincesaAccesible<T> g = new ArbolBinarioPrincesaAccesible<T>(arr[6]);
		g.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<T>(arr[13]));
		g.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<T>(arr[14]));
		f.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<T>(arr[11]));
		f.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<T>(arr[12]));
		e.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<T>(arr[9]));
		e.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<T>(arr[10]));
		d.agregarHijoIzquierdo(new ArbolBinarioPrincesaAccesible<T>(arr[7]));
		d.agregarHijoDerecho(new ArbolBinarioPrincesaAccesible<T>(arr[8]));
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		return a;
	}

	public Personaje PrincesaAccesible() {
		Personaje p = null;
		if (!this.esVacio()) {
			p = PrincesaAccesible((ArbolBinarioPrincesaAccesible<Personaje>) this);
		}
		return p;
	}

	private Personaje PrincesaAccesible(ArbolBinarioPrincesaAccesible<Personaje> a) {
		Personaje p = null;
		if (a.getDato().getNombre() == "Princesa") {
			p = a.getDato();
		} else {
			if (a.getDato().getNombre() != "Dragon") {
				if (a.tieneHijoIzquierdo())
					p = PrincesaAccesible(a.getHijoIzquierdo());
				if (a.tieneHijoDerecho() && p == null) // p solo es distinto de null cuando se encontro una princesa,
														// por lo que mientras p sea null se debe ir a ver el hijo
														// derecho en busca de una princesa accesible
					p = PrincesaAccesible(a.getHijoDerecho());
			}
		}
		return p;
	}
}
