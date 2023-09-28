package ar.edu.unlp.oo1.ejercicio12;

public class Esfera extends Pieza {
	private double radio;

	public Esfera(String color, String material, double radio) {
		super(color, material);
		this.radio = radio;
	}

	@Override
	public double volumen() {
		return Math.PI * Math.pow(this.radio, 3) * (4 / 3);
	}

	@Override
	public double superficie() {
		return 4 * Math.PI * Math.pow(this.radio, 2);
	}
}
