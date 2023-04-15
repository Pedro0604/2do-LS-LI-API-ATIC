package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
	private ArbolBinario<Integer> a;

	public ContadorArbol(ArbolBinario<Integer> a) {
		this.a = a;
	}

	public ContadorArbol() {
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

	public ListaEnlazadaGenerica<Integer> numerosParesIO() {
		ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		this.NumerosParesPrivateIO(l, this.a);
		return l;
	}

	private void NumerosParesPrivateIO(ListaEnlazadaGenerica<Integer> l, ArbolBinario<Integer> a) {
		if (!a.esVacio()) {
			if (a.tieneHijoIzquierdo()) {
				NumerosParesPrivateIO(l, a.getHijoIzquierdo());
			}
			if (a.getDato() % 2 == 0) {
				l.agregarFinal(a.getDato());
			}
			if (a.tieneHijoDerecho()) {
				NumerosParesPrivateIO(l, a.getHijoDerecho());
			}
		}
	}

	public ListaEnlazadaGenerica<Integer> numerosParesPO() {
		ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		this.NumerosParesPrivatePO(l, this.a);
		return l;
	}

	private void NumerosParesPrivatePO(ListaEnlazadaGenerica<Integer> l, ArbolBinario<Integer> a) {
		if (!a.esVacio()) {
			if (a.tieneHijoIzquierdo()) {
				NumerosParesPrivatePO(l, a.getHijoIzquierdo());
			}
			if (a.tieneHijoDerecho()) {
				NumerosParesPrivatePO(l, a.getHijoDerecho());
			}
			if (a.getDato() % 2 == 0) {
				l.agregarFinal(a.getDato());
			}
		}
	}
}