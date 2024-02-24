package ar.edu.unlp.oo1.ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private List<Empleado> empleados;

	public Empresa() {
		this.empleados = new ArrayList<>();
	}

	public Empleado altaEmpleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento,
			boolean tieneConyugeACargo, boolean tieneHijosACargo) {
		Empleado empleadoNuevo = new Empleado(nombre, apellido, cuil, fechaNacimiento, tieneConyugeACargo,
				tieneHijosACargo);
		this.empleados.add(empleadoNuevo);
		return empleadoNuevo;
	}

	public Empleado buscarEmpleado(String cuil) {
		return this.empleados.stream().filter(e -> e.tieneComoCuil(cuil)).findFirst().orElse(null);
	}

	public void bajaEmpleado(Empleado e) {
		this.empleados.remove(e);
	}

	public List<Empleado> getEmpleadosConContratosVencidos() {
		return this.empleados.stream().filter(e -> e.contratoActualEstaVencido()).collect(Collectors.toList());
	}

	public List<Recibo> generarRecibosDeSueldo() {
		return this.empleados.stream().map(e -> e.generarReciboDeSueldo()).collect(Collectors.toList());
	}
}
