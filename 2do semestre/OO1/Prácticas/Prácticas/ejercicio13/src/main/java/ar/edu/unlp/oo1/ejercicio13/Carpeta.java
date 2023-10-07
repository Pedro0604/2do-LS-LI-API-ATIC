package ar.edu.unlp.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private List<Email> emails;
	private String nombre;

	public Carpeta(String nombre) {
		super();
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void addEmail(Email email) {
		this.emails.add(email);
	}

	public void removeEmail(Email email) {
		this.emails.remove(email);
	}

	public Email buscarEmail(String texto) {
		return this.emails.stream().filter(e -> e.tieneTexto(texto)).findFirst().orElse(null);
	}

	public int tamanioCarpeta() {
		return this.emails.stream().mapToInt(e -> e.tamanioEmail()).sum();
	}

	public void moverEmailA(Email email, Carpeta destino) {
		if (this.getEmails().contains(email)) {
			this.removeEmail(email);
			destino.addEmail(email);
		}
	}
}
