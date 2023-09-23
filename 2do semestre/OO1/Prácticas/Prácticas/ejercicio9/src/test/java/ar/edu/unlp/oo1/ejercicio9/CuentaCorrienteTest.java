package ar.edu.unlp.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	CuentaCorriente c1;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new CuentaCorriente();
	}

	@Test
	public void testInicializar() {
		assertEquals(c1.getSaldo(), 0);

		assertEquals(c1.getDescubierto(), 0);
	}

	@Test
	public void testDescubierto() {
		c1.setDescubierto(1000);
		assertEquals(c1.getDescubierto(), 1000);

		c1.setDescubierto(2000);
		assertEquals(c1.getDescubierto(), 2000);
	}

	@Test
	public void testExtraerSinSaldo() {
		assertFalse(c1.extraer(1));

		c1.setDescubierto(1000);

		assertTrue(c1.extraer(1000));

		assertFalse(c1.extraer(1));
	}

	@Test
	public void testDepositar() {
		c1.depositar(1000);
		assertEquals(c1.getSaldo(), 1000);

		c1.depositar(2000);
		assertEquals(c1.getSaldo(), 3000);
	}

	@Test
	public void testExtraerConSaldo() {
		c1.depositar(1000);
		assertTrue(c1.extraer(1000));
		assertEquals(c1.getSaldo(), 0);
		assertFalse(c1.extraer(1));

		c1.depositar(2000);
		c1.setDescubierto(1000);
		assertTrue(c1.extraer(3000));
		assertFalse(c1.extraer(1));
	}

	@Test
	public void testTransferirACuentaCorriente() {
		Cuenta nuevaCuenta = new CuentaCorriente();

		c1.depositar(1000);
		assertTrue(c1.transferirACuenta(1000, nuevaCuenta));
		assertEquals(c1.getSaldo(), 0);
		assertFalse(c1.transferirACuenta(1, nuevaCuenta));
		assertEquals(nuevaCuenta.getSaldo(), 1000);

		c1.depositar(2000);
		c1.setDescubierto(1000);
		assertTrue(c1.transferirACuenta(3000, nuevaCuenta));
		assertFalse(c1.transferirACuenta(1, nuevaCuenta));
		assertEquals(nuevaCuenta.getSaldo(), 4000);
	}

	@Test
	public void testTransferirACajaDeAhorro() {
		Cuenta nuevaCuenta = new CajaDeAhorro();

		c1.depositar(1000);
		assertTrue(c1.transferirACuenta(1000, nuevaCuenta));
		assertEquals(c1.getSaldo(), 0);
		assertFalse(c1.transferirACuenta(1, nuevaCuenta));
		assertEquals(nuevaCuenta.getSaldo(), 1000);

		c1.depositar(2000);
		c1.setDescubierto(1000);
		assertTrue(c1.transferirACuenta(3000, nuevaCuenta));
		assertFalse(c1.transferirACuenta(1, nuevaCuenta));
		assertEquals(nuevaCuenta.getSaldo(), 4000);
	}
}
