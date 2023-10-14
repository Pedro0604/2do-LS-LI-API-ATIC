package ar.edu.unlp.oo1.ejercicio15;

public class PropiedadTest {
	Propiedad p;
	Usuario duenio;
	
	@BeforeEach
	void setUp()throws Exception{
		duenio = new Usuario("Pepe", 123412, "1 234");
		p = new Propiedad("Hotel", "hotelazo", 123400, "2 456", duenio);
	}
	
	@Test
	public void testInicializacion() {
		assertEquals(p.getNombre(), "Hotel");
		assertEquals(p.getDescripcion(), "Hotelazo");
		assertEquals(p.getPrecioNoche(), 123400);
		assertEquals(p.getDireccion(), "2 456");
		assertEquals(p.getDuenio(), duenio);
	}
	
	@Test
	public void testTieneComoDuenio() {
		assertFalse(p.tieneComoDuenio(null));
		assertFalse(p.tieneComoDuenio(new Usuario("Pepe", 123412, "1 234")));
		assertTrue(p.tieneComoDuenio(duenio));
	}
}
