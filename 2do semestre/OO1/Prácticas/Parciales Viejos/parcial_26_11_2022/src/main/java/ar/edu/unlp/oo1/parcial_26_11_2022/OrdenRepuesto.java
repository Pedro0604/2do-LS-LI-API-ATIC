package ar.edu.unlp.oo1.parcial_26_11_2022;

import java.util.List;

public class OrdenRepuesto extends Orden {

	public OrdenRepuesto(String patente, List<Repuesto> repuestos) {
		super(patente, repuestos);
	}

	public double calcularMontoFinal() {
		double costo = this.repuestos.stream().mapToDouble(r -> r.getCosto()).sum();
		if (this.repuestos.stream().anyMatch(r -> r.isOlderThan5())) {
			return costo * 1.08;
		} else {
			return costo * 1.15;
		}
	}
}
