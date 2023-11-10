package ar.edu.unlp.oo1.parcial_5_11_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ARBA {
	private List<Contribuyente> contribuyentes;

	public ARBA() {
		this.contribuyentes = new ArrayList<>();
	}

	public Contribuyente altaContribuyente(int dni, String email, String localidad) {
		Contribuyente c = new Contribuyente(dni, email, localidad);
		this.contribuyentes.add(c);
		return c;
	}

	public List<Contribuyente> getMasImpuestadosLocalidad(String localidad, int cantContribuyentes) {
		return this.contribuyentes.stream().filter(c -> c.isFrom(localidad))
				.sorted((c1, c2) -> Double.compare(c1.getImpuestos(), c2.getImpuestos())).limit(cantContribuyentes)
				.collect(Collectors.toList());
	}
}
