package ar.edu.unlp.oo1.parcial_26_11_2022;

import java.util.List;

public class OrdenReparacion extends Orden {
	private String descripcion;
	private List<Empleado> empleados;
	private int cantHoras;

	public OrdenReparacion(String patente, List<Repuesto> repuestos, String descripcion, List<Empleado> empleados,
			int cantHoras) {
		super(patente, repuestos);
		this.descripcion = descripcion;
		this.empleados = empleados;
		this.cantHoras = cantHoras;
	}

	public double calcularMontoFinal() {
		double costo = this.empleados.stream().mapToDouble(e -> e.getValorHora()).sum() * this.cantHoras;
		costo += this.repuestos.stream().mapToDouble(r -> r.getCosto()).sum();
		return costo * 1.1;
	}
}
