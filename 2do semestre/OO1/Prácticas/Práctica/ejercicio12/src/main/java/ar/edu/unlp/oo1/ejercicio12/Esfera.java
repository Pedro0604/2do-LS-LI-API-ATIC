package ar.edu.unlp.oo1.ejercicio12;

public class Esfera extends Pieza {
	private double radio;

	public Esfera(String color, String material, double radio) {
		super(color, material);
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	@Override
	public double volumen() {
		return (4 / 3d) * Math.PI * Math.pow(this.radio, 3);
	}

	@Override
	public double superficie() {
		return 4 * Math.PI * Math.pow(this.radio, 2);
	}
}
