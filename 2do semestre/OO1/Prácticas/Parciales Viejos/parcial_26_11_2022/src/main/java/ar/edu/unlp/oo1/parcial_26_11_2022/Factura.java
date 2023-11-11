package ar.edu.unlp.oo1.parcial_26_11_2022;

import java.time.LocalDate;

public class Factura {
	private LocalDate fecha;
	private String patente;
	private double montoFinal, descuento;

	public Factura(String patente, double montoFinal, double descuento) {
		this.fecha = LocalDate.now();
		this.patente = patente;
		this.montoFinal = montoFinal;
		this.descuento = descuento;
	}
}
