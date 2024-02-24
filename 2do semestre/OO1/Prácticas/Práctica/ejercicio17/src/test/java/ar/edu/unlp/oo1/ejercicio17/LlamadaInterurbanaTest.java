package ar.edu.unlp.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaInterurbanaTest {
	LlamadaInterurbana llamadaCortaDistancia, llamadaMediaDistancia, llamadaLargaDistancia;

	@BeforeEach
	void setUp() throws Exception {
		llamadaCortaDistancia = new LlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567",
				"221-987-6543", 10);
		llamadaMediaDistancia = new LlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567",
				"221-987-6543", 100);
		llamadaLargaDistancia = new LlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567",
				"221-987-6543", 500);
	}

	@Test
	public void testGetCostoPorMinuto() {
		assertEquals(llamadaCortaDistancia.getCostoPorMinuto(), 2);
		assertEquals(llamadaMediaDistancia.getCostoPorMinuto(), 2.5);
		assertEquals(llamadaLargaDistancia.getCostoPorMinuto(), 3);
	}

	@Test
	public void testGetCostoLLamada() {
		assertEquals(llamadaCortaDistancia.getCostoLlamada(), 5 + (10 * 2));
		assertEquals(llamadaMediaDistancia.getCostoLlamada(), 5 + (10 * 2.5));
		assertEquals(llamadaLargaDistancia.getCostoLlamada(), 5 + (10 * 3));
	}
}
