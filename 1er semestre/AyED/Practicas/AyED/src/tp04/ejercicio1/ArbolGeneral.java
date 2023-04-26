package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	/*
	 * public Integer altura() { int altura = -1; // Inicializo altura en -1 así
	 * cuando compara con el primero lo asigna a altura directamente // Caso base
	 * if(this.esHoja()) { return 0; } // Recursion if(this.tieneHijos()) {
	 * ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos(); lhijos.comenzar();
	 * while (!lhijos.fin()) { altura = Math.max(altura,lhijos.proximo().altura());
	 * } } return altura + 1;
	 * 
	 * }
	 * 
	 * public Integer nivel(T dato) { ColaGenerica<ArbolGeneral<T>> cola= new
	 * ColaGenerica<ArbolGeneral<T>>(); ArbolGeneral<T> arbol_aux;
	 * cola.encolar(this); cola.encolar(null); int nivel = 0; while
	 * (!cola.esVacia()) { arbol_aux = cola.desencolar(); if(arbol_aux != null) {
	 * if(arbol_aux.getDato() == dato) return nivel; if (arbol_aux.tieneHijos()) {
	 * ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
	 * hijos.comenzar(); while (!hijos.fin()) { cola.encolar(hijos.proximo()); } }
	 * }else { if(!cola.esVacia()) { cola.encolar(null); nivel++; } } } return -1; }
	 * 
	 * public Integer ancho() { ColaGenerica<ArbolGeneral<T>> cola= new
	 * ColaGenerica<ArbolGeneral<T>>(); ArbolGeneral<T> arbol_aux;
	 * cola.encolar(this); cola.encolar(null); int cantNodos = 0; int maximo = -1;
	 * while (!cola.esVacia()) { arbol_aux = cola.desencolar(); if(arbol_aux !=
	 * null) { cantNodos++; if (arbol_aux.tieneHijos()) {
	 * ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
	 * hijos.comenzar(); while (!hijos.fin()) { cola.encolar(hijos.proximo()); } }
	 * }else { if(cantNodos > maximo) { maximo = cantNodos; } cantNodos = 0;
	 * if(!cola.esVacia()) { cola.encolar(null); } } } return maximo; }
	 */

}