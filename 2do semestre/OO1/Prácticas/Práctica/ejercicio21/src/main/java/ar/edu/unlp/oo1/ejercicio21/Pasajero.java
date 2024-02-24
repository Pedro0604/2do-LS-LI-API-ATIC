package ar.edu.unlp.oo1.ejercicio21;

public class Pasajero extends Usuario {
	public Pasajero(String nombre) {
		super(nombre);
	}

	protected double getComision() {
		return this.viajes.stream().anyMatch(v -> v.esEnUltimos30Dias()) ? 0 : 0.1;
	}
}
