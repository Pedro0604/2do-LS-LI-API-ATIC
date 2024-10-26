package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
	private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();

	public void encolar(T elem) {
		this.datos.agregarFinal(elem);
	}

	public T desencolar() {
		if (this.esVacia()) {
			return null;
		}
		T el = this.datos.elemento(1);
		this.datos.eliminarEn(1);
		return el;
	}

	public T tope() {
		if (this.esVacia()) {
			return null;
		}
		return this.datos.elemento(1);
	}

	public boolean esVacia() {
		return this.datos.esVacia();
	}

	@Override
	public String toString() {
		return this.datos.toString();
	}

}
