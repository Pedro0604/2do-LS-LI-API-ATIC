package ar.edu.unlp.oo1.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	Inversor i1, i2;

	@BeforeEach
	void setUp() throws Exception {
		i1 = new Inversor("Pedro");
		i2 = new Inversor("Jose");
	}

	private void aniadirInversiones(Inversor i) {
		PlazoFijo p1 = new PlazoFijo(LocalDate.of(2023, 9, 10), 420, 0.3);
		PlazoFijo p2 = new PlazoFijo(LocalDate.of(2023, 9, 29), 69, 0.1);
		InversionEnAcciones ia1 = new InversionEnAcciones("aapl", 420, 1500.23);
		InversionEnAcciones ia2 = new InversionEnAcciones("tsl", 69, 3400.61);
		i.addInversion(p1);
		i.addInversion(p2);
		i.addInversion(ia1);
		i.addInversion(ia2);
	}

	@Test
	public void testInicializar() {
		assertEquals(i1.getNombre(), "Pedro");
		assertEquals(i2.getNombre(), "Jose");
		assertEquals(i1.getInversiones().size(), 0);
		assertEquals(i2.getInversiones().size(), 0);
	}

	@Test
	public void testAddInversiones() {
		aniadirInversiones(i1);
		assertEquals(i1.getInversiones().size(), 4);
		aniadirInversiones(i1);
		assertEquals(i1.getInversiones().size(), 8);
		aniadirInversiones(i2);
		assertEquals(i2.getInversiones().size(), 4);
	}

	@Test
	public void testValorActual() {
		double valorInversiones = 420 * 1500.23 + 69 * 3400.61 + 79820.84785449936 + 69 * 1.1;
		aniadirInversiones(i1);
		assertEquals(i1.valorActual(), valorInversiones);
		aniadirInversiones(i1);
		assertEquals(i1.valorActual(), 2 * valorInversiones);
		aniadirInversiones(i2);
		assertEquals(i2.valorActual(), valorInversiones);
	}
}
