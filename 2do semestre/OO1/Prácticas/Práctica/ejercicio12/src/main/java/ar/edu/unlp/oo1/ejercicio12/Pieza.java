package ar.edu.unlp.oo1.ejercicio12;

public abstract class Pieza {
	private String color;
	private String material;

	public Pieza(String color, String material) {
		super();
		this.color = color;
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public String getColor() {
		return color;
	}

	public abstract double volumen();

	public abstract double superficie();
}
