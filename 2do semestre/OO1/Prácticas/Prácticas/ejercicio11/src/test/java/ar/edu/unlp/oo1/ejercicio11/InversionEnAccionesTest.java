package ar.edu.unlp.oo1.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversionEnAccionesTest {
	InversionEnAcciones i1, i2;

	@BeforeEach
	void setUp() throws Exception {
		i1 = new InversionEnAcciones("aapl", 420, 1500.23);
		i2 = new InversionEnAcciones("tsl", 69, 3400.61);
	}

	@Test
	public void testInicializar() {
		assertEquals(i1.getNombre(), "aapl");
		assertEquals(i1.getCantidad(), 420);
		assertEquals(i1.getValorUnitario(), 1500.23);

		assertEquals(i2.getNombre(), "tsl");
		assertEquals(i2.getCantidad(), 69);
		assertEquals(i2.getValorUnitario(), 3400.61);
	}

	@Test
	public void testValorActual() {
		assertEquals(i1.valorActual(), 420 * 1500.23);
		assertEquals(i2.valorActual(), 69 * 3400.61);
	}
}
