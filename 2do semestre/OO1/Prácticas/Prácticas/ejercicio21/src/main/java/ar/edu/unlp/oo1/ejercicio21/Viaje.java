package ar.edu.unlp.oo1.ejercicio21;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Viaje {
	private String origen, destino;
	private Vehiculo vehiculo;
	private double costo;
	private LocalDate fechaViaje;
	private List<Usuario> pasajeros;

	public Viaje(String origen, String destino, Vehiculo vehiculo, double costo, LocalDate fechaViaje) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.vehiculo = vehiculo;
		this.costo = costo;
		this.fechaViaje = fechaViaje;
	}

	public boolean esEnUltimos30Dias() {
		return ChronoUnit.DAYS.between(fechaViaje, LocalDate.now()) <= 30;
	}
}
