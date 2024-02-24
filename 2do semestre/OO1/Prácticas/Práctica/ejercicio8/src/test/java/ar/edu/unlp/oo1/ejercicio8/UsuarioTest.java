package ar.edu.unlp.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	Usuario u1, u2;
	Consumo c1, c2;

	@BeforeEach
	void setUp() throws Exception {
		u1 = new Usuario("Pedro", "123");
		u2 = new Usuario("Jose", "456");

		c1 = new Consumo(10, 10, LocalDate.of(2022, 10, 8));
		c2 = new Consumo(20, 20, LocalDate.of(2021, 10, 8));

		u1.agregarMedicion(c1);
		u2.agregarMedicion(c2);
	}

	@Test
	public void testCrearUsuario() {
		assertTrue(u1.getNombre().equals("Pedro"));
		assertTrue(u1.getDomicilio().equals("123"));

		assertTrue(u2.getNombre().equals("Jose"));
		assertTrue(u2.getDomicilio().equals("456"));
	}

	@Test
	public void testAgregarMedicion() {
		assertTrue(u1.getConsumos().size() == 1);
		assertTrue(u2.getConsumos().size() == 1);

		u1.agregarMedicion(new Consumo(100, 100, LocalDate.of(2023, 10, 10)));
		u1.agregarMedicion(new Consumo(100, 100, LocalDate.of(2023, 10, 10)));

		assertTrue(u1.getConsumos().size() == 3);
		assertTrue(u2.getConsumos().size() == 1);

		u2.agregarMedicion(new Consumo(100, 100, LocalDate.of(2023, 10, 10)));

		assertTrue(u1.getConsumos().size() == 3);
		assertTrue(u2.getConsumos().size() == 2);
	}

	@Test
	public void testUltimoConsumoActiva() {
		assertTrue(u1.ultimoConsumoActiva() == 10);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u1.agregarMedicion(new Consumo(100, 100, LocalDate.of(2023, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u2.agregarMedicion(new Consumo(50, 50, LocalDate.of(2020, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u1.agregarMedicion(new Consumo(1000, 1000, LocalDate.of(2019, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u2.agregarMedicion(new Consumo(1000, 1000, LocalDate.of(2022, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 1000);
	}

	@Test
	public void testFacturarEnBaseA() {
		Factura f1 = u1.facturarEnBaseA(10);
		Factura f2 = u2.facturarEnBaseA(10);

		assertEquals(u1.facturas().size(), 1);
		assertEquals(u2.facturas().size(), 1);

		u1.facturarEnBaseA(10);

		assertEquals(u1.facturas().size(), 2);
		assertEquals(u2.facturas().size(), 1);

		assertEquals(f1.usuario(), u1);
		assertEquals(f2.usuario(), u2);

		assertEquals(f1.montoTotal(), 100);
		assertEquals(f2.montoTotal(), 200);

		Double fdp1 = 10 / (Math.sqrt(100 + 100));
		Double fdp2 = 20 / (Math.sqrt(400 + 400));

		assertEquals(f1.descuento(), fdp1 > 0.8 ? 0.1 : 0);
		assertEquals(f2.descuento(), fdp2 > 0.8 ? 0.1 : 0);
	}

	@Test
	public void testUltimoCosumoActiva() {
		assertTrue(u1.ultimoConsumoActiva() == 10);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u1.agregarMedicion(new Consumo(100, 100, LocalDate.of(2023, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u2.agregarMedicion(new Consumo(50, 50, LocalDate.of(2020, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u1.agregarMedicion(new Consumo(1000, 1000, LocalDate.of(2019, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 20);

		u2.agregarMedicion(new Consumo(1000, 1000, LocalDate.of(2022, 10, 10)));

		assertTrue(u1.ultimoConsumoActiva() == 100);
		assertTrue(u2.ultimoConsumoActiva() == 1000);
	}
}
