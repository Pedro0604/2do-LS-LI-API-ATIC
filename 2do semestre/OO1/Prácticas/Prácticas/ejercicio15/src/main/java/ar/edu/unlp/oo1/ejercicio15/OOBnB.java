package ar.edu.unlp.oo1.ejercicio15;

import java.util.List;

public class OOBnB {
	private List<Usuario> usuarios;

	public Usuario registrarUsuario(String nombre, int dni, String direccion) {
		Usuario nuevo = new Usuario(nombre, dni, direccion);
		this.usuarios.add(nuevo);
		return nuevo;
	}

	public List<Propiedad> buscarPropiedades(DateLapseable periodo){
		this.usuarios.stream().map(u->u.propiedadesDisponibles())
	}
}
