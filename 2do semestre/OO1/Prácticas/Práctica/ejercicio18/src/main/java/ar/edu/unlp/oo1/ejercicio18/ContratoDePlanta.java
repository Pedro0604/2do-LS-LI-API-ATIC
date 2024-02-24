package ar.edu.unlp.oo1.ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato {
	private double sueldoMensual, montoPorConyuge, montoPorHijos;

	public ContratoDePlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual, double montoPorConyuge,
			double montoPorHijos) {
		super(empleado, fechaInicio, null);
		this.sueldoMensual = sueldoMensual;
		this.montoPorConyuge = montoPorConyuge;
		this.montoPorHijos = montoPorHijos;
	}

	@Override
	public double getBasico() {
		return this.sueldoMensual + montoPorConyuge + montoPorHijos;
	}

	@Override
	public int getDuracionEnDias() {
		return (int) ChronoUnit.DAYS.between(this.fechaInicio, LocalDate.now());
	}
}
