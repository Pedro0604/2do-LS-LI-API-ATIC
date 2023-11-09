package ar.edu.unlp.oo1.ejercicio17;

public class ClienteFisico extends Cliente {
	private int dni;

	public ClienteFisico(String nombre, String direccion, String numero, int dni) {
		super(nombre, direccion, numero);
		this.dni = dni;
		this.descuento = 0.1;
	}

	public int getDni() {
		return dni;
	}

}
