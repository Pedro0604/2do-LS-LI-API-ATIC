package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	public static int retardoReenvio(ArbolBinario<Integer> a) {
		return Math.max(a.tieneHijoIzquierdo() ? retardoReenvio(a.getHijoIzquierdo()) : 0,
				a.tieneHijoDerecho() ? retardoReenvio(a.getHijoDerecho()) : 0) + (!a.esVacio() ? a.getDato() : 0);
	}
}
