package ar.edu.unlp.oo1.ejercicio18;

import java.time.LocalDate;

public class Recibo {
	private String nombre, apellido, cuil;
	private int antiguedad;
	private LocalDate fechaGeneracion;
	private double montoTotal;

	public Recibo(String nombre, String apellido, String cuil, int antiguedad, double montoTotal) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.antiguedad = antiguedad;
		this.fechaGeneracion = LocalDate.now();
		this.montoTotal = montoTotal;
	}
}
