package ar.edu.unlp.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class UsuarioOO1 {
	private String nombre;
	private String domicilio;
	private List<FacturaOO1> facturas;
	private List<ConsumoOO1> consumos;

	public UsuarioOO1(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.facturas = new ArrayList<FacturaOO1>();
		this.consumos = new ArrayList<ConsumoOO1>();
	}

	public void agregarMedicion(ConsumoOO1 medicion) {
		this.consumos.add(medicion);
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	private void agregarFactura(FacturaOO1 factura) {
		this.facturas.add(factura);
	}

	/**
	 * Obtiene el consumo de energía activa desde el consumo con fecha más reciente.
	 * 
	 * @return Consumo de energia activa si existe. Sino 0.
	 */
	public double ultimoConsumoActiva() {
		ConsumoOO1 consumo = this.ultimoConsumo();
		if (consumo == null) {
			return 0d;
		}
		return consumo.getConsumoDeEnergiaActiva();
	}

	/**
	 * Retorna el último consumo o null en caso que no exista
	 * 
	 * @return
	 */
	private ConsumoOO1 ultimoConsumo() {
		return this.consumos.stream().max((ConsumoOO1 c1, ConsumoOO1 c2) -> c1.getFecha().compareTo(c2.getFecha()))
				.orElse(null);
	}

	/**
	 * Si hay consumos, retorna lo correspondiente al consumo realizado. Factura 0
	 * si no hay consumos.
	 * 
	 * @param precioKW
	 * @return
	 */
	public FacturaOO1 facturarEnBaseA(double precioKW) {
		ConsumoOO1 ultimo = this.ultimoConsumo();
		if (ultimo == null) {
			return new FacturaOO1(0, 0, this);
		}

		double descuento = 0d;
		if (ultimo.factorDePotencia() > 0.8d) {
			descuento = 10;
		}
		FacturaOO1 factura = new FacturaOO1(ultimo.costoEnBase(precioKW), descuento, this);
		this.agregarFactura(factura);
		return factura;
	}

	public List<FacturaOO1> getFacturas() {
		return this.facturas;
	}
}
