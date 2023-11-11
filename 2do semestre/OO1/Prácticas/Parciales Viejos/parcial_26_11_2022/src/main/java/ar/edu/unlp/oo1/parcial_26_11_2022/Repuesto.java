package ar.edu.unlp.oo1.parcial_26_11_2022;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Repuesto {
	private String nombre;
	private double costo;
	private LocalDate fechaFabricacion;

	public Repuesto(String nombre, double costo, LocalDate fechaFabricacion) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.fechaFabricacion = fechaFabricacion;
	}

	public double getCosto() {
		return costo;
	}

	public boolean isOlderThan5() {
		return ChronoUnit.YEARS.between(this.fechaFabricacion, LocalDate.now()) > 5;
	}
}
