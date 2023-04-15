package tp02.ejercicio2_3;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		ListaEnlazadaGenerica<Estudiante> l = new ListaEnlazadaGenerica<>();
		Estudiante e;
		e = new Estudiante("Pedro", "Spadari", "pedrospadari0604@gmail.com", "15 1413", 10);
		l.agregarFinal(e);
		e = new Estudiante("Lucia", "Spadari", "luciaspadari@gmail.com", "15 1413", 8);
		l.agregarFinal(e);
		e = new Estudiante("Diana", "Valdez", "dianavaldez1108@gmail.com", "15 1413", 4);
		l.agregarFinal(e);
		e = new Estudiante("Guillermo", "Spadari", "spadariguillermo@yahoo.com", "15 1413", 10);
		l.agregarFinal(e);
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo().tusDatos());
		}
	}

}
