package primerParcial.modulo1_AyED_2022.ejercicio2;

public class Personaje {
	private String nombre;

	public Personaje(String nombre) {
		this.nombre = nombre;
	}

	public Personaje(String nombre, boolean esAccesible) {
		this.nombre = nombre;
	}

	public Personaje() {
		this.nombre = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + /* ", esAccesible=" + esAccesible + */"]";
	}
}
