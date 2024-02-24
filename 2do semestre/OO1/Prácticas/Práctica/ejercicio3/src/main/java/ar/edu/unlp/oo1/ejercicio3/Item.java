package ar.edu.unlp.oo1.ejercicio3;

public class Item {
	private String detalle;
	private Integer cantidad;
	private double costoUnitario;

	public Item(String detalle, Integer cantidad, double costoUnitario) {
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
	}
	
	public String getDetalle() {
		return this.detalle;
	}

	public double getCostoUnitario() {
		return this.costoUnitario;
	}

	public double costo() {
		return this.costoUnitario * this.cantidad;
	}
}
