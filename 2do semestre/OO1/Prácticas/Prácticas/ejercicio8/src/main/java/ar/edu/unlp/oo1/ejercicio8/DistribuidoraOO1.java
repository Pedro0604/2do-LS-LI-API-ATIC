package ar.edu.unlp.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistribuidoraOO1 {
	private double precioKW;
	private Set<UsuarioOO1> usuarios;

	public DistribuidoraOO1(double preciokw) {
		this.precioKW = preciokw;
		this.usuarios = new HashSet<>();
	}

	public double getPrecioKW() {
		return this.precioKW;
	}

	public void agregarUsuario(UsuarioOO1 usuario) {
		this.usuarios.add(usuario);
	}

	public void setPrecioKW(double preciokw) {
		this.precioKW = preciokw;
	}

	public List<UsuarioOO1> getUsuarios() {
		return new ArrayList<>(this.usuarios);
	}

	public List<FacturaOO1> facturar() {
		List<FacturaOO1> result = this.usuarios.stream().map((UsuarioOO1 u) -> u.facturarEnBaseA(this.getPrecioKW()))
				.collect(Collectors.toList());
		return result;
	}

	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble((UsuarioOO1 u) -> u.ultimoConsumoActiva()).sum();
	}

}
