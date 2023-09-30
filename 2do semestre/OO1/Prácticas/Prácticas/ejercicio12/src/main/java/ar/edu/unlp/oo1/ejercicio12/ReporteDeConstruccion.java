package ar.edu.unlp.oo1.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;

	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<>();
	}

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public void addPieza(Pieza p) {
		this.piezas.add(p);
	}

	public double getVolumenDeMaterial(String nombreDeMaterial) {
		return this.piezas.stream().filter(p -> p.getMaterial().equals(nombreDeMaterial)).mapToDouble(p -> p.volumen())
				.sum();
	}

	public double getSuperficieDeColor(String nombreDeColor) {
		return this.piezas.stream().filter(p -> p.getColor().equals(nombreDeColor)).mapToDouble(p -> p.superficie())
				.sum();
	}
}
