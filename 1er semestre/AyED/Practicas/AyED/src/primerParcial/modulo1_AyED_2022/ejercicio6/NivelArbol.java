package primerParcial.modulo1_AyED_2022.ejercicio6;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class NivelArbol {
	ArbolBinario<Integer> arbol;

	public NivelArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	public ArbolBinario<Integer> minEnNivelAB(int n) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux;
		int nivel = 0;
		cola.encolar(this.arbol);
		cola.encolar(null);
		while (nivel < n) {
			aux = cola.desencolar();
			if (aux != null) {
				if (aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}
			} else {
				nivel++;
				cola.encolar(null);
			}
		}
		ArbolBinario<Integer> arbolReturn = null;
		int min = Integer.MAX_VALUE;
		aux = cola.desencolar();
		while (aux != null) {
			if (aux.esHoja()) {
				int dato = aux.getDato();
				if (dato < min) {
					min = dato;
					arbolReturn = aux;
				}
			}
			aux = cola.desencolar();
		}
		return arbolReturn;
	}
}