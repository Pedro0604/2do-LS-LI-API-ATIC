package ar.edu.unlp.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	Carpeta c1, c2;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Carpeta("papelera");
		c2 = new Carpeta("enviados");
	}

	@Test
	public void testInicializar() {
		assertEquals(c1.getNombre(), "papelera");
		assertNotNull(c1.getEmails());
		assertEquals(c1.getEmails().size(), 0);

		assertEquals(c2.getNombre(), "enviados");
		assertNotNull(c2.getEmails());
		assertEquals(c2.getEmails().size(), 0);
	}

	@Test
	public void testAddEmail() {
		Email e1 = new Email("email1", "cuerpo1");
		c1.addEmail(e1);
		assertEquals(c1.getEmails().size(), 1);
		assertTrue(c1.getEmails().contains(e1));
		c1.addEmail(e1);
		assertEquals(c1.getEmails().size(), 2);
	}

	@Test
	public void testRemoveEmail() {
		Email e1 = new Email("email1", "cuerpo1");
		c1.addEmail(e1);
		c1.removeEmail(e1);
		assertEquals(c1.getEmails().size(), 0);
		assertFalse(c1.getEmails().contains(e1));

		Email e2 = new Email("email2", "cuerpo2");
		c1.addEmail(e1);
		c1.addEmail(e2);
		c1.removeEmail(e1);
		assertEquals(c1.getEmails().size(), 1);
		assertFalse(c1.getEmails().contains(e1));
		assertTrue(c1.getEmails().contains(e2));
		c1.removeEmail(e2);
		assertEquals(c1.getEmails().size(), 0);
	}

	@Test
	public void testBuscarEmail() {
		Email e1 = new Email("email1", "cuerpo1");
		c1.addEmail(e1);
		assertNull(c1.buscarEmail(null));
		assertEquals(c1.buscarEmail("email"), e1);
		assertEquals(c1.buscarEmail("cuerpo"), e1);
		assertEquals(c1.buscarEmail("1"), e1);
		assertNull(c1.buscarEmail("no esta en el email"));

		Email e2 = new Email("email2", "cuerpo2");
		assertNull(c1.buscarEmail("2"));
		c1.addEmail(e2);
		assertEquals(c1.buscarEmail("2"), e2);
	}

	@Test
	public void testTamanioCarpeta() {
		assertEquals(c1.tamanioCarpeta(), 0);

		Email e1 = new Email("email1", "cuerpo1");
		Archivo a1 = new Archivo("archivo1", 10);
		e1.addAdjunto(a1);

		c1.addEmail(e1);
		assertEquals(c1.tamanioCarpeta(), 10);

		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		assertEquals(c1.tamanioCarpeta(), 50);

		Email e2 = new Email("email2", "cuerpo2");
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		assertEquals(c1.tamanioCarpeta(), 50);

		c1.addEmail(e2);
		assertEquals(c1.tamanioCarpeta(), 100);

		assertEquals(c2.tamanioCarpeta(), 0);
	}

	@Test
	public void testMoverEmailA() {
		Email e1 = new Email("email1", "cuerpo1");

		c1.moverEmailA(e1, c2);
		assertFalse(c2.getEmails().contains(e1));

		c1.addEmail(e1);
		c1.moverEmailA(e1, c2);
		assertFalse(c1.getEmails().contains(e1));
		assertTrue(c2.getEmails().contains(e1));
	}
}
