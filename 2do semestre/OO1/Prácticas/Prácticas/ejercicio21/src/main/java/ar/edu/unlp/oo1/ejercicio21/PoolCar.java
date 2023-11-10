package ar.edu.unlp.oo1.ejercicio21;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PoolCar {
	private List<Usuario> usuarios;

	public PoolCar() {
		usuarios = new ArrayList<>();
	}

	public Conductor altaConductor(String nombre, Vehiculo v) {
		Conductor nuevo = new Conductor(nombre, v);
		usuarios.add(nuevo);
		return nuevo;
	}

	public Pasajero altaPasajero(String nombre, Vehiculo v) {
		Pasajero nuevo = new Pasajero(nombre);
		usuarios.add(nuevo);
		return nuevo;
	}

	public Viaje altaViaje(String origen, String destino, double costo, Vehiculo vehiculo, LocalDate fecha) {
		if (ChronoUnit.DAYS.between(fecha, LocalDate.now()) < 2) {
			return null;
		} else {
			Viaje v = new Viaje(origen, destino, vehiculo, costo, fecha);
			vehiculo.addViajeToDuenio(v);
			return v;
		}
	}
}
