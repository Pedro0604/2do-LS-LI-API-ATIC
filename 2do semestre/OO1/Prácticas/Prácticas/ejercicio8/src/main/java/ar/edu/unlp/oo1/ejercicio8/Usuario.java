package ar.edu.unlp.oo1.ejercicio8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos = new ArrayList<Consumo>();
	private List<Factura> facturas = new ArrayList<Factura>();

	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void agregarMedicion(Consumo consumo) {
		this.consumos.add(consumo);
	}

	public double ultimoConsumoActiva() {
		return this.ultimoConsumo() != null ? this.ultimoConsumo().getConsumoEnergiaActiva() : 0;
	}

	private Consumo ultimoConsumo() {
		return this.consumos.stream().max((c1, c2) -> c1.getFecha().compareTo(c2.getFecha())).orElse(null);
	}

	public Factura facturarEnBaseA(double precioKWh) {
		double monto = this.ultimoConsumo() != null ? this.ultimoConsumo().costoEnBaseA(precioKWh) : 0;
		double descuento = this.ultimoConsumo() != null ? (this.ultimoConsumo().factorDePotencia() > 0.8 ? 0.1 : 0) : 0;
		Factura factura = new Factura(this, monto, descuento, LocalDate.now());
		this.facturas.add(factura);

		return factura;
	}

	public List<Factura> facturas() {
		return this.facturas;
	}
}
