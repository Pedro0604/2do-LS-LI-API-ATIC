package ar.edu.unlp.oo1.parcial_5_11_2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContribuyenteTest {
	private Contribuyente c;

	@BeforeEach
	void SetUp() throws Exception {
		c = new Contribuyente(45454545, "hola@hola.com", "La Plata");
	}

	@Test
	public void testGetImpuestos() {
		assertEquals(c.getImpuestos(), 0);
		c.altaEmbarcacion("abc", "La Matadora", LocalDate.of(2012, 11, 10), 50_000);
		assertEquals(c.getImpuestos(), 0);
		c.altaEmbarcacion("def", "La Sirvienta", LocalDate.of(2023, 11, 11), 999_999);
		assertEquals(c.getImpuestos(), 99_999.9, 0.001);
		c.altaEmbarcacion("ghi", "La Ricachona", LocalDate.of(2023, 11, 11), 1_000_000);
		assertEquals(c.getImpuestos(), 249_999.9, 0.001);
	}
}
