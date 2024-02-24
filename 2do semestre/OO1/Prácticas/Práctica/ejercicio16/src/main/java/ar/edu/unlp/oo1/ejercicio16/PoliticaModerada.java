package ar.edu.unlp.oo1.ejercicio16;

import java.time.LocalDate;

public class PoliticaModerada implements PoliticaCancelacionable {

	@Override
	public double porcentajeAReembolsar(LocalDate fechaCancelacion, LocalDate fechaInicioReserva) {
		int diasAntes = fechaCancelacion.until(fechaInicioReserva).getDays();
		return diasAntes >= 7 ? 1 : diasAntes >= 2 ? 0.5 : 0;
	}
}
