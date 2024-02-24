package ar.edu.unlp.oo1.ejercicio18;

import java.time.LocalDate;

public abstract class Contrato {
	protected Empleado empleado;
	protected LocalDate fechaInicio, fechaFin;

	public Contrato(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public boolean isActivo() {
		return this.fechaFin == null || this.fechaFin.isAfter(LocalDate.now());
	}

	public boolean isVencido() {
		return !this.isActivo();
	}

	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public abstract double getBasico();

	public abstract int getDuracionEnDias();
}
