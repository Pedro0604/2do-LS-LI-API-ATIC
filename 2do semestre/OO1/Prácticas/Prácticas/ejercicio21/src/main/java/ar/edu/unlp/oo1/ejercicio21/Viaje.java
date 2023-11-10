package ar.edu.unlp.oo1.ejercicio21;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
		this.pasajeros = new ArrayList<>();
		this.pasajeros.add(this.vehiculo.getDuenio());
	}

	public boolean esEnUltimos30Dias() {
		return ChronoUnit.DAYS.between(fechaViaje, LocalDate.now()) <= 30;
	}

	public boolean esManiana() {
		return ChronoUnit.DAYS.between(LocalDate.now(), fechaViaje) == 1;
	}
}
