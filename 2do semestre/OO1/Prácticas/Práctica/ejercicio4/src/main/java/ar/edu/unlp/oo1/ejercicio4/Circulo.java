package ar.edu.unlp.oo1.ejercicio4;

public class Circulo implements Cuerpo2D {
	private double radio;

	public Circulo() {
		this.radio = 0;
	}

	public Circulo(double radio) {
		this.radio = radio;
	}

	public double getRadio() {
		return this.radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getDiametro() {
		return this.radio * 2;
	}

	public void setDiametro(double diametro) {
		this.radio = diametro / 2;
	}

	public double getPerimetro() {
		return 2 * Math.PI * this.getRadio();
	}

	public double getArea() {
		return Math.PI * Math.pow(this.getRadio(), 2);
	}
}
