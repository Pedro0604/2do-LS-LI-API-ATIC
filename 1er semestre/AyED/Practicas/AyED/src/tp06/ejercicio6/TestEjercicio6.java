package tp06.ejercicio6;

import java.io.IOException;

import graphBuilder.GraphBuilder;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class TestEjercicio6 {

	public static void main(String[] args) {
		String path = "D:\\Pedro\\Facultad\\2do\\1er semestre\\AyED\\Practicas\\AyED\\src\\tp06\\ejercicio6\\oslo.json";
		GraphBuilder gb = new GraphBuilder(path, true, false);
		try {
			ListaGenerica<String> lugRestr = new ListaEnlazadaGenerica<String>();
			lugRestr.agregarFinal("Akker Brigge");
			lugRestr.agregarFinal("Palacio Real");

			System.out.println("Camino: " + VisitaOslo.paseoEnBici(gb.build(), "Museo Vikingo", 120, lugRestr));

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
