package ar.edu.unlp.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistribuidoraTest {
	Distribuidora d1, d2;
	Usuario u1, u2;
	Consumo c1, c2;

	@BeforeEach
	void setUp() throws Exception {
		d1 = new Distribuidora(20);
		d2 = new Distribuidora(0);

		u1 = new Usuario("Jose", "10");
		u2 = new Usuario("Domingo", "20");
		d1.agregarUsuario(u1);
		d1.agregarUsuario(u2);

		c1 = new Consumo(10, 10, LocalDate.of(2022, 10, 8));
		c2 = new Consumo(20, 20, LocalDate.of(2021, 10, 8));

		u1.agregarMedicion(c1);
		u2.agregarMedicion(c2);
	}

	@Test
	public void testIniciarSistema() {
		assertEquals(d1.getPrecioKWh(), 20);

		d1.precioKWh(30);
		assertNotEquals(d1.getPrecioKWh(), 20);
		assertEquals(d1.getPrecioKWh(), 30);

		assertEquals(d2.getPrecioKWh(), 0);
		d2.precioKWh(10);
		assertNotEquals(d2.getPrecioKWh(), 0);
		assertEquals(d2.getPrecioKWh(), 10);
	}

	@Test
	public void testRegistrarUsuario() {
		assertTrue(d1.getUsuarios().contains(u1));
		assertTrue(d1.getUsuarios().contains(u2));

		Usuario nuevo = new Usuario("c", "f");
		assertFalse(d1.getUsuarios().contains(nuevo));
		assertEquals(d1.getUsuarios().size(), 2);
		d1.agregarUsuario(nuevo);
		assertTrue(d1.getUsuarios().contains(nuevo));
		assertEquals(d1.getUsuarios().size(), 3);

		assertFalse(d2.getUsuarios().contains(nuevo));
		assertEquals(d2.getUsuarios().size(), 0);
		d2.agregarUsuario(nuevo);
		assertTrue(d2.getUsuarios().contains(nuevo));
		assertEquals(d2.getUsuarios().size(), 1);
	}

	@Test
	public void testConsumoTotalActiva() {
		assertEquals(d1.consumoTotalActiva(), 30);
		assertEquals(d2.consumoTotalActiva(), 0);

		u1.agregarMedicion(new Consumo(100, 100, LocalDate.of(2023, 10, 10)));
		assertEquals(d1.consumoTotalActiva(), 120);

		u2.agregarMedicion(new Consumo(50, 50, LocalDate.of(2020, 10, 10)));
		assertEquals(d1.consumoTotalActiva(), 120);

		u1.agregarMedicion(new Consumo(1000, 1000, LocalDate.of(2019, 10, 10)));
		assertEquals(d1.consumoTotalActiva(), 120);
	}

	@Test
	public void testFacturar() {
		List<Factura> f1 = d1.facturar();
		List<Factura> f2 = d2.facturar();

		assertEquals(f1.size(), 2);
		assertEquals(f2.size(), 0);

		Usuario uNuevo = new Usuario("d", "123");
		d1.agregarUsuario(uNuevo);
		d1.agregarUsuario(uNuevo);
		f1 = d1.facturar();
		assertEquals(f1.size(), 4);

	}
}
