package ar.edu.unlp.oo1.ejercicio21;

public abstract class Usuario {
	protected String nombre;
	protected double saldo;

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.saldo = 0;
	}

	public void cargarSaldo(double monto) {
		this.saldo += monto;
		this.saldo -= this.saldo * this.getComision();
	}

	protected abstract double getComision();
}
