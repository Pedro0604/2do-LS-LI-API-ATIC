package primerParcial.modulo1_AyED_2022.ejercicio10;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class MismoNumeroDescendientesAmbosLados {
	public static ListaGenerica<Integer> mismoNumeroDescendientesAmbosLados(ArbolBinario<Integer> a) {
		ListaGenerica<Integer> lReturn = new ListaEnlazadaGenerica<Integer>();
		if (!a.esVacio()) {
			mismoNumeroDescendientesAmbosLados(a, lReturn);
		}
		return lReturn;
	}

	private static Integer mismoNumeroDescendientesAmbosLados(ArbolBinario<Integer> a, ListaGenerica<Integer> lReturn) {
		int cantDes = 1;
		if (!a.esHoja()) {
			int cantDesHI = 0;
			int cantDesHD = 0;
			if (a.tieneHijoIzquierdo())
				cantDesHI = mismoNumeroDescendientesAmbosLados(a.getHijoIzquierdo(), lReturn);
			if (a.tieneHijoDerecho())
				cantDesHD = mismoNumeroDescendientesAmbosLados(a.getHijoDerecho(), lReturn);
			cantDes += cantDesHI + cantDesHD;
			if (cantDesHI == cantDesHD) {
				lReturn.agregarFinal(a.getDato());
			}
		}
		return cantDes;
	}
}