package ar.edu.unlp.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {
	CajaDeAhorro c1;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new CajaDeAhorro();
	}

	@Test
	public void testInicializar() {
		assertEquals(c1.getSaldo(), 0);
	}

	@Test
	public void testExtraerSinSaldo() {
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
		assertFalse(c1.extraer(1000));

		c1.depositar(1000 * 0.02);
		assertTrue(c1.extraer(1000));
		assertEquals(c1.getSaldo(), 0);
	}

	@Test
	public void testTransferirACuentaCorriente() {
		Cuenta nuevaCuenta = new CuentaCorriente();

		c1.depositar(1000 * 1.02);
		assertTrue(c1.transferirACuenta(1000, nuevaCuenta));
		assertEquals(c1.getSaldo(), 0);
		assertFalse(c1.transferirACuenta(1, nuevaCuenta));
		assertEquals(nuevaCuenta.getSaldo(), 1000);
	}

	@Test
	public void testTransferirACajaDeAhorro() {
		Cuenta nuevaCuenta = new CajaDeAhorro();

		c1.depositar(1000 * 1.02);
		assertTrue(c1.transferirACuenta(1000, nuevaCuenta));
		assertEquals(c1.getSaldo(), 0);
		assertFalse(c1.transferirACuenta(1, nuevaCuenta));
		assertEquals(nuevaCuenta.getSaldo(), 1000);
	}
}
