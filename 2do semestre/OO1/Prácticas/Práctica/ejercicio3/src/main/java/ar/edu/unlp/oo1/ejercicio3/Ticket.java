package ar.edu.unlp.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private List<Producto> productos;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeProductos() {
		return productos.size();
	}

	public double getPesoTotal() {
		return productos.stream().mapToDouble(prod->prod.getPeso()).sum();
	}

	public double getPrecioTotal() {
		return productos.stream().mapToDouble(prod->prod.getPrecio()).sum();
	}

	public double impuesto() {
		return 0.21 * this.getPrecioTotal();
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
