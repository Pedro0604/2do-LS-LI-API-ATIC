package ar.edu.unlp.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OOBnBTest {
	OOBnB bnb;
	DateLapseable periodo, periodo2, periodoFuera, periodoAmbos;
	Propiedad p, p2;

	@BeforeEach
	void setUp() throws Exception {
		bnb = new OOBnB();
		periodo = new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 31));
		periodo2 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 31));
		periodoFuera = new DateLapse(LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 31));
		periodoAmbos = new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 31));
	}

	@Test
	public void testInicializar() {
		assertNotNull(bnb.getUsuarios());
		assertEquals(bnb.getUsuarios().size(), 0);
	}

	@Test
	public void testRegistrarUsuario() {
		Usuario u = bnb.registrarUsuario("Pepe", 123123, "1 234");
		assertEquals(bnb.getUsuarios().size(), 1);
		Usuario u2 = bnb.registrarUsuario("Pepe", 123123, "1 234");
		assertEquals(bnb.getUsuarios().size(), 2);
	}

	@Test
	public void testBuscarPropiedades() {
		Usuario duenio = bnb.registrarUsuario("Pepe", 123123, "1 234");
		Usuario inquilino = bnb.registrarUsuario("Jose", 456456, "4 567");
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		Propiedad p2 = duenio.registrarPropiedad("Hotel2", "hotelazo2", 2000, "3 456");
		inquilino.reservar(p, periodo);
		inquilino.reservar(p2, periodo2);

		assertEquals(bnb.buscarPropiedades(periodo).size(), 1);
		assertEquals(bnb.buscarPropiedades(periodo2).size(), 1);
		assertEquals(bnb.buscarPropiedades(periodoFuera).size(), 2);
		assertEquals(bnb.buscarPropiedades(periodoAmbos).size(), 0);

		assertTrue(bnb.buscarPropiedades(periodo).contains(p2));
		assertTrue(bnb.buscarPropiedades(periodo2).contains(p));
		assertTrue(bnb.buscarPropiedades(periodoFuera).contains(p2) && bnb.buscarPropiedades(periodoFuera).contains(p));
	}

	@Test
	public void testReservar() {
		Usuario duenio = bnb.registrarUsuario("Pepe", 123123, "1 234");
		Usuario inquilino = bnb.registrarUsuario("Jose", 456456, "4 567");
		Usuario inquilinoLadronDeReservas = bnb.registrarUsuario("Ladri", 9999999, "9 999");
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		Propiedad p2 = duenio.registrarPropiedad("Hotel2", "hotelazo2", 2000, "3 456");
		inquilino.reservar(p, periodo);
		inquilino.reservar(p2, periodo2);

		bnb.reservar(p, inquilinoLadronDeReservas, periodo);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 0);
		bnb.reservar(p2, inquilinoLadronDeReservas, periodo2);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 0);
		bnb.reservar(p, inquilinoLadronDeReservas, periodoAmbos);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 0);
		bnb.reservar(p2, inquilinoLadronDeReservas, periodoAmbos);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 0);

		Reserva r = bnb.reservar(p, inquilinoLadronDeReservas, periodoFuera);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 1);
		inquilinoLadronDeReservas.eliminarReserva(r);

		r = bnb.reservar(p2, inquilinoLadronDeReservas, periodoFuera);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 1);
		inquilinoLadronDeReservas.eliminarReserva(r);

		bnb.reservar(p, inquilinoLadronDeReservas, periodo2);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 1);
		bnb.reservar(p2, inquilinoLadronDeReservas, periodo);
		assertEquals(inquilinoLadronDeReservas.getReservas().size(), 2);
	}

	@Test
	public void testCalcularIngresos() {
		Usuario duenio = bnb.registrarUsuario("Pepe", 123123, "1 234");
		Usuario inquilino = bnb.registrarUsuario("Jose", 456456, "4 567");
		Usuario inquilinoLadronDeReservas = bnb.registrarUsuario("Ladri", 9999999, "9 999");
		Propiedad p = duenio.registrarPropiedad("Hotel", "hotelazo", 1000, "2 456");
		Propiedad p2 = duenio.registrarPropiedad("Hotel2", "hotelazo2", 2000, "3 456");

		Reserva r = inquilino.reservar(p, periodo);
		assertEquals(inquilino.calcularIngresos(duenio, periodo), 30000);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 2))),
				1000);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 2, 1), LocalDate.of(2025, 1, 2))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 20))),
				10000);

		Reserva r2 = inquilino.reservar(p2, periodo);
		assertEquals(inquilino.calcularIngresos(duenio, periodo), 90000);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 2))),
				3000);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 2, 1), LocalDate.of(2025, 1, 2))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 20))),
				30000);

		inquilino.eliminarReserva(r);
		assertEquals(inquilino.calcularIngresos(duenio, periodo), 60000);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 2))),
				2000);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 2, 1), LocalDate.of(2025, 1, 2))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31))),
				0);
		assertEquals(
				inquilino.calcularIngresos(duenio, new DateLapse(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 20))),
				20000);
	}
}
