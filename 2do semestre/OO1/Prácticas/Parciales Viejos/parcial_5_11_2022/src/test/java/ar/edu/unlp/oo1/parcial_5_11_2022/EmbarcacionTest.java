package ar.edu.unlp.oo1.parcial_5_11_2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmbarcacionTest {
	private Embarcacion eVieja, eNuevaBarata, eNuevaCara;

	@BeforeEach
	void setUp() throws Exception {
		eVieja = new Embarcacion("abc", LocalDate.of(2012, 11, 10), 50_000, "La Matadora");
		eNuevaBarata = new Embarcacion("def", LocalDate.of(2023, 11, 11), 999_999, "La Sirvienta");
		eNuevaCara = new Embarcacion("ghi", LocalDate.of(2023, 11, 11), 1_000_000, "La Ricachona");
	}

	@Test
	public void testGetPorcentajeMenorA10Anios() {
		assertEquals(eNuevaBarata.getPorcentajeMenorA10Anios(), 0.1);
		assertEquals(eNuevaCara.getPorcentajeMenorA10Anios(), 0.15);
	}

	@Test
	public void testGetImpuesto() {
		assertEquals(eVieja.getImpuesto(), 0);
		assertEquals(eNuevaBarata.getImpuesto(), 99_999.9, 0.001);
		assertEquals(eNuevaCara.getImpuesto(), 150_000, 0.001);
	}
}
