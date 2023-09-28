package ar.edu.unlp.oo1.ejercicio11;

public class InversionEnAcciones implements ValorActualeable {
	private String nombre;
	private int cantidad;
	private double valorUnitario;

	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}

	@Override
	public double valorActual() {
		return cantidad * valorUnitario;
	}
}
