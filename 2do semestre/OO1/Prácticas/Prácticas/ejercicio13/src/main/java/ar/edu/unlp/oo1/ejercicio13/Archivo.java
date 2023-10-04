package ar.edu.unlp.oo1.ejercicio13;

public class Archivo {
	private String nombre;
	private int tamanio;

	public Archivo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamanio() {
		return tamanio;
	}
}
