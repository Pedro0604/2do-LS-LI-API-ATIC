package ar.edu.unlp.oo1.ejercicio11;

import java.time.LocalDate;
import java.time.Period;

public class PlazoFijo implements ValorActualeable {
	private LocalDate fechaConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;

	public PlazoFijo(LocalDate fechaConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		super();
		this.fechaConstitucion = fechaConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public LocalDate getFechaConstitucion() {
		return fechaConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}

	@Override
	public double valorActual() {
		long dias = Period.between(fechaConstitucion, LocalDate.now()).getDays();
		double valor = montoDepositado;
		for (int i = 1; i <= dias; i++) {
			valor += valor * porcentajeDeInteresDiario;
		}
		return valor;
	}
}
