package ar.edu.unlp.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	ReporteDeConstruccion r1, r2;

	@BeforeEach
	void setUp() throws Exception {
		r1 = new ReporteDeConstruccion();
		r2 = new ReporteDeConstruccion();
	}

	@Test
	public void testInicializar() {
		assertEquals(r1.getPiezas().size(), 0);

		assertEquals(r2.getPiezas().size(), 0);
	}

	private void aniadirPiezas(ReporteDeConstruccion r) {
		r.addPieza(new Cilindro("Verde", "Madera", 3.4, 1.23));
		r.addPieza(new Cilindro("Azul", "Metal", 0.3, 11.78));
		r.addPieza(new Esfera("Rojo", "Metal", 2.71));
		r.addPieza(new Esfera("Azul", "Plastico", 3.14));
		r.addPieza(new PrismaRectangular("Verde", "Plastico", 1, 2, 3));
		r.addPieza(new PrismaRectangular("Rojo", "Madera", 15, 20, 10));
	}

	@Test
	public void testAddPiezas() {
		aniadirPiezas(r1);
		assertEquals(r1.getPiezas().size(), 6);
		aniadirPiezas(r1);
		assertEquals(r1.getPiezas().size(), 12);

		aniadirPiezas(r2);
		assertEquals(r2.getPiezas().size(), 6);
	}

	@Test
	public void testVolumenDeMaterial() {
		assertEquals(r1.getVolumenDeMaterial("Metal"), 0);
		assertEquals(r1.getVolumenDeMaterial("Madera"), 0);
		assertEquals(r1.getVolumenDeMaterial("Plastico"), 0);

		assertEquals(r2.getVolumenDeMaterial("Metal"), 0);
		assertEquals(r2.getVolumenDeMaterial("Madera"), 0);
		assertEquals(r2.getVolumenDeMaterial("Plastico"), 0);

		aniadirPiezas(r1);

		assertEquals(r1.getVolumenDeMaterial("Metal"), 86.6981596587892986, 0.001);
		assertEquals(r1.getVolumenDeMaterial("Madera"), 3044.66967762286255, 0.001);
		assertEquals(r1.getVolumenDeMaterial("Plastico"), 135.68135913577134, 0.001);

		aniadirPiezas(r1);

		assertEquals(r1.getVolumenDeMaterial("Metal"), 86.6981596587892986 * 2, 0.001);
		assertEquals(r1.getVolumenDeMaterial("Madera"), 3044.66967762286255 * 2, 0.001);
		assertEquals(r1.getVolumenDeMaterial("Plastico"), 135.68135913577134 * 2, 0.001);

		aniadirPiezas(r2);

		assertEquals(r2.getVolumenDeMaterial("Metal"), 86.6981596587892986, 0.001);
		assertEquals(r2.getVolumenDeMaterial("Madera"), 3044.66967762286255, 0.001);
		assertEquals(r2.getVolumenDeMaterial("Plastico"), 135.68135913577134, 0.001);
	}

	@Test
	public void testSuperficie() {
		assertEquals(r1.getSuperficieDeColor("Rojo"), 0);
		assertEquals(r1.getSuperficieDeColor("Verde"), 0);
		assertEquals(r1.getSuperficieDeColor("Azul"), 0);

		assertEquals(r2.getSuperficieDeColor("Rojo"), 0);
		assertEquals(r2.getSuperficieDeColor("Verde"), 0);
		assertEquals(r2.getSuperficieDeColor("Azul"), 0);

		aniadirPiezas(r1);

		assertEquals(r1.getSuperficieDeColor("Rojo"), 1392.2886632288, 0.001);
		assertEquals(r1.getSuperficieDeColor("Verde"), 120.909882528, 0.001);
		assertEquals(r1.getSuperficieDeColor("Azul"), 146.6696207488, 0.001);

		aniadirPiezas(r1);

		assertEquals(r1.getSuperficieDeColor("Rojo"), 1392.2886632288 * 2, 0.001);
		assertEquals(r1.getSuperficieDeColor("Verde"), 120.909882528 * 2, 0.001);
		assertEquals(r1.getSuperficieDeColor("Azul"), 146.6696207488 * 2, 0.001);

		aniadirPiezas(r2);

		assertEquals(r2.getSuperficieDeColor("Rojo"), 1392.2886632288, 0.001);
		assertEquals(r2.getSuperficieDeColor("Verde"), 120.909882528, 0.001);
		assertEquals(r2.getSuperficieDeColor("Azul"), 146.6696207488, 0.001);
	}
}
