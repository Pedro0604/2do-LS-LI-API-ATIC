package ar.edu.unlp.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTest {
	private Empresa e;

	@BeforeEach
	void setUp() throws Exception {
		e = new Empresa();
	}

	@Test
	public void testBuscarEmpleado() {
		Empleado empleado = e.altaEmpleado(null, null, "1234", null, false, false);
		assertNull(e.buscarEmpleado("1231231"));
		assertEquals(e.buscarEmpleado("1234"), empleado);
	}
}
