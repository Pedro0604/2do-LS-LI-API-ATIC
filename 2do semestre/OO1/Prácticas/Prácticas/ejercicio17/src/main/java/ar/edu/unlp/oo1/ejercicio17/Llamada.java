package ar.edu.unlp.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Llamada {
	protected LocalDateTime inicio;
	protected int duracion;
	protected String numeroLlamador, numeroRecibidor;

	public Llamada(LocalDateTime inicio, int duracion, String numeroLlamador, String numeroRecibidor) {
		super();
		this.inicio = inicio;
		this.duracion = duracion;
		this.numeroLlamador = numeroLlamador;
		this.numeroRecibidor = numeroRecibidor;
	}

	protected double getCostoPorMinuto() {
		return 1;
	}

	public double getCostoLlamada() {
		return this.duracion * this.getCostoPorMinuto();
	}

	public boolean isInPeriod(LocalDate inicioPeriodo, LocalDate finPeriodo) {
		return !this.inicio.toLocalDate().isBefore(inicioPeriodo) && !this.inicio.toLocalDate().isAfter(finPeriodo);
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getNumeroLlamador() {
		return numeroLlamador;
	}

	public String getNumeroRecibidor() {
		return numeroRecibidor;
	}
}
