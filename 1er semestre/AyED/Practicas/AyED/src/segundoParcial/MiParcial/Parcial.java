package segundoParcial.MiParcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	public static InfoCamino resolver(Grafo<Dato> sitios, String origen, int maxTiempo) {
		InfoCamino resultado = new InfoCamino(new ListaEnlazadaGenerica<String>(), 0);
		if (!sitios.esVacio()) {
			int posInicio = buscarOrigen(sitios, origen);
			if (posInicio != -1) {
				Vertice<Dato> v = sitios.vertice(posInicio);
				if (v.dato().getTiempo() <= maxTiempo) {
					boolean[] marca = new boolean[sitios.listaDeVertices().tamanio() + 1];
					dfs(posInicio, sitios, resultado, new InfoCamino(new ListaEnlazadaGenerica<String>(), 0), maxTiempo,
							marca);
				}
			}
		}
		return resultado;
	}

	private static void dfs(int pos, Grafo<Dato> sitios, InfoCamino resultado, InfoCamino actual, int maxTiempo,
			boolean[] marca) {
		marca[pos] = true;
		Vertice<Dato> v = sitios.vertice(pos);
		actual.agregarSitio(v.dato().getNombre());
		actual.incrementarTiempo(v.dato().getTiempo());
		if (((actual.getCamino().tamanio() == resultado.getCamino().tamanio())
				&& (actual.getTiempoTot() < resultado.getTiempoTot()))
				|| (actual.getCamino().tamanio() > resultado.getCamino().tamanio())) {
			resultado.setCamino(actual.getCamino().clonar());
			resultado.setTiempoTot(actual.getTiempoTot());
		}
		// else { - puse en el parcial :(
		ListaGenerica<Arista<Dato>> ady = sitios.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin() && (actual.getTiempoTot() < maxTiempo)) {
			Arista<Dato> arista = ady.proximo();
			Vertice<Dato> vProx = arista.verticeDestino();
			int tiempo = vProx.dato().getTiempo();
			int posProx = vProx.getPosicion();
			if (!marca[posProx] && ((actual.getTiempoTot() + tiempo) <= maxTiempo)) {
				dfs(posProx, sitios, resultado, actual, maxTiempo, marca);
				actual.decrementarTiempo(tiempo);
			}
		}
		// }
		marca[pos] = false;
		actual.eliminarUltimo();
	}

	private static int buscarOrigen(Grafo<Dato> sitios, String origen) {
		ListaGenerica<Vertice<Dato>> ldv = sitios.listaDeVertices();
		int pos = -1;
		ldv.comenzar();
		while (!ldv.fin() && pos == -1) {
			Vertice<Dato> vProx = ldv.proximo();
			if (vProx.dato().getNombre().equals(origen)) {
				pos = vProx.getPosicion();
			}
		}
		return pos;
	}
}
