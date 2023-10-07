package ar.edu.unlp.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	Email e1, e2;

	@BeforeEach
	void setUp() throws Exception {
		e1 = new Email("tp1", "El trabajo 1");
		e2 = new Email("tp2", "El trabajo 2");
	}

	@Test
	public void testInicializar() {
		assertEquals(e1.getTitulo(), "tp1");
		assertEquals(e1.getCuerpo(), "El trabajo 1");
		assertNotNull(e1.getAdjuntos());
		assertEquals(e1.getAdjuntos().size(), 0);

		assertEquals(e2.getTitulo(), "tp2");
		assertEquals(e2.getCuerpo(), "El trabajo 2");
		assertNotNull(e2.getAdjuntos());
		assertEquals(e2.getAdjuntos().size(), 0);
	}

	@Test
	public void testAddAdjunto() {
		Archivo a1 = new Archivo("archivo1", 10);
		e1.addAdjunto(a1);
		assertEquals(e1.getAdjuntos().size(), 1);
		assertTrue(e1.getAdjuntos().contains(a1));
		e1.addAdjunto(a1);
		assertEquals(e1.getAdjuntos().size(), 2);
	}

	@Test
	public void testTieneTexto() {
		assertFalse(e1.tieneTexto(null));
		assertTrue(e1.tieneTexto("tp"));
		assertTrue(e1.tieneTexto("1"));
		assertTrue(e1.tieneTexto("trabajo"));
		assertFalse(e1.tieneTexto("2"));

		assertFalse(e2.tieneTexto(null));
		assertTrue(e2.tieneTexto("tp"));
		assertTrue(e2.tieneTexto("2"));
		assertTrue(e2.tieneTexto("trabajo"));
		assertFalse(e2.tieneTexto("1"));
	}

	@Test
	public void testTamanioEmail() {
		assertEquals(e1.tamanioEmail(), 0);
		Archivo a1 = new Archivo("archivo1", 10);
		e1.addAdjunto(a1);
		assertEquals(e1.tamanioEmail(), 10);
		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		assertEquals(e1.tamanioEmail(), 50);

		assertEquals(e2.tamanioEmail(), 0);
	}
}
