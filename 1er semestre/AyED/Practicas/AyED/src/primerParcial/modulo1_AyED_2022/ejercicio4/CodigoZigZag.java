package primerParcial.modulo1_AyED_2022.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class CodigoZigZag {
	public static ListaGenerica<Character> descifrarCodigo(ArbolBinario<Character> a,
			ListaGenerica<String> listaDeSecuencias) {
		ListaGenerica<Character> l = new ListaEnlazadaGenerica<Character>();
		if (!a.esVacio()) {
			listaDeSecuencias.comenzar();
			while (!listaDeSecuencias.fin()) {
				descifrarCodigo(l, a, listaDeSecuencias.proximo());
			}
		}
		return l;
	}

	private static void descifrarCodigo(ListaGenerica<Character> l, ArbolBinario<Character> a, String secuencia) {
		if (a.esHoja()) {
			l.agregarFinal(a.getDato());
		} else {
			if (secuencia.charAt(0) == '0') {
				descifrarCodigo(l, a.getHijoIzquierdo(), secuencia.substring(1));
			} else {
				descifrarCodigo(l, a.getHijoDerecho(), secuencia.substring(1));
			}
		}
	}
}
