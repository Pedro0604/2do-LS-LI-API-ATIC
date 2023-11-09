package ar.edu.unlp.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	Cliente cf, cj;

	@BeforeEach
	void setUp() throws Exception {
		cf = new ClienteFisico("Pedro", "123 45", "221-123-4567", 45454545);
		cj = new ClienteJuridico("Pedro", "123 45", "221-123-4567", 20454545457l, "Empresa");
	}

	@Test
	public void testRegistrarLlamadaLocal() {
		Llamada l = cf.registrarLlamadaLocal(LocalDateTime.of(2023, 1, 1, 1, 1, 1), 10, "123", "456");
		assertEquals(cf.getLlamadas().size(), 1);
		assertEquals(l.getInicio(), LocalDateTime.of(2023, 1, 1, 1, 1, 1));
		assertEquals(l.getDuracion(), 10);
		assertEquals(l.getNumeroLlamador(), "123");
		assertEquals(l.getNumeroRecibidor(), "456");

		l = cj.registrarLlamadaLocal(LocalDateTime.of(2023, 1, 1, 1, 1, 1), 100, "123456", "789");
		assertEquals(cj.getLlamadas().size(), 1);
		assertEquals(l.getInicio(), LocalDateTime.of(2023, 1, 1, 1, 1, 1));
		assertEquals(l.getDuracion(), 100);
		assertEquals(l.getNumeroLlamador(), "123456");
		assertEquals(l.getNumeroRecibidor(), "789");
	}

	@Test
	public void testRegistrarLlamadaInterurbana() {
		LlamadaInterurbana l = cf.registrarLlamadaInterurbana(LocalDateTime.of(2023, 1, 1, 1, 1, 1), 10, "123", "456",
				50);
		assertEquals(cf.getLlamadas().size(), 1);
		assertEquals(l.getInicio(), LocalDateTime.of(2023, 1, 1, 1, 1, 1));
		assertEquals(l.getDuracion(), 10);
		assertEquals(l.getNumeroLlamador(), "123");
		assertEquals(l.getNumeroRecibidor(), "456");
		assertEquals(l.getDistancia(), 50);

		l = cj.registrarLlamadaInterurbana(LocalDateTime.of(2023, 1, 1, 1, 1, 1), 100, "123456", "789", 100);
		assertEquals(cj.getLlamadas().size(), 1);
		assertEquals(l.getInicio(), LocalDateTime.of(2023, 1, 1, 1, 1, 1));
		assertEquals(l.getDuracion(), 100);
		assertEquals(l.getNumeroLlamador(), "123456");
		assertEquals(l.getNumeroRecibidor(), "789");
		assertEquals(l.getDuracion(), 100);
	}

	@Test
	public void testRegistrarLlamadaInternacional() {
		LlamadaInternacional l = cf.registrarLlamadaInternacional(LocalDateTime.of(2023, 1, 1, 1, 1, 1), 10, "123",
				"456", "Argentina", "Chile");
		assertEquals(cf.getLlamadas().size(), 1);
		assertEquals(l.getInicio(), LocalDateTime.of(2023, 1, 1, 1, 1, 1));
		assertEquals(l.getDuracion(), 10);
		assertEquals(l.getNumeroLlamador(), "123");
		assertEquals(l.getNumeroRecibidor(), "456");
		assertEquals(l.getPaisOrigen(), "Argentina");
		assertEquals(l.getPaisDestino(), "Chile");

		l = cj.registrarLlamadaInternacional(LocalDateTime.of(2023, 1, 1, 1, 1, 1), 100, "123456", "789", "Argentina",
				"Ecuador");
		assertEquals(cj.getLlamadas().size(), 1);
		assertEquals(l.getInicio(), LocalDateTime.of(2023, 1, 1, 1, 1, 1));
		assertEquals(l.getDuracion(), 100);
		assertEquals(l.getNumeroLlamador(), "123456");
		assertEquals(l.getNumeroRecibidor(), "789");
		assertEquals(l.getPaisOrigen(), "Argentina");
		assertEquals(l.getPaisDestino(), "Ecuador");
	}

	@Test
	public void testFacturarLlamadas() {
		assertEquals(cf.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 0);

		cf.registrarLlamadaLocal(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543");

		assertEquals(cf.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 9);

		cf.registrarLlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543", 10);

		assertEquals(cf.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 31.5);

		cf.registrarLlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543",
				100);

		assertEquals(cf.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 58.5);

		cf.registrarLlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543",
				500);

		assertEquals(cf.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 90);

		cf.registrarLlamadaInternacional(LocalDateTime.of(2023, 11, 8, 8, 0, 0), 10, "221-123-4567", "221-987-6543",
				"Argentina", "Brasil");

		assertEquals(cf.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 126);

		cf.registrarLlamadaInternacional(LocalDateTime.of(2023, 11, 8, 20, 0, 0), 10, "221-123-4567", "221-987-6543",
				"Argentina", "Australia");

		assertEquals(cf.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 153);

		assertEquals(cj.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 0);

		cj.registrarLlamadaLocal(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543");

		assertEquals(cj.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 10);

		cj.registrarLlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543", 10);

		assertEquals(cj.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 35);

		cj.registrarLlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543",
				100);

		assertEquals(cj.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 65);

		cj.registrarLlamadaInterurbana(LocalDateTime.of(2023, 11, 8, 12, 0, 0), 10, "221-123-4567", "221-987-6543",
				500);

		assertEquals(cj.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 100);

		cj.registrarLlamadaInternacional(LocalDateTime.of(2023, 11, 8, 8, 0, 0), 10, "221-123-4567", "221-987-6543",
				"Argentina", "Brasil");

		assertEquals(cj.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 140);

		cj.registrarLlamadaInternacional(LocalDateTime.of(2023, 11, 8, 20, 0, 0), 10, "221-123-4567", "221-987-6543",
				"Argentina", "Australia");

		assertEquals(cj.facturarLlamadas(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 20)).getMontoTotal(), 170);
	}
}
