package ar.edu.unlp.oo1.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlazoFijoTest {
	PlazoFijo p1, p2;

	@BeforeEach
	void setUp() throws Exception {
		p1 = new PlazoFijo(LocalDate.of(2023, 9, 10), 420, 0.3);
		p2 = new PlazoFijo(LocalDate.of(2023, 9, 29), 69, 0.1);
	}

	@Test
	public void testInicializar() {
		assertEquals(p1.getFechaConstitucion(), LocalDate.of(2023, 9, 10));
		assertEquals(p1.getMontoDepositado(), 420);
		assertEquals(p1.getPorcentajeDeInteresDiario(), 0.3);

		assertEquals(p2.getFechaConstitucion(), LocalDate.of(2023, 9, 29));
		assertEquals(p2.getMontoDepositado(), 69);
		assertEquals(p2.getPorcentajeDeInteresDiario(), 0.1);
	}

	@Test
	public void testValorActual() {
		assertEquals(p1.valorActual(), 79820.84785449936);
		assertEquals(p2.valorActual(), 69 * 1.1);
	}
}
