package ar.edu.unlp.oo1.parcial_5_11_2022;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class BienMovil implements Impuestable {
	private String patente;
	private LocalDate fechaFabricacion;
	protected double valor;

	public BienMovil(String patente, LocalDate fechaFabricacion, double valor) {
		this.patente = patente;
		this.fechaFabricacion = fechaFabricacion;
		this.valor = valor;
	}

	public abstract double getPorcentajeMenorA10Anios();

	public double getImpuesto() {
		long anios = ChronoUnit.YEARS.between(fechaFabricacion, LocalDate.now());
		if (anios > 10) {
			return 0;
		} else {
			return (this.getPorcentajeMenorA10Anios() * this.valor);
		}
	}
}
