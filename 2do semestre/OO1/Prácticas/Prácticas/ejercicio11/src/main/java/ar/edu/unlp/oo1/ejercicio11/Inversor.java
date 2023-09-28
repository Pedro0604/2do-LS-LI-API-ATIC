package ar.edu.unlp.oo1.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor implements ValorActualeable {
	private String nombre;
	private List<ValorActualeable> inversiones;

	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<>();
	}

	public double valorActual() {
		return this.inversiones.stream().mapToDouble(inversion -> inversion.valorActual()).sum();
	}
}
