package ar.edu.unlp.oo1.ejercicio8;

import java.time.LocalDate;

public class Consumo {
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	private LocalDate fecha;

	public Consumo(double consumoEnergiaActiva, double consumoEnergiaReactiva, LocalDate fecha) {
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
		this.fecha = fecha;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}

	public double costoEnBaseA(double precioKWh) {
		return this.consumoEnergiaActiva * precioKWh;
	}

	public double factorDePotencia() {
		double denominador = Math.pow(this.consumoEnergiaActiva, 2) + Math.pow(this.consumoEnergiaReactiva, 2);
		return this.consumoEnergiaActiva / Math.sqrt(denominador);
	}
}
