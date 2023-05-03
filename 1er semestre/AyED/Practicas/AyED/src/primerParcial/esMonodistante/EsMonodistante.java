package primerParcial.esMonodistante;

import tp03.ejercicio1.ArbolBinario;

public class EsMonodistante {
	private ArbolBinario<Integer> arbol;

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	public boolean esMonodistante(int k) {
		return esMonodistante(k, this.arbol);
	}

	private boolean esMonodistante(int k, ArbolBinario<Integer> a) {
		boolean esM = false;
		if (!a.esVacio()) {
			int dato = a.getDato();
			if (a.esHoja()) {
				esM = dato == k;
			} else {
				// Como no es hoja, por lo menos tiene un hijo, entonces, en caso de q tenga
				// solo el izquierdo, se va a poner
				// el derecho en true y el valor de esM, va a depender de
				// this.a.getHijoIzquierdo().esMonodistante(k - dato)
				// y viceversa si solo tiene hijo derecho, por ultimo, si tiene ambos hijos, esM
				// va a ser
				// this.a.getHijoIzquierdo().esMonodistante(k - dato) &&
				// this.a.getHijoDerecho().esMonodistante(k - dato)

				// Es preferible asi:
				esM = (a.tieneHijoIzquierdo() ? esMonodistante(k - dato, a.getHijoIzquierdo()) : true)
						&& (a.tieneHijoDerecho() ? esMonodistante(k - dato, a.getHijoDerecho()) : true);

				// o asi:
				if (a.tieneHijoIzquierdo()) {
					esM = esMonodistante(k - dato, a.getHijoIzquierdo());
				} else {
					esM = true;
				}
				if (a.tieneHijoDerecho()) {
					esM = esM && esMonodistante(k - dato, a.getHijoDerecho());
				}

				// o asi:
				boolean esMIzq = true;
				boolean esMDer = true;
				if (a.tieneHijoIzquierdo()) {
					esMIzq = esMonodistante(k - dato, a.getHijoIzquierdo());
				}
				if (a.tieneHijoDerecho()) {
					esMDer = esMonodistante(k - dato, a.getHijoDerecho());
				}
				esM = esMIzq && esMDer;
			}
		}
		return esM;
	}
}
