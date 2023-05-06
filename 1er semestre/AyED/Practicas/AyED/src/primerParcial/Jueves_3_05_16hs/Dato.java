package primerParcial.Jueves_3_05_16hs;

public class Dato {
	private Integer elemento;
	private Integer profundidad;
	private Integer profundidadActual;

	public Dato(Integer elemento, Integer profundidad, Integer profundidadActual) {
		super();
		this.elemento = elemento;
		this.profundidad = profundidad;
		this.profundidadActual = profundidadActual;
	}

	public Integer getElemento() {
		return elemento;
	}

	public void setElemento(Integer elemento) {
		this.elemento = elemento;
	}

	public Integer getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Integer profundidad) {
		this.profundidad = profundidad;
	}

	public Integer getProfundidadActual() {
		return profundidadActual;
	}

	public void setProfundidadActual(Integer profundidadActual) {
		this.profundidadActual = profundidadActual;
	}

}
