package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {
	Grafo<String> mapaCiudades;

	public int buscarPosIni(String ciudad1, String ciudad2) {
		int posIni = -1;
		boolean encontreCiudad2 = false;
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		Vertice<String> v;
		vertices.comenzar();

		// Recorro la lista de vértices mientras no se termine y no haya encontrado
		// alguna de las dos ciudades
		while ((!vertices.fin()) && (posIni == -1 || !encontreCiudad2)) {
			v = vertices.proximo();
			if (v.dato() == ciudad1) {
				posIni = v.getPosicion();
			} else {
				if (v.dato() == ciudad2) {
					encontreCiudad2 = true;
				}
			}
		}

		// Si no encontré la ciudad2, devuelvo -1, así no se hace el DFS
		if (!encontreCiudad2) {
			posIni = -1;
		}
		return posIni;
	}

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			int posIni = buscarPosIni(ciudad1, ciudad2);
			if (posIni != -1) {
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
				devolverCaminoDFS(posIni, ciudad2, camino, marca);
			}
		}
		return camino;
	}

	private boolean devolverCaminoDFS(int pos, String ciudad2, ListaGenerica<String> camino, boolean[] marca) {
		boolean encontre = false;
		marca[pos] = true;
		Vertice<String> v = this.mapaCiudades.vertice(pos);
		camino.agregarFinal(v.dato());
		if (v.dato() == ciudad2) {
			encontre = true;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			Arista<String> arAct;
			Vertice<String> vAct;
			int posAct;
			while (!ady.fin()) {
				arAct = ady.proximo();
				vAct = arAct.verticeDestino();
				posAct = vAct.getPosicion();
				if (!marca[posAct]) {
					encontre = devolverCaminoDFS(posAct, ciudad2, camino, marca);
				}
			}
		}

		if (!encontre) {
			camino.eliminarEn(camino.tamanio());
		}
		return encontre;
	}

	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		return null;
	}

	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		return null;
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		return null;
	}

	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		return null;
	}
}
