package ar.edu.unlp.oo1.ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private DateLapseable periodo;
	private Propiedad propiedad;

	public Reserva(DateLapseable periodo, Propiedad propiedad) {
		super();
		this.periodo = periodo;
		this.propiedad = propiedad;
	}

	public DateLapseable getPeriodo() {
		return periodo;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPeriodo(DateLapseable periodo) {
		this.periodo = periodo;
	}

	public boolean isEliminable() {
		return this.periodo.getFrom().isAfter(LocalDate.now());
	}

	public double calcularIngresos(Usuario duenio, DateLapseable periodoIngreso) {
		double ingreso = 0;
		if (this.propiedad.tieneComoDuenio(duenio) && this.periodo.overlaps(periodoIngreso)) {
			LocalDate fecha = this.periodo.getFrom().isBefore(periodoIngreso.getFrom()) ? periodoIngreso.getFrom()
					: this.periodo.getFrom();

			while (periodoIngreso.includesDate(fecha) && this.periodo.includesDate(fecha)
					&& !fecha.equals(periodoIngreso.getTo()) && !fecha.equals(this.periodo.getTo())) {
				ingreso += this.propiedad.getPrecioNoche();
				fecha = fecha.plusDays(1);
			}
		}
		return ingreso;
	}

	public double calcularPrecio() {
		return this.periodo.getSizeInDays() * this.propiedad.getPrecioNoche();
	}

	public boolean estaReservadaEn(Propiedad propiedad, DateLapseable periodo) {
		return this.propiedad == propiedad && periodo != null && this.periodo.overlaps(periodo);
	}
}
