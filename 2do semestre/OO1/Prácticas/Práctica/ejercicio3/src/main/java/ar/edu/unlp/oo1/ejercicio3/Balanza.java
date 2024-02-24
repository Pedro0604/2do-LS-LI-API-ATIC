package ar.edu.unlp.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private List<Producto> productos;

	public int getCantidadDeProductos() {
		return productos.size();
	}

	public double getPesoTotal() {
		return productos.stream().mapToDouble(prod->prod.getPeso()).sum();
	}

	public double getPrecioTotal() {
		return this.productos.stream().mapToDouble(prod->prod.getPrecio()).sum();
	}

	public Balanza() {
		this.ponerEnCero();
	}

	public void ponerEnCero() {
		productos = new ArrayList<Producto>();
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public Ticket emitirTicket() {
		Ticket ticket = new Ticket();
		ticket.setFecha(LocalDate.now());
		ticket.setProductos(productos);
		return ticket;
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
}
