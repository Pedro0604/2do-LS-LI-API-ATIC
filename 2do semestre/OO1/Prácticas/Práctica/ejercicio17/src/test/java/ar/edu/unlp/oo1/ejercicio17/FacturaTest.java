package ar.edu.unlp.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
	Factura f;
	Cliente c;

	@BeforeEach
	void setUp() throws Exception {
		c = new ClienteFisico("Pedro", "123 45", "221-123-4567", 45454545);
		f = new Factura(c, LocalDate.now(), LocalDate.now(), 100);
	}

	@Test
	public void testAniadirDestcuento() {
		f.aniadirDescuento();
		assertEquals(f.getMontoTotal(), 90);
		assertEquals(f.getCliente(), c);
		assertEquals(f.getFechaFacturacion(), LocalDate.now());
		assertEquals(f.getInicio(), LocalDate.now());
		assertEquals(f.getFin(), LocalDate.now());
	}
}
