package ar.edu.unlp.oo1.parcial_26_11_2022;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyCarBoxes {
	private List<Repuesto> repuestos;
	private List<Empleado> empleados;
	private List<Orden> ordenes;

	public MyCarBoxes() {
		this.repuestos = new ArrayList<>();
		this.empleados = new ArrayList<>();
	}

	public Repuesto altaRepuesto(String nombre, double costo, LocalDate fechaFabricacion) {
		Repuesto r = new Repuesto(nombre, costo, fechaFabricacion);
		this.repuestos.add(r);
		return r;
	}

	public Empleado altaEmpleado(String nombre, double valorHora) {
		Empleado e = new Empleado(nombre, valorHora);
		this.empleados.add(e);
		return e;
	}

	public OrdenRepuesto altaOrdenRepuestos(String patente, List<Repuesto> repuestos) {
		OrdenRepuesto o = new OrdenRepuesto(patente, repuestos);
		this.ordenes.add(o);
		return o;
	}

	public OrdenReparacion altaOrdenReparacion(String patente, List<Repuesto> repuestos, String descripcion,
			List<Empleado> empleados, int cantHoras) {
		OrdenReparacion o = new OrdenReparacion(patente, repuestos, descripcion, empleados, cantHoras);
		this.ordenes.add(o);
		return o;
	}

	public List<Factura> facturarOrdenes(List<Orden> ordenes) {
		List<Orden> ordenesUltimos12Meses = this.ordenes.stream().filter(o -> o.esEnUltimos12Meses())
				.collect(Collectors.toList());
		return ordenes.stream().map(o -> o.facturar(ordenesUltimos12Meses)).collect(Collectors.toList());
	}
}
