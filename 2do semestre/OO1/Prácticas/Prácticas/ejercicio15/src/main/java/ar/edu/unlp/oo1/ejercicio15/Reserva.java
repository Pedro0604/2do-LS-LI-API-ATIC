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
	
	public boolean isEliminable() {
		return this.periodo.getFrom().isAfter(LocalDate.now());
	}
	
	public double calcularIngresos(Usuario duenio, DateLapseable periodoIngreso) {
		double ingreso= 0;
		if(this.propiedad.tieneComoDuenio(duenio) && this.periodo.overlaps(periodoIngreso)) {
			LocalDate fecha = this.periodo.getFrom();
			while(!fecha.isAfter(this.periodo.getTo()) && !fecha.isAfter(periodoIngreso.getTo())) {
				if(periodoIngreso.includesDate(fecha)) {
					ingreso += this.propiedad.getPrecioNoche();
				}
			}
		}
		return ingreso;
	}
	
	public double calcularPrecio() {
		return this.periodo.getSizeInDays() * this.propiedad.getPrecioNoche();
	}
	
	public boolean estaReservadaEn(Propiedad propiedad, DateLapseable periodo) {
		return this.propiedad == propiedad && this.periodo.overlaps(periodo);
	}
}
