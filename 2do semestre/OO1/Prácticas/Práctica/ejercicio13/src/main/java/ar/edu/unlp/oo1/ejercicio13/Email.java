package ar.edu.unlp.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;

	public Email(String titulo, String cuerpo) {
		super();
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public List<Archivo> getAdjuntos() {
		return adjuntos;
	}

	public void addAdjunto(Archivo adjunto) {
		this.adjuntos.add(adjunto);
	}

	public boolean tieneTexto(String texto) {
		return texto != null && (this.titulo.contains(texto) || this.cuerpo.contains(texto));
	}

	public int tamanioEmail() {
		return this.adjuntos.stream().mapToInt(a -> a.getTamanio()).sum();
	}
}
