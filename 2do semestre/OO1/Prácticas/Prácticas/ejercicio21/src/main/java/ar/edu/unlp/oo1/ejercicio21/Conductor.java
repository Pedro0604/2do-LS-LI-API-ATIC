package ar.edu.unlp.oo1.ejercicio21;

public class Conductor extends Usuario {
	private Vehiculo vehiculo;

	public Conductor(String nombre, Vehiculo vehiculo) {
		super(nombre);
		this.vehiculo = vehiculo;
	}

	protected double getComision() {
		return this.vehiculo.getAniosVehiculo() < 5 ? 0.01 : 0.1;
	}
}
