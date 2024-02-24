package ar.edu.unlp.oo1.ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato {
	private double valorPorHora;
	private int cantHorasMes;

	public ContratoPorHoras(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double valorPorHora,
			int cantHorasMes) {
		super(empleado, fechaInicio, fechaFin);
		this.valorPorHora = valorPorHora;
		this.cantHorasMes = cantHorasMes;
	}

	@Override
	public double getBasico() {
		return this.valorPorHora * this.cantHorasMes;
	}

	@Override
	public int getDuracionEnDias() {
		return (int) ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFin);
	}
}
