package ar.edu.unlp.oo1.ejercicio11;

import java.time.Duration;
import java.time.LocalDate;

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

	@Override
	public double valorActual() {
		long dias = Duration.between(fechaConstitucion, LocalDate.now()).toDays();
		double valor = montoDepositado;
		for (int i = 1; i <= dias; i++) {
			valor += valor * porcentajeDeInteresDiario;
		}
		return valor;
	}

}
