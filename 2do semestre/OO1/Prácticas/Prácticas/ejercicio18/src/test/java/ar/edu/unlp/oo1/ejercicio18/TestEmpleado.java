package ar.edu.unlp.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEmpleado {
	Empleado eNada, eConyuge, eHijos, eTodo;

	@BeforeEach
	void setUp() throws Exception {
		eNada = new Empleado(null, null, null, null, false, false);
		eConyuge = new Empleado(null, null, null, null, true, false);
		eHijos = new Empleado(null, null, null, null, false, true);
		eTodo = new Empleado(null, null, null, null, true, true);
	}

	@Test
	public void testCrearContrato() {
		assertEquals(eNada.getContratos().size(), 0);
		eNada.cargarContratoDePlanta(null, 0, 0, 0);
		assertEquals(eNada.getContratos().size(), 1);
		eNada.cargarContratoDePlanta(null, 0, 0, 0);
		assertEquals(eNada.getContratos().size(), 1);
		eNada.cargarContratoPorHoras(null, null, 0, 0);
		assertEquals(eNada.getContratos().size(), 1);
	}

	@Test
	public void testGetContratoActivo() {
		assertNull(eNada.getContratoActivo());

		Contrato c = eNada.cargarContratoPorHoras(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 10, 1), 0, 0);
		assertNull(eNada.getContratoActivo());

		c = eNada.cargarContratoPorHoras(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 1), 0, 0);
		assertEquals(eNada.getContratoActivo(), c);

		c = eTodo.cargarContratoDePlanta(LocalDate.of(2023, 1, 1), 0, 0, 0);
		assertEquals(eTodo.getContratoActivo(), c);
	}

	@Test
	public void testGetContratoActual() {
		assertNull(eNada.getContratoActual());

		Contrato c = eNada.cargarContratoPorHoras(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 10, 1), 0, 0);
		assertEquals(eNada.getContratoActual(), c);

		c = eNada.cargarContratoPorHoras(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 12, 1), 0, 0);
		assertEquals(eNada.getContratoActual(), c);

		c = eTodo.cargarContratoDePlanta(LocalDate.of(2023, 3, 1), 0, 0, 0);
		assertEquals(eTodo.getContratoActual(), c);
	}

	@Test
	public void testGetAntiguedad() {
		assertEquals(eNada.getAntiguedad(), 0);
		eNada.cargarContratoPorHoras(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 10, 1), 0, 0);
		assertEquals(eNada.getAntiguedad(), 0);

		eNada.cargarContratoPorHoras(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 1), 0, 0);
		assertEquals(eNada.getAntiguedad(), 1);

		eTodo.cargarContratoDePlanta(LocalDate.of(2022, 10, 1), 0, 0, 0);
		assertEquals(eTodo.getAntiguedad(), 1);
	}

	@Test
	public void testGetAumentoAntiguedad() {
		assertEquals(eNada.getAumentoAntiguedad(), 0);

		eNada.cargarContratoPorHoras(LocalDate.of(2005, 1, 1), LocalDate.of(2011, 1, 1), 0, 0);
		assertEquals(eNada.getAumentoAntiguedad(), 0.3);

		eNada.cargarContratoPorHoras(LocalDate.of(2005, 1, 1), LocalDate.of(2011, 1, 1), 0, 0);
		assertEquals(eNada.getAumentoAntiguedad(), 0.5);

		eNada.cargarContratoPorHoras(LocalDate.of(2005, 1, 1), LocalDate.of(2011, 1, 1), 0, 0);
		assertEquals(eNada.getAumentoAntiguedad(), 0.7);

		eNada.cargarContratoPorHoras(LocalDate.of(2005, 1, 1), LocalDate.of(2011, 1, 1), 0, 0);
		assertEquals(eNada.getAumentoAntiguedad(), 1);
	}
}
