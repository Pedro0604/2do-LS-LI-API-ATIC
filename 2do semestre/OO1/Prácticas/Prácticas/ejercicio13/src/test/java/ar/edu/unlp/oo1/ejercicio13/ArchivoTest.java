package ar.edu.unlp.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	Archivo a1, a2;

	@BeforeEach
	void setUp() throws Exception {
		a1 = new Archivo("hola", 10);
		a2 = new Archivo("chau", 20);
	}

	@Test
	public void testInicializar() {
		assertEquals(a1.getNombre(), "hola");
		assertEquals(a1.getTamanio(), 10);

		assertEquals(a2.getNombre(), "chau");
		assertEquals(a2.getTamanio(), 20);
	}
}