package tp06.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class VisitaOslo {
	private static int maxTiempoStaticMamado;

	public static ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,
			ListaGenerica<String> lugaresRestringidos) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!lugares.esVacio()) {
			maxTiempoStaticMamado = maxTiempo;
			boolean[] marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
			int pos = buscarPosIniYMarcarRestringidos(lugares, lugaresRestringidos, marca);
			paseoEnBiciDFS(pos, lugares, destino, camino, maxTiempo, marca);
		}
		if (camino.esVacia()) {
			camino.agregarFinal("No");
			camino.agregarFinal("hay");
			camino.agregarFinal("camino");
			camino.agregarFinal(".");
		}
		return camino;
	}

	private static int buscarPosIniYMarcarRestringidos(Grafo<String> lugares, ListaGenerica<String> lugaresRestringidos,
			boolean[] marca) {
		int pos = -1;
		Vertice<String> v;
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();

		vertices.comenzar();
		while (!vertices.fin()) {
			v = vertices.proximo();
			if (lugaresRestringidos.incluye(v.dato())) {
				marca[v.getPosicion()] = true;
			}
			if (v.dato().equals("Ayuntamiento")) {
				pos = v.getPosicion();
			}
		}
		return pos;
	}

	private static boolean paseoEnBiciDFS(int pos, Grafo<String> lugares, String destino, ListaGenerica<String> camino,
			int maxTiempo, boolean[] marca) {
		boolean encontre = false;

		Vertice<String> v = lugares.vertice(pos);
		camino.agregarFinal(v.dato());
		marca[pos] = true;

		if (v.dato().equals(destino)) {
			encontre = true;
			System.out.println("Tiempo total: " + (maxTiempoStaticMamado - maxTiempo));
		} else {
			ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(v);
			Arista<String> arista;
			Vertice<String> vProx;
			int posProx;
			int peso;

			ady.comenzar();
			while (!encontre && !ady.fin()) {
				arista = ady.proximo();
				peso = arista.peso();
				vProx = arista.verticeDestino();
				posProx = vProx.getPosicion();
				if (!marca[posProx] && peso < maxTiempo) {
					encontre = paseoEnBiciDFS(posProx, lugares, destino, camino, maxTiempo - peso, marca);
				}
			}
		}

		if (!encontre) {
			camino.eliminarEn(camino.tamanio());
			marca[pos] = false;
		}
		return encontre;
	}
}
