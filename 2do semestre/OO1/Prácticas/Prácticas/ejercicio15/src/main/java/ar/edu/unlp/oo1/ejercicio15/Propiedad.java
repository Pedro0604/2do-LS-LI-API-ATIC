package ar.edu.unlp.oo1.ejercicio15;

public class Propiedad {
	private String nombre, descripcion;
	private double precioNoche;
	private String direccion;
	private Usuario duenio;
	
	public Propiedad(String nombre, String descripcion, double precioNoche, String direccion, Usuario duenio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.direccion = direccion;
		this.duenio = duenio;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}
	
	public boolean tieneComoDuenio(Usuario duenio) {
		return this.duenio == duenio;
	}
}
