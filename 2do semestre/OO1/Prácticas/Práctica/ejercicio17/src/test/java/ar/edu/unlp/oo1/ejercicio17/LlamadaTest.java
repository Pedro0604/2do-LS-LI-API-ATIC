package ar.edu.unlp.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaTest {
	Llamada l;

	@BeforeEach
	void setUp() throws Exception {
		l = new Llamada(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543");
	}

	@Test
	public void testGetCostoLLamada() {
		assertEquals(l.getCostoLlamada(), 10);
	}

	@Test
	public void testIsInPeriod() {
		assertTrue(l.isInPeriod(LocalDate.of(2023, 11, 8), LocalDate.of(2023, 11, 8)));
		assertTrue(l.isInPeriod(LocalDate.of(2023, 11, 8), LocalDate.of(2023, 11, 10)));
		assertTrue(l.isInPeriod(LocalDate.of(2023, 11, 6), LocalDate.of(2023, 11, 8)));
		assertTrue(l.isInPeriod(LocalDate.of(2023, 11, 6), LocalDate.of(2023, 11, 10)));

		assertFalse(l.isInPeriod(LocalDate.of(2023, 11, 9), LocalDate.of(2023, 11, 10)));
		assertFalse(l.isInPeriod(LocalDate.of(2023, 11, 6), LocalDate.of(2023, 11, 7)));
	}
}
