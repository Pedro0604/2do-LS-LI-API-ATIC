package segundoParcial.MiParcial;

import tp02.ejercicio2.ListaGenerica;

public class InfoCamino {
	private ListaGenerica<String> camino;
	private int tiempoTot;

	public InfoCamino(ListaGenerica<String> camino, int tiempoTot) {
		this.camino = camino;
		this.tiempoTot = tiempoTot;
	}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}

	public int getTiempoTot() {
		return tiempoTot;
	}

	public void setTiempoTot(int tiempoTot) {
		this.tiempoTot = tiempoTot;
	}

}
