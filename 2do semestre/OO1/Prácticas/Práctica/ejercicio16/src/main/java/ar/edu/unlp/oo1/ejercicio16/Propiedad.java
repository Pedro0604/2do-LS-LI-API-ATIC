package ar.edu.unlp.oo1.ejercicio16;

import java.time.LocalDate;

public class Propiedad {
	private String nombre, descripcion;
	private double precioNoche;
	private String direccion;
	private Usuario duenio;
	private PoliticaCancelacionable politica;

	public Propiedad(String nombre, String descripcion, double precioNoche, String direccion, Usuario duenio,
			PoliticaCancelacionable politica) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.direccion = direccion;
		this.duenio = duenio;
		this.politica = politica;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public Usuario getDuenio() {
		return duenio;
	}

	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}

	public boolean tieneComoDuenio(Usuario duenio) {
		return this.duenio == duenio;
	}

	public double porcentajeAReembolsar(LocalDate fechaCancelacion, LocalDate fechaInicioReserva) {
		return politica.porcentajeAReembolsar(fechaCancelacion, fechaInicioReserva);
	}
}
