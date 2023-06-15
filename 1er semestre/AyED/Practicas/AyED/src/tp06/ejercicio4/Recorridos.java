package tp06.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.*;

public class Recorridos<T> {
	public ListaGenerica<T> dfs(Grafo<T> grafo) {
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		if (!grafo.esVacio()) {
			boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
			for (int i = 1; i < grafo.listaDeVertices().tamanio() + 1; i++) {
				if (!marca[i]) {
					dfs(i, lista, marca, grafo);
				}
			}
		}
		return lista;
	}

	private void dfs(int pos, ListaGenerica<T> lista, boolean[] marca, Grafo<T> grafo) {
		marca[pos] = true;
		Vertice<T> v = grafo.vertice(pos);
		lista.agregarFinal(v.dato());
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		int j;
		while (!ady.fin()) {
			j = ady.proximo().verticeDestino().getPosicion();
			if (!marca[j]) {
				dfs(j, lista, marca, grafo);
			}
		}
	}

	public ListaGenerica<T> bfs(Grafo<T> grafo) {
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		if (!grafo.esVacio()) {
			boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
			for (int i = 1; i < grafo.listaDeVertices().tamanio() + 1; i++) {
				if (!marca[i]) {
					bfs(i, lista, marca, grafo);
				}
			}
		}
		return lista;
	}

	private void bfs(int pos, ListaGenerica<T> lista, boolean[] marca, Grafo<T> grafo) {
		Vertice<T> aux = grafo.vertice(pos);
		ListaGenerica<Arista<T>> ady;
		Arista<T> arista;
		int j;

		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		cola.encolar(aux);
		marca[pos] = true;

		while (!cola.esVacia()) {
			aux = cola.desencolar();
			lista.agregarFinal(aux.dato());
			ady = grafo.listaDeAdyacentes(aux);
			ady.comenzar();
			while (!ady.fin()) {
				arista = ady.proximo();
				aux = arista.verticeDestino();
				j = aux.getPosicion();
				if (!marca[j]) {
					marca[j] = true;
					cola.encolar(aux);
				}
			}
		}
	}
}
