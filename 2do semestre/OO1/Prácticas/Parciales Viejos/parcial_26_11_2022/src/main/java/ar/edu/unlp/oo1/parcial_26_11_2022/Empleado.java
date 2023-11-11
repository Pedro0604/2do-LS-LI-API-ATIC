package ar.edu.unlp.oo1.parcial_26_11_2022;

public class Empleado {
	private String nombre;
	private double valorHora;

	public Empleado(String nombre, double valorHora) {
		super();
		this.nombre = nombre;
		this.valorHora = valorHora;
	}

	public double getValorHora() {
		return valorHora;
	}

}
