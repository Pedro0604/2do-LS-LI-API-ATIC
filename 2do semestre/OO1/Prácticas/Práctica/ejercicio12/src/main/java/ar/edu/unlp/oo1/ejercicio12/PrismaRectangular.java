package ar.edu.unlp.oo1.ejercicio12;

public class PrismaRectangular extends Pieza {
	private double ladoMayor, ladoMenor, altura;

	public PrismaRectangular(String color, String material, double ladoMenor, double ladoMayor, double altura) {
		super(color, material);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}

	public double getLadoMayor() {
		return ladoMayor;
	}

	public double getLadoMenor() {
		return ladoMenor;
	}

	public double getAltura() {
		return altura;
	}

	@Override
	public double volumen() {
		return this.ladoMayor * this.ladoMenor * this.altura;
	}

	@Override
	public double superficie() {
		return 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura);
	}
}
