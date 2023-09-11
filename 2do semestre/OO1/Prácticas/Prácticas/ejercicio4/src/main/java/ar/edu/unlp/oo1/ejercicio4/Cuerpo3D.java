package ar.edu.unlp.oo1.ejercicio4;

public class Cuerpo3D {
	private Cuerpo2D caraBasal;
	private double altura;

	public void setCaraBasal(Cuerpo2D caraBasal) {
		this.caraBasal = caraBasal;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getVolumen() {
		return this.caraBasal.getArea() * this.altura;
	}

	public double getSuperficieExterior() {
		return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.altura;
	}
}
