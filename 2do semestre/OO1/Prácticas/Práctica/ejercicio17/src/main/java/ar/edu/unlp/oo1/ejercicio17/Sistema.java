package ar.edu.unlp.oo1.ejercicio17;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Cliente> clientes;
	private List<String> numerosDisponibles;

	public Sistema() {
		clientes = new ArrayList<>();
		numerosDisponibles = new ArrayList<>();
	}

	public void agregarNumeroDisponible(String numero) {
		this.numerosDisponibles.add(numero);
	}

	public String getNumeroDisponible() {
		if (this.numerosDisponibles.isEmpty()) {
			return null;
		} else {
			String num = this.numerosDisponibles.get(0);
			this.numerosDisponibles.remove(0);
			return num;
		}
	}

	private void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public ClienteFisico agregarClienteFisico(String nombre, String direccion, int dni) {
		ClienteFisico cliente = new ClienteFisico(nombre, direccion, this.getNumeroDisponible(), dni);
		this.agregarCliente(cliente);
		return cliente;
	}

	public ClienteJuridico agregarClienteJuridico(String nombre, String direccion, int cuit, String tipo) {
		ClienteJuridico cliente = new ClienteJuridico(nombre, direccion, this.getNumeroDisponible(), cuit, tipo);
		this.agregarCliente(cliente);
		return cliente;
	}
}