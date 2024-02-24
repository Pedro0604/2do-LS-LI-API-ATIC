package ar.edu.unlp.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OOBnB {
	private List<Usuario> usuarios;

	public OOBnB() {
		usuarios = new ArrayList<>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario registrarUsuario(String nombre, int dni, String direccion) {
		Usuario nuevo = new Usuario(nombre, dni, direccion);
		this.usuarios.add(nuevo);
		return nuevo;
	}

	public List<Propiedad> buscarPropiedades(DateLapseable periodo) {
		return this.getAllPropiedades().stream().filter(
				propiedad -> !this.usuarios.stream().anyMatch(usuario -> usuario.tieneReservada(propiedad, periodo)))
				.collect(Collectors.toList());
	}

	public Reserva reservar(Propiedad propiedad, Usuario inquilino, DateLapseable periodo) {
		Reserva r = null;
		if (this.buscarPropiedades(periodo).contains(propiedad)) {
			r = inquilino.reservar(propiedad, periodo);
		}
		return r;
	}

	private List<Propiedad> getAllPropiedades() {
		return this.usuarios.stream().flatMap(usuario -> usuario.getPropiedades().stream())
				.collect(Collectors.toList());
	}

	public double calcularIngresos(Usuario duenio, DateLapseable periodo) {
		return this.usuarios.stream().mapToDouble(usuario -> usuario.calcularIngresos(duenio, periodo)).sum();
	}
}
