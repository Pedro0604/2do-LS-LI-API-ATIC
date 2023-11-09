package ar.edu.unlp.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema s;

	@BeforeEach
	void setUp() throws Exception {
		s = new Sistema();
	}

	@Test
	public void testGetNumeroDisponible() {
		assertNull(s.getNumeroDisponible());
		s.agregarNumeroDisponible("123456");
		assertEquals(s.getNumeroDisponible(), "123456");
	}

	@Test
	public void testAgregarClienteFisico() {
		s.agregarNumeroDisponible("123456");
		ClienteFisico cf = s.agregarClienteFisico("Jose", "123", 45454545);
		assertEquals(cf.getDescuento(), 0.1);
		assertEquals(cf.getDireccion(), "123");
		assertEquals(cf.getLlamadas().size(), 0);
		assertEquals(cf.getNombre(), "Jose");
		assertEquals(cf.getNumero(), "123456");
		assertEquals(cf.getDni(), 45454545);
	}

	@Test
	public void testAgregarClienteJuridico() {
		s.agregarNumeroDisponible("123456");
		ClienteJuridico cf = s.agregarClienteJuridico("Jose", "123", 45454545, "Empresa");
		assertEquals(cf.getDescuento(), 0);
		assertEquals(cf.getDireccion(), "123");
		assertEquals(cf.getLlamadas().size(), 0);
		assertEquals(cf.getNombre(), "Jose");
		assertEquals(cf.getNumero(), "123456");
		assertEquals(cf.getCuit(), 45454545);
		assertEquals(cf.getTipo(), "Empresa");
	}
}
