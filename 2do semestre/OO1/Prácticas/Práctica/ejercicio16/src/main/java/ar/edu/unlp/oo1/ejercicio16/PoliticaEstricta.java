package ar.edu.unlp.oo1.ejercicio16;

import java.time.LocalDate;

public class PoliticaEstricta implements PoliticaCancelacionable {

	@Override
	public double porcentajeAReembolsar(LocalDate fechaCancelacion, LocalDate fechaInicioReserva) {
		return 0;
	}
}
