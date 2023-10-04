package ar.edu.unlp.oo1.ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate from, to;

	public DateLapse(LocalDate from, LocalDate to) {
		super();
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return to;
	}

	public int getSizeInDays() {
		return (int) this.from.until(to, ChronoUnit.DAYS);
	}

	public boolean includesDate(LocalDate date) {
		return (this.getFrom().isBefore(date) && this.getTo().isAfter(date)) || this.getFrom().equals(date)
				|| this.getTo().equals(date);
	}
}
