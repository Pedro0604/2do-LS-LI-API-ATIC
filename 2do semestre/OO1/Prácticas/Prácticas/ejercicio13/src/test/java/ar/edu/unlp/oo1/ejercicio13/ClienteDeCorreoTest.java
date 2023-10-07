package ar.edu.unlp.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {
	ClienteDeCorreo c1, c2;
	Carpeta inbox1, inbox2;

	@BeforeEach
	void setUp() throws Exception {
		inbox1 = new Carpeta("recibidos1");
		inbox2 = new Carpeta("recibidos2");
		c1 = new ClienteDeCorreo(inbox1);
		c2 = new ClienteDeCorreo(inbox2);
	}

	@Test
	public void testInicializar() {
		assertEquals(c1.getInbox(), inbox1);
		assertNotNull(c1.getCarpetas());
		assertEquals(c1.getCarpetas().size(), 1);

		assertEquals(c2.getInbox(), inbox2);
		assertNotNull(c2.getCarpetas());
		assertEquals(c2.getCarpetas().size(), 1);
	}

	@Test
	public void testAddCarpeta() {
		Carpeta car1 = new Carpeta("papelera");
		c1.addCarpeta(car1);
		assertEquals(c1.getCarpetas().size(), 2);
		assertTrue(c1.getCarpetas().contains(car1));
		c1.addCarpeta(car1);
		assertEquals(c1.getCarpetas().size(), 3);
	}

	@Test
	public void testRecibir() {
		Email e1 = new Email("email1", "cuerpo1");
		c1.recibir(e1);
		assertTrue(c1.getInbox().getEmails().contains(e1));
	}

	@Test
	public void testMover() {
		Email e1 = new Email("email1", "cuerpo1");
		Carpeta car1 = new Carpeta("papelera");
		Carpeta car2 = new Carpeta("enviados");

		car1.addEmail(e1);

		c1.mover(e1, car1, car2);

		assertTrue(car2.getEmails().contains(e1));
	}

	@Test
	public void testBuscar() {
		Email e1 = new Email("email1", "cuerpo1");
		Carpeta car1 = new Carpeta("papelera");
		car1.addEmail(e1);
		c1.addCarpeta(car1);
		assertNull(c1.buscar(null));
		assertEquals(c1.buscar("email"), e1);
		assertEquals(c1.buscar("cuerpo"), e1);
		assertEquals(c1.buscar("1"), e1);
		assertNull(c1.buscar("no esta en el email"));

		Email e2 = new Email("email2", "cuerpo2");
		Carpeta car2 = new Carpeta("enviados");
		car2.addEmail(e2);
		assertNull(c1.buscar("2"));
		c1.addCarpeta(car2);
		assertEquals(c1.buscar("2"), e2);
	}

	@Test
	public void testEspacioOcupado() {
		assertEquals(c1.espacioOcupado(), 0);

		Carpeta car1 = new Carpeta("papelera");
		Email e1 = new Email("email1", "cuerpo1");
		Archivo a1 = new Archivo("archivo1", 10);
		e1.addAdjunto(a1);
		car1.addEmail(e1);

		assertEquals(c1.espacioOcupado(), 0);
		c1.addCarpeta(car1);
		assertEquals(c1.espacioOcupado(), 10);

		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		e1.addAdjunto(a1);
		assertEquals(c1.espacioOcupado(), 50);

		Email e2 = new Email("email2", "cuerpo2");
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		e2.addAdjunto(a1);
		Carpeta car2 = new Carpeta("enviados");
		car2.addEmail(e2);
		assertEquals(c1.espacioOcupado(), 50);

		c1.addCarpeta(car2);
		assertEquals(c1.espacioOcupado(), 100);

		inbox1.addEmail(e1);
		assertEquals(c1.espacioOcupado(), 150);

		assertEquals(c2.espacioOcupado(), 0);
	}
}
