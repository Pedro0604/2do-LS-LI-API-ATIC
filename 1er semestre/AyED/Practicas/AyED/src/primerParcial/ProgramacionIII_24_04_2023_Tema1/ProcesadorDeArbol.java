package primerParcial.ProgramacionIII_24_04_2023_Tema1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProcesadorDeArbol {
	ArbolBinario<Integer> a;

	public ProcesadorDeArbol(ArbolBinario<Integer> a) {
		this.a = a;
	}

	public Dato procesar() {
		ListaGenerica<ArbolBinario<Integer>> lReturn = new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
		int cantPares = -1;
		if (!this.a.esVacio()) {
			cantPares = procesar(this.a, lReturn);
		}
		return new Dato(lReturn, cantPares);
	}

	private int procesar(ArbolBinario<Integer> a, ListaGenerica<ArbolBinario<Integer>> lReturn) {
		int cantPares = 0;
		boolean tieneHI = a.tieneHijoIzquierdo();
		boolean tieneHD = a.tieneHijoDerecho();
		if (a.getDato() % 2 == 0) {
			cantPares++;
			if (tieneHI && tieneHD)
				lReturn.agregarFinal(a);
		}
		if (tieneHI) {
			cantPares += procesar(a.getHijoIzquierdo(), lReturn);
		}
		if (tieneHD) {
			cantPares += procesar(a.getHijoDerecho(), lReturn);
		}
		return cantPares;
	}
}
