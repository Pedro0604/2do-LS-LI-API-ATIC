package ar.edu.unlp.oo1.ejercicio8;

import java.time.LocalDate;

public class ConsumoOO1 {

	private LocalDate fecha;
	private double consumoDeEnergiaActiva;
	private double consumoDeEnergiaReactiva;

	public ConsumoOO1(LocalDate fecha, double consumoActiva, double consumoReactiva) {
		this.fecha = fecha;
		this.consumoDeEnergiaActiva = consumoActiva;
		this.consumoDeEnergiaReactiva = consumoReactiva;
	}

	public double factorDePotencia() {
		return this.consumoDeEnergiaActiva
				/ Math.sqrt(Math.pow(this.consumoDeEnergiaActiva, 2) + Math.pow(this.consumoDeEnergiaReactiva, 2));
	}

	public double costoEnBase(double precioKW) {
		return this.consumoDeEnergiaActiva * precioKW;

	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getConsumoDeEnergiaActiva() {
		return consumoDeEnergiaActiva;
	}

	public double getConsumoDeEnergiaReactiva() {
		return consumoDeEnergiaReactiva;
	}

}
