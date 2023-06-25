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
		actual.getCamino().agregarFinal(v.dato().getNombre());
		actual.setTiempoTot(v.dato().getTiempo() + actual.getTiempoTot());
		if ((actual.getCamino().tamanio() > resultado.getCamino().tamanio())
				|| (actual.getCamino().tamanio() == resultado.getCamino().tamanio())
						&& (actual.getTiempoTot() < resultado.getTiempoTot())) {
			resultado.setCamino(actual.getCamino().clonar());
			resultado.setTiempoTot(actual.getTiempoTot());
		}
		// else { puse en el parcial :(
		ListaGenerica<Arista<Dato>> ady = sitios.listaDeAdyacentes(v);
		Arista<Dato> arista;
		Vertice<Dato> vProx;
		int tiempo = 0;
		int posProx;
		ady.comenzar();
		while (!ady.fin()/* && ((actual.getTiempoTot() + tiempo) < maxTiempo)) puse en el parcial :( */) {
			arista = ady.proximo();
			vProx = arista.verticeDestino();
			tiempo = vProx.dato().getTiempo();
			posProx = vProx.getPosicion();
			if (!marca[posProx] && ((actual.getTiempoTot() + tiempo) <= maxTiempo)) {
				dfs(posProx, sitios, resultado, actual, maxTiempo, marca);
				actual.setTiempoTot(actual.getTiempoTot() - tiempo);
			}
		}
		// }
		marca[pos] = false;
		actual.getCamino().eliminarEn(actual.getCamino().tamanio());
	}

	private static int buscarOrigen(Grafo<Dato> sitios, String origen) {
		int pos = -1;
		ListaGenerica<Vertice<Dato>> ldv = sitios.listaDeVertices();
		ldv.comenzar();
		while (!ldv.fin() && pos == -1) {
			Vertice<Dato> v = ldv.proximo();
			if (v.dato().getNombre().equals(origen)) {
				pos = v.getPosicion();
			}
		}
		return pos;
	}
}
