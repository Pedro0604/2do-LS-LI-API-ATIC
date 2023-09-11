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

	public boolean tieneComoAncestroA(Mamifero m) {
		return tieneComoAncestroAPrivate(this, m);
		/*
		 * if (this.equals(m)) { return false; } if (this.getPadre() != null) { if
		 * (tieneComoAncestroAPrivate(this.getPadre(), m)) { return true; } } if
		 * (this.getMadre() != null) { return tieneComoAncestroAPrivate(this.getMadre(),
		 * m); } return false;
		 */
	}

	private boolean tieneComoAncestroAPrivate(Mamifero actual, Mamifero m) {
		if (actual != this && actual.equals(m)) {
			return true;
		}
		if (actual.getPadre() != null) {
			if (tieneComoAncestroAPrivate(actual.getPadre(), m)) {
				return true;
			}
		}
		if (actual.getMadre() != null) {
			return tieneComoAncestroAPrivate(actual.getMadre(), m);
		}
		return false;
	}
}
