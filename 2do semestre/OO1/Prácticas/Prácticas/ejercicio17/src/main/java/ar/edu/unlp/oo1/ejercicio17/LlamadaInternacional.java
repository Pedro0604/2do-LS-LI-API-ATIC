package ar.edu.unlp.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {
	private String paisOrigen, paisDestino;

	public LlamadaInternacional(LocalDateTime inicio, int duracion, String numeroLlamador, String numeroRecibidor,
			String paisOrigen, String paisDestino) {
		super(inicio, duracion, numeroLlamador, numeroRecibidor);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}

	@Override
	protected double getCostoPorMinuto() {
		return (this.inicio.getHour() >= 8 && this.inicio.getHour() < 20) ? 4 : 3;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

}
