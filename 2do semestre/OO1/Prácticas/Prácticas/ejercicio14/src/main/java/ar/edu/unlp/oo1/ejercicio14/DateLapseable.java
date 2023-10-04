package ar.edu.unlp.oo1.ejercicio14;

import java.time.LocalDate;

public interface DateLapseable {
	public LocalDate getFrom();

	public LocalDate getTo();

	public int getSizeInDays();

	public boolean includesDate(LocalDate date);
}
