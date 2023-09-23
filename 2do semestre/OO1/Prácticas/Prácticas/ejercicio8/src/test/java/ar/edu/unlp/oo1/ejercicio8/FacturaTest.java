package ar.edu.unlp.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {

	Usuario u1, u2;
	Factura f1, f2;

	@BeforeEach
	void setUp() throws Exception {
		u1 = new Usuario("Pedro", "123");
		u2 = new Usuario("Jose", "456");

		f1 = new Factura(u1, 100, 0.1, LocalDate.of(2022, 10, 8));

		f2 = new Factura(u2, 200, 0, LocalDate.of(2021, 10, 8));
	}

	@Test
	public void testCrearFactura() {
		assertEquals(f1.usuario(), u1);
		assertEquals(f1.montoTotal(), 100);
		assertEquals(f1.descuento(), 0.1);
		assertEquals(f1.fecha(), LocalDate.of(2022, 10, 8));

		assertEquals(f2.usuario(), u2);
		assertEquals(f2.montoTotal(), 200);
		assertEquals(f2.descuento(), 0);
		assertEquals(f2.fecha(), LocalDate.of(2021, 10, 8));

		Usuario nuevoUsuario = new Usuario("Jose", "456");
		f2 = new Factura(nuevoUsuario, 999, 0.123, LocalDate.now());

		assertNotEquals(f2.usuario(), u2);
		assertNotEquals(f2.montoTotal(), 200);
		assertNotEquals(f2.descuento(), 0);
		assertNotEquals(f2.fecha(), LocalDate.of(2021, 10, 8));

		assertEquals(f2.usuario(), nuevoUsuario);
		assertEquals(f2.montoTotal(), 999);
		assertEquals(f2.descuento(), 0.123);
		assertEquals(f2.fecha(), LocalDate.now());

	}
}
