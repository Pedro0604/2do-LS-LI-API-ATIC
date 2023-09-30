package ar.edu.unlp.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {
	Esfera e1, e2;

	@BeforeEach
	void setUp() throws Exception {
		e1 = new Esfera("Rojo", "Metal", 2.71);
		e2 = new Esfera("Azul", "Plastico", 3.14);
	}

	@Test
	public void testInicializar() {
		assertEquals(e1.getColor(), "Rojo");
		assertEquals(e1.getMaterial(), "Plastico");
		assertEquals(e1.getRadio(), 2.71);

		assertEquals(e2.getColor(), "Azul");
		assertEquals(e2.getMaterial(), "Madera");
		assertEquals(e2.getRadio(), 3.14);
	}

	@Test
	public void testVolumen() {
		assertEquals(e1.volumen(), 83.3674431274534, 0.0001);

		assertEquals(e2.volumen(), 129.68135913577134, 0.0001);
	}

	@Test
	public void testSuperficie() {
		assertEquals(e1.superficie(), 92.2886632288, 0.0001);

		assertEquals(e2.superficie(), 123.8993619328, 0.0001);
	}
}
