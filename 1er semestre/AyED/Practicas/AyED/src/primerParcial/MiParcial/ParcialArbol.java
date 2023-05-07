package primerParcial.MiParcial;

import tp03.ejercicio1.ArbolBinario;

public class ParcialArbol {
	private ArbolBinario<Integer> a;

	public ParcialArbol(ArbolBinario<Integer> a) {
		super();
		this.a = a;
	}

	public boolean isLeftTree(int num) {
		boolean isLeft = false;
		if (!this.a.esVacio()) {
			ArbolBinario<Integer> subArbol = buscarSubArbol(this.a, num);
			if (subArbol != null) {
				int cantArbHijoUnicoIzq = -1;
				int cantArbHijoUnicoDer = -1;
				if (subArbol.tieneHijoIzquierdo()) {
					cantArbHijoUnicoIzq = cantArbHijoUnico(subArbol.getHijoIzquierdo());
				}
				if (subArbol.tieneHijoDerecho()) {
					cantArbHijoUnicoDer = cantArbHijoUnico(subArbol.getHijoDerecho());
				}
				isLeft = cantArbHijoUnicoIzq > cantArbHijoUnicoDer;
			}
		}
		return isLeft;
	}

	private ArbolBinario<Integer> buscarSubArbol(ArbolBinario<Integer> a, int num) {
		ArbolBinario<Integer> subArbol = null;
		if (a.getDato() == num) {
			subArbol = a;
		} else {
			if (a.tieneHijoIzquierdo()) {
				subArbol = buscarSubArbol(a.getHijoIzquierdo(), num);
			}
			if (subArbol == null && a.tieneHijoDerecho()) {
				subArbol = buscarSubArbol(a.getHijoDerecho(), num);
			}
		}
		return subArbol;
	}

	private int cantArbHijoUnico(ArbolBinario<Integer> a) {
		int cant = 0;
		if (!a.esHoja()) {
			boolean tieneHI = a.tieneHijoIzquierdo();
			boolean tieneHD = a.tieneHijoDerecho();
			if ((tieneHI && !tieneHD) || (!tieneHI && tieneHD)) {
				cant++;
			}
			if (a.tieneHijoIzquierdo()) {
				cant += cantArbHijoUnico(a.getHijoIzquierdo());
			}
			if (a.tieneHijoDerecho()) {
				cant += cantArbHijoUnico(a.getHijoDerecho());
			}
		}
		return cant;
	}
}
