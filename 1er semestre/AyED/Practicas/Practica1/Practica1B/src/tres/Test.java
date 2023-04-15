package tres;

public class Test {

	public static void main(String[] args) {
		Estudiante[] est = {new Estudiante(), new Estudiante()};
		Profesor[] pr = {new Profesor(), new Profesor(), new Profesor()};

		
		est[0].setApellido("Spadari");
		est[0].setComision(3);
		est[0].setNombre("Pedro");
		est[0].setDireccion("15 1413");
		est[0].setEmail("pedrospadari0604@gmail.com");
		
		est[1].setApellido("Giannotta");
		est[1].setComision(22);
		est[1].setNombre("Lucia");
		est[1].setDireccion("49 738");
		est[1].setEmail("luciagiannotta03@hotmail.com");
		
		pr[0].setApellido("Valdez Avalos");
		pr[0].setCatedra("Antro 1");
		pr[0].setNombre("Diana");
		pr[0].setFacultad("Instituto 9");
		pr[0].setEmail("dianavaldez1108@gmail.com");
		
		pr[1].setApellido("Spadari");
		pr[1].setCatedra("Biblioteca");
		pr[1].setNombre("Guillermo");
		pr[1].setFacultad("Instituto 17");
		pr[1].setEmail("spadariguillermo@yahoo.com");
		
		pr[2].setApellido("Echavarría");
		pr[2].setCatedra("Estadística");
		pr[2].setNombre("Norma Elsa");
		pr[2].setFacultad("Instituto 23");
		pr[2].setEmail("abuelita@gmail.com");
		
		for (Estudiante e: est) {
			System.out.println(e.tusDatos());
		}
		
		for (Profesor p: pr) {
			System.out.println(p.tusDatos());
		}
	}

}
