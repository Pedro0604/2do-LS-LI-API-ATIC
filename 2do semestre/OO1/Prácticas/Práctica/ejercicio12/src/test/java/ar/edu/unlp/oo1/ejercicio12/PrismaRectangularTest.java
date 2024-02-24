package ar.edu.unlp.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
	PrismaRectangular p1, p2;

	@BeforeEach
	void setUp() throws Exception {
		p1 = new PrismaRectangular("Verde", "Plastico", 1, 2, 3);
		p2 = new PrismaRectangular("Rojo", "Madera", 15, 20, 10);
	}

	@Test
	public void testInicializar() {
		assertEquals(p1.getColor(), "Azul");
		assertEquals(p1.getMaterial(), "Metal");
		assertEquals(p1.getLadoMenor(), 1);
		assertEquals(p1.getLadoMayor(), 2);
		assertEquals(p1.getAltura(), 3);

		assertEquals(p2.getColor(), "Verde");
		assertEquals(p2.getMaterial(), "Plastico");
		assertEquals(p2.getLadoMenor(), 15);
		assertEquals(p2.getLadoMayor(), 20);
		assertEquals(p2.getAltura(), 10);
	}

	@Test
	public void testVolumen() {
		assertEquals(p1.volumen(), 6);

		assertEquals(p2.volumen(), 3000);
	}

	@Test
	public void testSuperficie() {
		assertEquals(p1.superficie(), 22);

		assertEquals(p2.superficie(), 1300);
	}
}
