package primerParcial.ProgramacionIII_24_04_2023_Tema2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProcesadorDeArbol {
	ArbolBinario<Integer> a;

	public ProcesadorDeArbol(ArbolBinario<Integer> a) {
		this.a = a;
	}

	public Dato procesar() {
		ListaGenerica<Integer> lReturn = new ListaEnlazadaGenerica<Integer>();
		int cantImpares = -1;
		if (!this.a.esVacio()) {
			cantImpares = procesar(this.a, lReturn);
		}
		return new Dato(lReturn, cantImpares);
	}

	private int procesar(ArbolBinario<Integer> a, ListaGenerica<Integer> lReturn) {
		int cantImpares = 0;
		boolean tieneHI = a.tieneHijoIzquierdo();
		boolean tieneHD = a.tieneHijoDerecho();
		if (a.getDato() % 2 == 1) {
			cantImpares++;
			if ((tieneHI && !tieneHD) || (!tieneHI && tieneHD))
				lReturn.agregarFinal(a.getDato());
		}
		if (tieneHI) {
			cantImpares += procesar(a.getHijoIzquierdo(), lReturn);
		}
		if (tieneHD) {
			cantImpares += procesar(a.getHijoDerecho(), lReturn);
		}
		return cantImpares;
	}
}
