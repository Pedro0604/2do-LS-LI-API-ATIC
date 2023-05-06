package primerParcial.Jueves_3_05_16hs;

import tp03.ejercicio1.ArbolBinario;

public class BuscadorArbol {
	ArbolBinario<Integer> arbol;

	public BuscadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	public Integer buscar() {
		Dato d = new Dato(-1, -1, 0);
		if (!this.arbol.esVacio()) {
			buscar(this.arbol, d);
		}
		return d.getElemento();
	}

	public void buscar(ArbolBinario<Integer> a, Dato d) {
		if (a.tieneHijoIzquierdo()) {
			d.setProfundidadActual(d.getProfundidadActual() + 1);
			buscar(a.getHijoIzquierdo(), d);
			d.setProfundidadActual(d.getProfundidadActual() - 1);
		}
		if (a.tieneHijoDerecho()) {
			d.setProfundidadActual(d.getProfundidadActual() + 1);
			buscar(a.getHijoDerecho(), d);
			d.setProfundidadActual(d.getProfundidadActual() - 1);
		}
		if (d.getProfundidadActual() > d.getProfundidad()) {
			d.setProfundidad(d.getProfundidadActual());
			d.setElemento(a.getDato());
		}
	}
}
