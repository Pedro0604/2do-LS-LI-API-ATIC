package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
	private ListaEnlazadaGenerica<T> datos = new ListaEnlazadaGenerica<>();

	public void apilar(T elem) {
		this.datos.agregarFinal(elem);
	}

	public T desapilar() {
		if (this.esVacia()) {
			return null;
		}
		T el = this.datos.elemento(this.datos.tamanio());
		this.datos.eliminarEn(this.datos.tamanio());
		return el;
	}

	public T tope() {
		if (this.esVacia()) {
			return null;
		}
		return this.datos.elemento(this.datos.tamanio());
	}

	public boolean esVacia() {
		return this.datos.esVacia();
	}
}
