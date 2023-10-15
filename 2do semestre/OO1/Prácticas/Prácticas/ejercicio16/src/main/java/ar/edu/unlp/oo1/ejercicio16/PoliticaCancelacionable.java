package ar.edu.unlp.oo1.ejercicio16;

import java.time.LocalDate;

public interface PoliticaCancelacionable {
	public double porcentajeAReembolsar(LocalDate fechaCancelacion, LocalDate fechaInicioReserva);
}
