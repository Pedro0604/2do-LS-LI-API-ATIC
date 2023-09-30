package ar.edu.unlp.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CilindroTest {
	Cilindro c1, c2;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Cilindro("Verde", "Madera", 3.4, 1.23);
		c2 = new Cilindro("Azul", "Metal", 0.3, 11.78);
	}

	@Test
	public void testInicializar() {
		assertEquals(c1.getColor(), "Verde");
		assertEquals(c1.getMaterial(), "Madera");
		assertEquals(c1.getRadio(), 3.4);
		assertEquals(c1.getAltura(), 1.23);

		assertEquals(c2.getColor(), "Rojo");
		assertEquals(c2.getMaterial(), "Metal");
		assertEquals(c2.getRadio(), 0.3);
		assertEquals(c2.getAltura(), 11.78);
	}

	@Test
	public void testVolumen() {
		assertEquals(c1.volumen(), 44.66967762286255, 0.0001);

		assertEquals(c2.volumen(), 3.3307165313358986, 0.0001);
	}

	@Test
	public void testSuperficie() {
		assertEquals(c1.superficie(), 98.909882528, 0.0001);

		assertEquals(c2.superficie(), 22.770258816, 0.0001);
	}
}
