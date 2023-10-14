package ar.edu.unlp.oo1.ejercicio15;

import java.time.LocalDate;

public class ReservaTest {
	Reserva r;
	DateLapseable periodo;
	Propiedad p;
	Usuario duenio;
	
	@BeforeEach
	void setUp()throws Exception{
		periodo = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31));
		duenio = new Usuario("Pepe", 123412, "1 234");
		p = new Propiedad("Hotel", "hotelazo", 1000, "2 456", duenio);
		r = new Reserva(periodo, p);
	}
	
	@Test
	public void testInicializar() {
		assertEquals(r.getPeriodo(), periodo);
		assertEquals(r.getPropiedad(), p);
	}
	
	@Test
	public void testIsEliminable() {
		assertFalse(r.isEliminable());
		r.setPeriodo(new DateLapse(LocalDate.of(2100, 1, 1), LocalDate.of(2101, 1, 1)));
		assertTrue(r.isEliminable());
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(r.calcularPrecio(), 30000);
		p.setPrecioNoche(2000);
		assertEquals(r.calcularPrecio(), 60000);
		r.setPeriodo(new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1)));
		assertEquals(r.calcularPrecio(), 0);
	}
	
	@Test
	public void testEstaReservadaEn() {
		assertTrue(r.estaReservadaEn(p, periodo));
		assertTrue(r.estaReservadaEn(p, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1))));
		assertTrue(r.estaReservadaEn(p, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2))));
		assertFalse(r.estaReservadaEn(p, new DateLapse(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 2))));
		assertFalse(r.estaReservadaEn(p, new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31))));
		assertFalse(r.estaReservadaEn(p, null));
		assertFalse(r.estaReservadaEn(null, null));
		assertFalse(r.estaReservadaEn(new Propiedad("Hotel", "hotelazo", 1000, "2 456", duenio), periodo));
	}
	
	@Test
	public void testCalcularIngresos() {
		assertEquals(r.calcularIngresos(duenio, periodo), r.calcularPrecio());
		assertEquals(r.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 30))), 29000);
		assertEquals(r.calcularIngresos(duenio, new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 30))), 0);
		assertEquals(r.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2))), 1000);
		assertEquals(r.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1))), 0);
		assertEquals(r.calcularIngresos(duenio, new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2024, 1, 1))), r.calcularPrecio());
		
	}
}
