package ar.edu.unlp.oo1.ejercicio21;

import java.util.ArrayList;
import java.util.List;

public class Conductor extends Usuario {
	private Vehiculo vehiculo;
	protected List<Viaje> viajes;

	public Conductor(String nombre, Vehiculo vehiculo) {
		super(nombre);
		this.vehiculo = vehiculo;
		this.viajes = new ArrayList<>();
	}

	public void addViaje(Viaje v) {
		this.viajes.add(v);
	}

	protected double getComision() {
		return this.vehiculo.getAniosVehiculo() < 5 ? 0.01 : 0.1;
	}
}
