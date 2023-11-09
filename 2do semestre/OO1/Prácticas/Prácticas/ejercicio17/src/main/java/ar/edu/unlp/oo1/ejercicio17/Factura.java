package ar.edu.unlp.oo1.ejercicio17;

import java.time.LocalDate;

public class Factura {
	private Cliente cliente;
	private LocalDate fechaFacturacion, inicio, fin;
	private double montoTotal;

	public Factura(Cliente cliente, LocalDate inicio, LocalDate fin, double montoTotal) {
		super();
		this.cliente = cliente;
		this.fechaFacturacion = LocalDate.now();
		this.inicio = inicio;
		this.fin = fin;
		this.montoTotal = montoTotal;
	}

	public Factura aniadirDescuento() {
		this.montoTotal *= 0.9;
		return this;
	}

	public double getMontoTotal() {
		return this.montoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

}
