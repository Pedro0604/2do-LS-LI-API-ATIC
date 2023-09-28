package ar.edu.unlp.oo1.ejercicio8;

import java.time.LocalDate;

public class FacturaOO1 {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private UsuarioOO1 usuario;

	public FacturaOO1(double montoEnergiaActiva, double descuento, UsuarioOO1 usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
		this.usuario = usuario;
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public double getDescuento() {
		return descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public UsuarioOO1 getUsuario() {
		return usuario;
	}

	public double montoTotal() {
		return this.montoEnergiaActiva * (1 - this.descuento / 100);
	}

}
