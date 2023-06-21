package tp06.ejercicio5;

import java.io.IOException;

import graphBuilder.GraphBuilder;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class TestEjercicio5 {

	public static void main(String[] args) {
		String path = "D:\\Pedro\\Facultad\\2do\\1er semestre\\AyED\\Practicas\\AyED\\src\\tp06\\ejercicio5\\map.json";
		GraphBuilder gb = new GraphBuilder(path, false);
		try {
			Mapa mapa = new Mapa(gb.build());

			// Devolver camino
			System.out.println("Camino 1: " + mapa.devolverCamino("La Plata", "Magdalena"));
			System.out.println("Camino 2: " + mapa.devolverCamino("General Mansilla", "Poblet"));
			System.out.println("Camino 3: " + mapa.devolverCamino("Vieytes", "Arana"));
			System.out.println("Camino 4: " + mapa.devolverCamino("Ignacio Correas", "La Plata"));
			System.out.println("Camino 5: " + mapa.devolverCamino("Ignacio Correas", "Vieytes"));
			System.out.println();

			// Devolver camino exceptuando
			ListaGenerica<String> ciudades = new ListaEnlazadaGenerica<String>();
			ciudades.agregarFinal("Arana");
			ciudades.agregarFinal("General Mansilla");
			System.out.println(
					"Camino exceptuando 1: " + mapa.devolverCaminoExceptuando("La Plata", "Magdalena", ciudades));
			System.out.println(
					"Camino exceptuando 2: " + mapa.devolverCaminoExceptuando("Ignacio Correas", "Vieytes", ciudades));
			System.out.println();

			gb = new GraphBuilder(path, true);
			mapa = new Mapa(gb.build());

			// Devolver camino más corto
			System.out.println("Camino más corto 1: " + mapa.caminoMasCorto("La Plata", "Magdalena"));
			System.out.println("Camino más corto 2: " + mapa.caminoMasCorto("Los Naranjos", "Magdalena"));
			System.out.println();

			// Devolver camino sin cargar combustible
			System.out.println(
					"Camino sin cargar combustible 1: " + mapa.caminoSinCargarCombustible("La Plata", "Magdalena", 40));
			System.out.println(
					"Camino sin cargar combustible 2: " + mapa.caminoSinCargarCombustible("La Plata", "Magdalena", 70));
			System.out.println("Camino sin cargar combustible 3: "
					+ mapa.caminoSinCargarCombustible("La Plata", "Magdalena", 101));
			System.out.println("Camino sin cargar combustible 4: "
					+ mapa.caminoSinCargarCombustible("La Plata", "Magdalena", 106));
			System.out.println("Camino sin cargar combustible 5: "
					+ mapa.caminoSinCargarCombustible("La Plata", "Magdalena", 107));
			System.out.println(
					"Camino sin cargar combustible 6: " + mapa.caminoSinCargarCombustible("La Plata", "Vieytes", 100));
			System.out.println();

			// Devolver camino con menos cargas de combustible
			System.out.println("Camino con menor carga de combustible 1: "
					+ mapa.caminoConMenorCargaDeCombustible("La Plata", "Magdalena", 41));
			System.out.println("Camino con menor carga de combustible 2: "
					+ mapa.caminoConMenorCargaDeCombustible("La Plata", "Magdalena", 42));
			System.out.println("Camino con menor carga de combustible 3: "
					+ mapa.caminoConMenorCargaDeCombustible("La Plata", "Magdalena", 45));
			System.out.println("Camino con menor carga de combustible 4: "
					+ mapa.caminoConMenorCargaDeCombustible("La Plata", "Magdalena", 71));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
