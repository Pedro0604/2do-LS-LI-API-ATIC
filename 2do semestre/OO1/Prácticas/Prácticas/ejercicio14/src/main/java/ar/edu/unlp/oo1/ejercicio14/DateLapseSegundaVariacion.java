package ar.edu.unlp.oo1.ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseSegundaVariacion implements DateLapseable {
	private LocalDate from;
	private int sizeInDays;

	public DateLapseSegundaVariacion(LocalDate from, int sizeInDays) {
		super();
		this.from = from;
		this.sizeInDays = sizeInDays;
	}

	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return this.from.plus(this.sizeInDays, ChronoUnit.DAYS);
	}

	public int getSizeInDays() {
		return this.sizeInDays;
	}

	public boolean includesDate(LocalDate date) {
		return (this.getFrom().isBefore(date) && this.getTo().isAfter(date)) || this.getFrom().equals(date)
				|| this.getTo().equals(date);
	}
}
