package tp03.ejercicio5;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> a;

	public ProfundidadDeArbolBinario(ArbolBinario<Integer> a) {
		this.a = a;
	}

	public ProfundidadDeArbolBinario() {
		a = new ArbolBinario<Integer>();
	}

	public void setA(ArbolBinario<Integer> a) {
		this.a = a;
	}

	public ArbolBinario<Integer> getA() {
		return this.a;
	}

	public void createTestTree() {
		this.a = a.createTestIntegerTree();
	}

	public int sumaElementosProfundidad(int p) {
		ColaGenerica<ArbolBinario<Integer>> c = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> a = null;
		int prof = 0;
		int suma = 0;
		c.encolar(this.a);
		c.encolar(null);
		while (!c.esVacia() && prof <= p) {
			a = c.desencolar();
			if (a != null) {
				if (prof == p) {
					suma += a.getDato();
				}
				if (a.tieneHijoIzquierdo()) {
					c.encolar(a.getHijoIzquierdo());
				}
				if (a.tieneHijoDerecho()) {
					c.encolar(a.getHijoDerecho());
				}
			} else {
				if (!c.esVacia()) {
					prof++;
					c.encolar(null);
				}
			}
		}
		return suma;
	}
}
