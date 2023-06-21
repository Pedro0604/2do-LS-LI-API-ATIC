package graphBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class GraphBuilder {
	private String path;
	private boolean pesado = true;
	private boolean dirigido = true;

	public GraphBuilder(String path) {
		this.path = path;
	}

	public GraphBuilder(String path, boolean pesado) {
		this.path = path;
		this.pesado = pesado;
	}

	public GraphBuilder(String path, boolean pesado, boolean dirigido) {
		this.path = path;
		this.pesado = pesado;
		this.dirigido = dirigido;
	}

	public Grafo<String> build() throws IOException {
		Grafo<String> grafo = new GrafoImplListAdy<>();
		JSONObject json = readJsonObject();

		List<Object> verticesList = json.getJSONArray("vertices").toList();
		verticesList.forEach(v -> {
			grafo.agregarVertice(new VerticeImplListAdy<String>(String.valueOf(v)));
		});

		JSONArray aristasJson = json.getJSONArray("aristas");
		for (int i = 0; i < aristasJson.length(); i++) {
			JSONArray aristaJson = aristasJson.getJSONArray(i);
			Vertice<String> origen = grafo.vertice(verticesList.indexOf(aristaJson.get(0)) + 1);
			Vertice<String> destino = grafo.vertice(verticesList.indexOf(aristaJson.get(1)) + 1);
			// int peso = json.getBoolean("pesado") ? aristaJson.getInt(2) : 1;
			int peso = pesado ? aristaJson.getInt(2) : 1;

			grafo.conectar(origen, destino, peso);
			// if (!json.getBoolean("dirigido"))
			if (!dirigido)
				grafo.conectar(destino, origen, peso);
		}

		return grafo;
	}

	private JSONObject readJsonObject() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null)
			builder.append(line);
		reader.close();

		return new JSONObject(builder.toString());
	}

}
