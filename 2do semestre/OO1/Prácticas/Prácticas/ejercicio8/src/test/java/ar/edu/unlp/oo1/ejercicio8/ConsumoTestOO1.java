package ar.edu.unlp.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsumoTestOO1 {

	private Consumo consumo;

	@BeforeEach
	public void setUp() {
		this.consumo = new Consumo(LocalDate.of(2020, 8, 20), 200d, 300d);
	}

	@Test
	public void testConsumo() {
		assertEquals(LocalDate.of(2020, 8, 20), this.consumo.getFecha());
		assertEquals(200d, this.consumo.getConsumoEnergiaActiva());
		assertEquals(300d, this.consumo.getConsumoEnergiaReactiva());
	}

	@Test
	public void testFactorDePotencia() {
		// 200 / sqrt(2oo^2 + 300^2)
		assertEquals(0.55, this.consumo.factorDePotencia(), 0.01);
	}

	@Test
	public void testCostoEnBase() {
		// 200d * 25
		assertEquals(5000d, this.consumo.costoEnBaseA(25d));
	}
}
