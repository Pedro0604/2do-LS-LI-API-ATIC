package ar.edu.unlp.oo1.ejercicio4;

public class Cuadrado implements Cuerpo2D {
	private double lado;

	public Cuadrado() {
		this.lado = 0;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getPerimetro() {
		return lado * 4;
	}

	public double getArea() {
		return Math.pow(lado, 2);
	}
}
