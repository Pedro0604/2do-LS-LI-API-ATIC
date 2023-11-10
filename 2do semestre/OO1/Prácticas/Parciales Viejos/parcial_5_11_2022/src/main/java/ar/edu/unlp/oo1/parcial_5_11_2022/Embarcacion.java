package ar.edu.unlp.oo1.parcial_5_11_2022;

import java.time.LocalDate;

public class Embarcacion extends BienMovil {
	private String nombre;

	public Embarcacion(String patente, LocalDate fechaFabricacion, double valor, String nombre) {
		super(patente, fechaFabricacion, valor);
		this.nombre = nombre;
	}

	public double getPorcentajeMenorA10Anios() {
		return this.valor < 1_000_000 ? 0.1 : 0.15;
	}
}
