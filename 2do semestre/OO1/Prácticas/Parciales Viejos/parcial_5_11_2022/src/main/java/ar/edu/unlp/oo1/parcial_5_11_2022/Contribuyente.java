package ar.edu.unlp.oo1.parcial_5_11_2022;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contribuyente {
	private int dni;
	private String email, localidad;
	private List<Impuestable> bienes;

	public Contribuyente(int dni, String email, String localidad) {
		this.dni = dni;
		this.email = email;
		this.localidad = localidad;
		this.bienes = new ArrayList<>();
	}

	public Inmueble altaInmueble(int nroPartida, double valorLote, double valorEdificacion) {
		Inmueble i = new Inmueble(nroPartida, valorLote, valorEdificacion);
		this.bienes.add(i);
		return i;
	}

	public Automotor altaAutomotor(String patente, String marca, String modelo, LocalDate fechaFabricacion,
			double valor) {
		Automotor a = new Automotor(patente, fechaFabricacion, valor, marca, modelo);
		this.bienes.add(a);
		return a;
	}

	public Embarcacion altaEmbarcacion(String patente, String nombre, LocalDate fechaFabricacion, double valor) {
		Embarcacion e = new Embarcacion(patente, fechaFabricacion, valor, nombre);
		this.bienes.add(e);
		return e;
	}

	public double getImpuestos() {
		return this.bienes.stream().mapToDouble(b -> b.getImpuesto()).sum();
	}

	public boolean isFrom(String localidad) {
		return this.localidad.equals(localidad);
	}
}
