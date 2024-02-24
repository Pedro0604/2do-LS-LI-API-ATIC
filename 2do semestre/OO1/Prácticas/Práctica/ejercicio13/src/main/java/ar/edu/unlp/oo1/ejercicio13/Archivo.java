package ar.edu.unlp.oo1.ejercicio13;

public class Archivo {
	private String nombre;
	private int tamanio;

	public Archivo(String nombre, int tamanio) {
		super();
		this.nombre = nombre;
		this.tamanio = tamanio;
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
