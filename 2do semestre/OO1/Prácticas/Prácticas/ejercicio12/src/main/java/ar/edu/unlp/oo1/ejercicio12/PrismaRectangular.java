package ar.edu.unlp.oo1.ejercicio12;

public class PrismaRectangular extends Pieza {
	private double ladoMayor, ladoMenor, altura;

	public PrismaRectangular(String color, String material, double ladoMayor, double ladoMenor, double altura) {
		super(color, material);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
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
