package ar.edu.unlp.oo1.ejercicio8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;

	public Factura(Usuario usuario, double montoEnergiaActiva, double descuento, LocalDate fecha) {
		this.usuario = usuario;
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.fecha = fecha;
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public double montoTotal() {
		return this.montoEnergiaActiva - this.montoEnergiaActiva * this.descuento;
	}

	public Usuario usuario() {
		return this.usuario;
	}

	public LocalDate fecha() {
		return this.fecha;
	}

	public double descuento() {
		return this.descuento;
	}
}
