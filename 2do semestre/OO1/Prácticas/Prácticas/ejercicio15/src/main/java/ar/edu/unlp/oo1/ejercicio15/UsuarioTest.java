package ar.edu.unlp.oo1.ejercicio15;

import java.time.LocalDate;

public class UsuarioTest {
	DateLapseable periodo;
	Usuario duenio, inquilino;
	
	@BeforeEach
	void setUp()throws Exception{
		duenio = new Usuario("Pepe", 123412, "1 234");
		periodo = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31));
		inquilino = new Usuario("Jose", 112233, "2 345");
	}
	
	@Test
	public void testInicializar() {
		assertEquals(duenio.getNombre(),"Pepe");
		assertEquals(duenio.getDni(), 123412);
		assertEquals(duenio.getDireccion(),"1 234");
		assertNotNull(duenio.getPropiedades());
		assertNotNull(duenio.getReservas());
		assertEquals(duenio.getPropiedades().size(), 0);
		assertEquals(duenio.getReservas().size(), 0);
	}
	
	@Test
	public void testRegistrarPropiedad() {
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		assertEquals(duenio.getPropiedades().size(), 1);
		Propiedad p2 = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		assertEquals(duenio.getPropiedades().size(), 2);
		assertTrue(p.tieneComoDuenio(duenio));
		assertTrue(p2.tieneComoDuenio(duenio));
		assertTrue(duenio.getPropiedades().contains(p));
		assertTrue(duenio.getPropiedades().contains(p2));
	}
	
	@Test
	public void testReservar(){
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		inquilino.reservar(p, periodo);
		assertEquals(inquilino.getReservas().size(), 1);
		inquilino.reservar(p, periodo);
		assertEquals(inquilino.getReservas().size(), 2);
	}
	
	@Test
	public void testEliminarReserva() {
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		Reserva r = inquilino.reservar(p, periodo);
		Reserva r2 = inquilino.reservar(p, periodo);
		inquilino.eliminarReserva(null);
		assertEquals(inquilino.getReservas().size(), 2);
		inquilino.eliminarReserva(new Reserva(periodo, p));
		assertEquals(inquilino.getReservas().size(), 2);
		inquilino.eliminarReserva(r);
		assertEquals(inquilino.getReservas().size(), 1);
		inquilino.eliminarReserva(r2);
		assertEquals(inquilino.getReservas().size(), 0);
		inquilino.eliminarReserva(r);
		assertEquals(inquilino.getReservas().size(), 0);
	}
	
	@Test
	public void testTieneReservada() {
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		Propiedad p2 = duenio.registrarPropiedad("Hotel2", "hotelazo2", 2000, "3 456");
		
		inquilino.reservar(p, periodo);
		inquilino.reservar(p, periodo);
		
		assertTrue(inquilino.tieneReservada(p, periodo));
		assertTrue(inquilino.tieneReservada(p, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2))));
		assertTrue(inquilino.tieneReservada(p, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1))));
		assertTrue(inquilino.tieneReservada(p, new DateLapse(LocalDate.of(2023, 2, 1), LocalDate.of(2024, 1, 1))));
		assertTrue(inquilino.tieneReservada(p, new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31))));
		assertFalse(inquilino.tieneReservada(p2, periodo));
	}
	
	@Test
	public void testCalcularIngresos() {
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		Propiedad p2 = duenio.registrarPropiedad("Hotel2", "hotelazo2", 2000, "3 456");
		assertEquals(inquilino.calcularIngresos(duenio, periodo), 0);
		
		Reserva r = inquilino.reservar(p, periodo);
		assertEquals(inquilino.calcularIngresos(duenio, periodo), 30000);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2))), 1000);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 2, 1), LocalDate.of(2024, 1, 2))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20))), 10000);
		
		Reserva r2 = inquilino.reservar(p2, periodo);
		assertEquals(inquilino.calcularIngresos(duenio, periodo), 90000);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2))), 3000);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 2, 1), LocalDate.of(2024, 1, 2))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20))), 30000);
		
		inquilino.eliminarReserva(r);
		assertEquals(inquilino.calcularIngresos(duenio, periodo), 60000);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2))), 2000);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 2, 1), LocalDate.of(2024, 1, 2))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31))), 0);
		assertEquals(inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20))), 20000);
	}
}
