package ar.edu.unlp.oo1.parcial_5_11_2022;

public class Inmueble implements Impuestable {
	private int nroPartida;
	private double valorLote, valorEdificacion;

	public Inmueble(int nroPartida, double valorLote, double valorEdificacion) {
		this.nroPartida = nroPartida;
		this.valorLote = valorLote;
		this.valorEdificacion = valorEdificacion;
	}

	public double getImpuesto() {
		return 0.01 * (valorLote + valorEdificacion);
	}
}
