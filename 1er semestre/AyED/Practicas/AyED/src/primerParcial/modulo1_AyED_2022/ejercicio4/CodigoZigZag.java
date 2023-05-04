package primerParcial.modulo1_AyED_2022.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class CodigoZigZag {
	public ListaGenerica<Character> descifrarCodigo(ArbolBinario<Character> a,
			ListaGenerica<String> listaDeSecuencias) {
		ListaGenerica<Character> l = new ListaEnlazadaGenerica<Character>();
		String secuencia;
		char c;
		listaDeSecuencias.comenzar();
		while (!listaDeSecuencias.fin()) {
			descifrarCodigo(l, a, new StringBuffer(listaDeSecuencias.proximo()));

			for (int i = 0; i < secuencia.length(); i++) {
				c = secuencia.charAt(i);
				if (c == '0') {
					a.getHijoIzquierdo();
				} else {
					a.getHijoIzquierdo();
				}
			}
		}
		return l;
	}

	private void descifrarCodigo(ListaGenerica<Character> l, ArbolBinario<Character> a, StringBuffer secuencia) {
		if (secuencia.charAt(0) == '0') {

		}
	}
}
