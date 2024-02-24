package ar.edu.unlp.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios = new ArrayList<>();

	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
	}

	public double getPrecioKWh() {
		return precioKWh;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public List<Factura> facturar() {
		return this.usuarios.stream().map(usuario -> usuario.facturarEnBaseA(this.precioKWh))
				.collect(Collectors.toList());
	}

	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble(usuario -> usuario.ultimoConsumoActiva()).sum();
	}

	public void precioKWh(double precioKWh) {
		this.precioKWh = precioKWh;
	}
}
