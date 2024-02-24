package ar.edu.unlp.oo1.ejercicio17;

public class ClienteJuridico extends Cliente {
	private long cuit;
	private String tipo;

	public ClienteJuridico(String nombre, String direccion, String numero, long cuit, String tipo) {
		super(nombre, direccion, numero);
		this.cuit = cuit;
		this.tipo = tipo;
		this.descuento = 0;
	}

	public long getCuit() {
		return cuit;
	}

	public String getTipo() {
		return tipo;
	}

}
