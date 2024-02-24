package ar.edu.unlp.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
	Reserva rFlex, rMod, rEst;
	DateLapseable periodo;
	Usuario duenio;

	@BeforeEach
	void setUp() throws Exception {
		periodo = new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 31));
		duenio = new Usuario("Pepe", 123412, "1 234");

		Propiedad pFlex = new Propiedad("Hotel", "hotelazo", 1000, "2 456", duenio, new PoliticaFlexible());
		Propiedad pMod = new Propiedad("Hotel", "hotelazo", 1000, "2 456", duenio, new PoliticaModerada());
		Propiedad pEst = new Propiedad("Hotel", "hotelazo", 1000, "2 456", duenio, new PoliticaEstricta());

		rFlex = new Reserva(periodo, pFlex);
		rMod = new Reserva(periodo, pMod);
		rEst = new Reserva(periodo, pEst);
	}

	@Test
	public void testMontoAReembolsarFlexible() {
		assertEquals(rFlex.montoAReembolsar(LocalDate.of(1, 1, 1)), rFlex.calcularPrecio());
		assertEquals(rFlex.montoAReembolsar(LocalDate.of(2023, 1, 9)), rFlex.calcularPrecio());
		assertEquals(rFlex.montoAReembolsar(LocalDate.of(2023, 1, 10)), 0);
		assertEquals(rFlex.montoAReembolsar(LocalDate.of(2100, 1, 1)), 0);
	}

	@Test
	public void testMontoAReembolsarModerado() {
		assertEquals(rMod.montoAReembolsar(LocalDate.of(1, 1, 1)), rMod.calcularPrecio());
		assertEquals(rMod.montoAReembolsar(LocalDate.of(2023, 1, 3)), rMod.calcularPrecio());
		assertEquals(rMod.montoAReembolsar(LocalDate.of(2023, 1, 4)), rMod.calcularPrecio() * 0.5);
		assertEquals(rMod.montoAReembolsar(LocalDate.of(2023, 1, 8)), rMod.calcularPrecio() * 0.5);
		assertEquals(rMod.montoAReembolsar(LocalDate.of(2023, 1, 9)), 0);
		assertEquals(rMod.montoAReembolsar(LocalDate.of(2023, 1, 10)), 0);
		assertEquals(rMod.montoAReembolsar(LocalDate.of(2100, 1, 1)), 0);
	}

	@Test
	public void testMontoAReembolsarEstricto() {
		assertEquals(rEst.montoAReembolsar(LocalDate.of(1, 1, 1)), 0);
		assertEquals(rEst.montoAReembolsar(LocalDate.of(2023, 1, 9)), 0);
		assertEquals(rEst.montoAReembolsar(LocalDate.of(2023, 1, 10)), 0);
		assertEquals(rEst.montoAReembolsar(LocalDate.of(2100, 1, 1)), 0);
	}
}
