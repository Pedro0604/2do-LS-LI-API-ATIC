package ar.edu.unlp.oo1.ejercicio12;

public class Cilindro extends Pieza {
	private double radio;
	private double altura;

	public Cilindro(String color, String material, double radio, double altura) {
		super(color, material);
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public double volumen() {
		return Math.PI * Math.pow(this.radio, 2) * this.altura;
	}

	@Override
	public double superficie() {
		return 2 * Math.PI * this.radio * this.altura + 2 * Math.PI * Math.pow(this.radio, 2);
	}
}
