package ar.edu.unlp.oo1.ejercicio21;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	protected String nombre;
	protected double saldo;
	protected List<Viaje> viajes;

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.saldo = 0;
		this.viajes = new ArrayList<>();
	}

	public void addViaje(Viaje v) {
		this.viajes.add(v);
	}

	public void cargarSaldo(double monto) {
		this.saldo += monto;
		this.saldo -= this.saldo * this.getComision();
	}

	protected abstract double getComision();
}
