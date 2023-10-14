package ar.edu.unlp.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int dni;
	private String direccion;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;

	public Usuario(String nombre, int dni, String direccion) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.propiedades = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}
	
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioNoche, String direccion) {
		Propiedad nueva = new Propiedad(nombre, descripcion, precioNoche, direccion, this);
		this.propiedades.add(nueva);
		return nueva;
	}
	
	public boolean tieneReservada(Propiedad propiedad, DateLapseable periodo) {
		return this.reservas.stream().anyMatch(reserva->reserva.estaReservadaEn(propiedad, periodo));
	}
	
	public void eliminarReserva(Reserva reserva) {
		if(reserva.isEliminable()) {
			this.reservas.remove(reserva);
		}
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public Reserva reservar(Propiedad propiedad, DateLapseable periodo) {
		Reserva nueva = new Reserva(periodo, propiedad);
		this.reservas.add(nueva);
		return nueva;
	}
	
	public double calcularIngresos(Usuario duenio, DateLapseable periodo) {
		return this.reservas.stream().mapToDouble(reserva->reserva.calcularIngresos(duenio, periodo)).sum();
	}
}
