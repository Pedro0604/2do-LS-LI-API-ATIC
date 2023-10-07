package ar.edu.unlp.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseableTest {
	DateLapseable d1, d2;

	@BeforeEach
	void setUp() throws Exception {
		d1 = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31));
		d2 = new DateLapseSegundaVariacion(LocalDate.of(2023, 1, 1), 30);
	}

	@Test
	void testGetFrom() {
		assertEquals(d1.getFrom(), LocalDate.of(2023, 1, 1));
		assertEquals(d2.getFrom(), LocalDate.of(2023, 1, 1));
	}

	@Test
	void testGetTo() {
		assertEquals(d1.getTo(), LocalDate.of(2023, 1, 31));
		assertEquals(d2.getTo(), LocalDate.of(2023, 1, 31));
	}

	@Test
	void testGetSizeInDays() {
		assertEquals(d1.getSizeInDays(), 30);
		assertEquals(d2.getSizeInDays(), 30);
	}

	@Test
	void testIncludesDate() {
		assertFalse(d1.includesDate(LocalDate.of(2022, 12, 31)));
		assertTrue(d1.includesDate(LocalDate.of(2023, 1, 1)));
		assertTrue(d1.includesDate(LocalDate.of(2023, 1, 20)));
		assertTrue(d1.includesDate(LocalDate.of(2023, 1, 31)));
		assertFalse(d1.includesDate(LocalDate.of(2023, 2, 1)));

		assertFalse(d2.includesDate(LocalDate.of(2022, 12, 31)));
		assertTrue(d2.includesDate(LocalDate.of(2023, 1, 1)));
		assertTrue(d2.includesDate(LocalDate.of(2023, 1, 20)));
		assertTrue(d2.includesDate(LocalDate.of(2023, 1, 31)));
		assertFalse(d2.includesDate(LocalDate.of(2023, 2, 1)));
	}
}
