package ar.edu.unlp.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int dni;
	private String direccion;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;

	public Usuario(String nombre, int dni, String direccion) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.propiedades = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

}
