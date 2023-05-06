package primerParcial.AyED_Redictado_4_12_2012;

import tp02.ejercicio2.ListaGenerica;

public class Dato {
	private ListaGenerica<String> secuenciaDelTramite;
	private int largo;

	public Dato(ListaGenerica<String> secuenciaDelTramite) {
		super();
		this.secuenciaDelTramite = secuenciaDelTramite;
		this.largo = secuenciaDelTramite.tamanio();
	}

	public ListaGenerica<String> getSecuenciaDelTramite() {
		return secuenciaDelTramite;
	}

	public void setSecuenciaDelTramite(ListaGenerica<String> secuenciaDelTramite) {
		this.secuenciaDelTramite = secuenciaDelTramite;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	@Override
	public String toString() {
		return "Dato [secuenciaDelTramite=" + secuenciaDelTramite + ", largo=" + largo + "]";
	}
}
