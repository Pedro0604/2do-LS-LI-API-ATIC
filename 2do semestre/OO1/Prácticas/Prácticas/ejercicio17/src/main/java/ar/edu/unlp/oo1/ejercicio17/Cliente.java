package ar.edu.unlp.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre, direccion, numero;
	protected double descuento;
	protected List<Llamada> llamadas;

	public Cliente(String nombre, String direccion, String numero) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.llamadas = new ArrayList<>();
	}

	public void addLlamada(Llamada l) {
		this.llamadas.add(l);
	}

	public Llamada registrarLlamadaLocal(LocalDateTime inicio, int duracion, String llamador, String recibidor) {
		Llamada l = new Llamada(inicio, duracion, llamador, recibidor);
		this.addLlamada(l);
		return l;
	}

	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime inicio, int duracion, String llamador,
			String recibidor, int distancia) {
		LlamadaInterurbana l = new LlamadaInterurbana(inicio, duracion, llamador, recibidor, distancia);
		this.addLlamada(l);
		return l;
	}

	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime inicio, int duracion, String llamador,
			String recibidor, String origen, String destino) {
		LlamadaInternacional l = new LlamadaInternacional(inicio, duracion, llamador, recibidor, origen, destino);
		this.addLlamada(l);
		return l;
	}

	public Factura facturarLlamadas(LocalDate inicio, LocalDate fin) {
		double montoTotal = this.llamadas.stream().filter(l -> l.isInPeriod(inicio, fin))
				.mapToDouble(l -> l.getCostoLlamada()).sum();
		return (new Factura(this, inicio, fin, montoTotal - montoTotal * this.descuento));
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNumero() {
		return numero;
	}

	public double getDescuento() {
		return descuento;
	}

}
