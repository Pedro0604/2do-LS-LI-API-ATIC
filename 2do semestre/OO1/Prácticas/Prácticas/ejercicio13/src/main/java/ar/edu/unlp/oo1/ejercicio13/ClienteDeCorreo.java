package ar.edu.unlp.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;

	public ClienteDeCorreo(Carpeta inbox) {
		super();
		this.inbox = inbox;
		this.carpetas = new ArrayList<>();
	}

	public List<Carpeta> getCarpetas() {
		List<Carpeta> c = new ArrayList<>(this.carpetas);
		c.add(inbox);
		return c;
	}

	public void recibir(Email email) {
		this.inbox.addEmail(email);
	}

	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.removeEmail(email);
		destino.addEmail(email);
	}

	public Email buscar(String texto) {
		return this.getCarpetas().stream().map(c -> c.buscarEmail(texto)).filter(c -> c != null).findFirst()
				.orElse(null);
	}

	public int espacioOcupado() {
		return this.getCarpetas().stream().mapToInt(c -> c.tamanioCarpeta()).sum();
	}

	public void setInbox(Carpeta inbox) {
		this.inbox = inbox;
	}

	public void addCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
}
