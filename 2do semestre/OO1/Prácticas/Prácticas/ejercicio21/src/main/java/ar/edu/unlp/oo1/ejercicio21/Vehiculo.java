package ar.edu.unlp.oo1.ejercicio21;

import java.time.LocalDate;

public class Vehiculo {
	private Conductor duenio;
	private String descripcion;
	private int capacidad, anioFabricacion;
	private double valorMercado;

	public int getAniosVehiculo() {
		return LocalDate.now().getYear() - this.anioFabricacion;
	}
	
	public void addViajeToDuenio(Viaje v) {
		this.duenio.addViaje(v);
	}
}
