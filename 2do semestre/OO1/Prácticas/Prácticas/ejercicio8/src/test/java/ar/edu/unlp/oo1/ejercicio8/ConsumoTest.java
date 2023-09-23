package ar.edu.unlp.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsumoTest {

	Consumo c1, c2;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Consumo(10, 20, LocalDate.of(2022, 10, 8));
		c2 = new Consumo(20, 85, LocalDate.of(2021, 10, 8));
	}

	@Test
	public void testCrearConsumo() {
		assertEquals(c1.getConsumoEnergiaActiva(), 10);
		assertEquals(c2.getConsumoEnergiaActiva(), 20);

		assertEquals(c1.getConsumoEnergiaReactiva(), 20);
		assertEquals(c2.getConsumoEnergiaReactiva(), 85);

		assertEquals(c1.getFecha(), LocalDate.of(2022, 10, 8));
		assertEquals(c2.getFecha(), LocalDate.of(2021, 10, 8));
	}

	@Test
	public void testCostoEnBaseA() {
		assertEquals(c1.costoEnBaseA(35), 350);
		assertEquals(c2.costoEnBaseA(35), 700);
	}

	@Test
	public void testFactorDePotencia() {
		Double fdp1 = 10 / Math.sqrt(500);
		Double fdp2 = 20 / Math.sqrt(7625);

		assertEquals(c1.factorDePotencia(), fdp1);
		assertEquals(c2.factorDePotencia(), fdp2);
	}
}
