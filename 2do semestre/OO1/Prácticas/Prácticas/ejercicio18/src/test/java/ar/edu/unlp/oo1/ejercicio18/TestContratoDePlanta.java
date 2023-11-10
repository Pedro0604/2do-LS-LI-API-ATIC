package ar.edu.unlp.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestContratoDePlanta {
	ContratoDePlanta c1, c2;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new ContratoDePlanta(null, LocalDate.of(2023, 10, 1), 0, 0, 0);
		c2 = new ContratoDePlanta(null, LocalDate.of(2023, 11, 1), 0, 0, 0);
	}

	@Test
	public void testIsActivo() {
		assertTrue(c1.isActivo());
		assertTrue(c2.isActivo());
	}

	@Test
	public void testGetDuracionEnDias() {
		assertEquals(c1.getDuracionEnDias(), 40);
		assertEquals(c2.getDuracionEnDias(), 9);
	}
}
