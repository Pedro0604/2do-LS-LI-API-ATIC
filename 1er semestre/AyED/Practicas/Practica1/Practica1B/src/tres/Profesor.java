package tres;

public class Profesor extends Persona {
	private String catedra, facultad;

	public Profesor() {
		super();
	}

	public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
		super(nombre, apellido, email);
		this.catedra = catedra;
		this.facultad = facultad;
	}

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	@Override
	public String tusDatos() {
		return "Profesor: " + super.tusDatos() + ", catedra=" + getCatedra() + ", facultad=" + getFacultad();
	}
	
	
	
}
