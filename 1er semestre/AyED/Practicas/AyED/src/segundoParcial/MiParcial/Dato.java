package segundoParcial.MiParcial;

public class Dato {
	private String nombre;
	private int tiempo;

	public Dato(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
