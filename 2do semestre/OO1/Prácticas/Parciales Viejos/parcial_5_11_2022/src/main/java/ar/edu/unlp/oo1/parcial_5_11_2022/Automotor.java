package ar.edu.unlp.oo1.parcial_5_11_2022;

import java.time.LocalDate;

public class Automotor extends BienMovil {
	private String marca, modelo;

	public Automotor(String patente, LocalDate fechaFabricacion, double valor, String marca, String modelo) {
		super(patente, fechaFabricacion, valor);
		this.marca = marca;
		this.modelo = modelo;
	}

	public double getPorcentajeMenorA10Anios() {
		return 0.05;
	}
}
