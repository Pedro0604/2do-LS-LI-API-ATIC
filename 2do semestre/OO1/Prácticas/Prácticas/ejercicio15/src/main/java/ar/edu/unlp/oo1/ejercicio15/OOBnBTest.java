package ar.edu.unlp.oo1.ejercicio15;

import java.time.LocalDate;

public class OOBnBTest {
	OOBnB bnb;
	DateLapseable periodo;
	
	@BeforeEach
	void setUp()throws Exception{
		bnb = new OOBnB();
	}
	
	@Test
	public void testInicializar() {
		assertNotNull(bnb.getUsuarios());
		assertTrue(bnb.getUsuarios().size(), 0);
	}
	
	@Test
	public void testRegistrarUsuario() {
		Usuario u = bnb.registrarUsuario("Pepe", 123123, "1 234");
		assertEquals(bnb.getUsuarios().size(), 1);
		Usuario u2 = bnb.registrarUsuario("Pepe", 123123, "1 234");
		assertEquals(bnb.getUsuarios().size(), 2);
	}
	
	@Test
	public void test
}
