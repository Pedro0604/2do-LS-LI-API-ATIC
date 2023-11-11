package ar.edu.unlp.oo1.parcial_26_11_2022;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class Orden {
	private String patente;
	protected List<Repuesto> repuestos;
	private LocalDate fecha;

	public Orden(String patente, List<Repuesto> repuestos) {
		this.patente = patente;
		this.repuestos = repuestos;
		this.fecha = LocalDate.now();
	}

	public boolean esEnUltimos12Meses() {
		return ChronoUnit.MONTHS.between(fecha, LocalDate.now()) <= 12;
	}

	public boolean hasPatente(String patente) {
		return this.patente.equals(patente);
	}

	public abstract double calcularMontoFinal();

	public Factura facturar(List<Orden> ordenesUltimos12Meses) {
		double descuento = ordenesUltimos12Meses.stream().anyMatch(o -> o.hasPatente(this.patente)) ? 0.05 : 0;
		Factura f = new Factura(this.patente, this.calcularMontoFinal(), descuento);
		return f;
	}
}
