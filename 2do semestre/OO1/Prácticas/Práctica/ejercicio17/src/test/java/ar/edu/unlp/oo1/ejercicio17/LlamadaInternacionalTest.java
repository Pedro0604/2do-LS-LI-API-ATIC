package ar.edu.unlp.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaInternacionalTest {
	LlamadaInternacional llamadaDiurna, llamadaNocturna;

	@BeforeEach
	void setUp() throws Exception {
		llamadaDiurna = new LlamadaInternacional(LocalDateTime.of(2023, 11, 8, 8, 0, 0), 10, "221-123-4567",
				"221-987-6543", "Argentina", "Brasil");
		llamadaNocturna = new LlamadaInternacional(LocalDateTime.of(2023, 11, 8, 20, 0, 0), 10, "221-123-4567",
				"221-987-6543", "Argentina", "Australia");
	}

	@Test
	public void testGetCostoPorMinuto() {
		assertEquals(llamadaDiurna.getCostoPorMinuto(), 4);
		assertEquals(llamadaNocturna.getCostoPorMinuto(), 3);
	}

	@Test
	public void testGetCostoLLamada() {
		assertEquals(llamadaDiurna.getCostoLlamada(), 40);
		assertEquals(llamadaNocturna.getCostoLlamada(), 30);
	}
}
