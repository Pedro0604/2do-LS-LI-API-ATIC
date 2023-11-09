package ar.edu.unlp.oo1.ejercicio21;

import java.time.LocalDate;

public class Vehiculo {
	private String descripcion;
	private int capacidad, anioFabricacion;
	private double valorMercado;

	public int getAniosVehiculo() {
		return LocalDate.now().getYear() - this.anioFabricacion;
	}
}
