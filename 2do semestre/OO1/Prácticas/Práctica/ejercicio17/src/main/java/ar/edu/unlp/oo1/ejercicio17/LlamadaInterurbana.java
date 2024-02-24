package ar.edu.unlp.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada {
	private int distancia;

	public LlamadaInterurbana(LocalDateTime inicio, int duracion, String numeroLlamador, String numeroRecibidor,
			int distancia) {
		super(inicio, duracion, numeroLlamador, numeroRecibidor);
		this.distancia = distancia;
	}

	@Override
	protected double getCostoPorMinuto() {
		return this.distancia < 100 ? 2 : this.distancia < 500 ? 2.5 : 3;
	}

	@Override
	public double getCostoLlamada() {
		return 5 + super.getCostoLlamada();
	}

	public int getDistancia() {
		return distancia;
	}

}
