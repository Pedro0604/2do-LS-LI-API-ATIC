package ar.edu.unlp.oo1.ejercicio21;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoolCar {
	private List<Usuario> usuarios;
	private List<Viaje> viajes;

	public PoolCar() {
		usuarios = new ArrayList<>();
		viajes = new ArrayList<>();
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
			this.viajes.add(v);
			return v;
		}
	}

	public List<Viaje> listarViajesManiana() {
		return this.usuarios.stream().flatMap(u -> u.getViajesManiana().stream()).distinct()
				.collect(Collectors.toList());
	}

	public void procesarViajes() {
		List<Usuario> usuariosManiana = this.usuarios.stream()
				.filter(u -> u.participaEnViaje(this.listarViajesManiana())).collect(Collectors.toList());
		usuariosManiana.stream().forEach(u -> u.descontarSaldo());
	}
}
