package ar.edu.unlp.oo1.ejercicio5;

import java.time.LocalDate;

public class Mamifero {
	private String identificador = null;
	private String especie = null;
	private LocalDate fechaNacimiento = null;
	private Mamifero padre = null;
	private Mamifero madre = null;

	public Mamifero() {
	}

	public Mamifero(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}

	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null) {
			return this.getMadre().getPadre();
		}
		return null;
	}

	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null) {
			return this.getMadre().getMadre();
		}
		return null;
	}

	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null) {
			return this.getPadre().getPadre();
		}
		return null;
	}

	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null) {
			return this.getPadre().getMadre();
		}
		return null;
	}

	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return tieneComoAncestroMaternoA(unMamifero) || tieneComoAncestroPaternoA(unMamifero);
	}

	private boolean tieneComoAncestroMaternoA(Mamifero unMamifero) {
		return madre == unMamifero || (madre != null && madre.tieneComoAncestroA(unMamifero));
	}

	private boolean tieneComoAncestroPaternoA(Mamifero unMamifero) {
		return padre == unMamifero || (padre != null && padre.tieneComoAncestroA(unMamifero));
	}
}
