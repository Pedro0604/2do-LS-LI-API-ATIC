package ar.edu.unlp.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestContratoPorHoras {
	ContratoPorHoras cVencido, cActivo;

	@BeforeEach
	void setUp() throws Exception {
		cVencido = new ContratoPorHoras(null, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31), 0, 0);
		cActivo = new ContratoPorHoras(null, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), 0, 0);
	}

	@Test
	public void testIsActivo() {
		assertFalse(cVencido.isActivo());
		assertTrue(cActivo.isActivo());
	}

	@Test
	public void testGetDuracionEnDias() {
		assertEquals(cVencido.getDuracionEnDias(), 30);
		assertEquals(cActivo.getDuracionEnDias(), 365);
	}
}
