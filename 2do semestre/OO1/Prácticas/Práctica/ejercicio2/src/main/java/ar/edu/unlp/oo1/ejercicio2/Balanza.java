package ar.edu.unlp.oo1.ejercicio2;

import java.time.LocalDate;

public class Balanza {
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public Balanza() {
		this.ponerEnCero();
	}

	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}

	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++;
		this.pesoTotal += producto.getPeso();
		this.precioTotal += producto.getPrecio();
	}

	public Ticket emitirTicket() {
		Ticket ticket = new Ticket();
		ticket.setCantidadDeProductos(this.cantidadDeProductos);
		ticket.setFecha(LocalDate.now());
		ticket.setPesoTotal(this.pesoTotal);
		ticket.setPrecioTotal(this.precioTotal);
		return ticket;
	}
}
