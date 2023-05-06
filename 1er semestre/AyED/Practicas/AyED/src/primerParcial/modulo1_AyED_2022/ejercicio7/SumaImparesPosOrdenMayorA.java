package primerParcial.modulo1_AyED_2022.ejercicio7;

import tp03.ejercicio1.ArbolBinario;

public class SumaImparesPosOrdenMayorA {
	public static Integer sumaImparesPosOrdenMayorA(ArbolBinario<Integer> a, int k) {
		int suma = 0;
		if (!a.esVacio()) {
			if (a.tieneHijoIzquierdo()) {
				suma += sumaImparesPosOrdenMayorA(a.getHijoIzquierdo(), k);
			}
			if (a.tieneHijoDerecho()) {
				suma += sumaImparesPosOrdenMayorA(a.getHijoDerecho(), k);
			}
			int dato = a.getDato();
			if ((dato % 2 == 1) && (dato > k)) {
				suma += dato;
			}
		}
		return suma;
	}
}