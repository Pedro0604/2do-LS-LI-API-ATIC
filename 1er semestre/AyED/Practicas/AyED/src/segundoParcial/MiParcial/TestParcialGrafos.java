package segundoParcial.MiParcial;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplMatrizAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplMatrizAdy;

public class TestParcialGrafos {

	public static void main(String[] args) {
		Vertice<Dato> a = new VerticeImplMatrizAdy<Dato>(new Dato("Maradona", 30));
		Vertice<Dato> b = new VerticeImplMatrizAdy<Dato>(new Dato("MACLA", 120));
		Vertice<Dato> c = new VerticeImplMatrizAdy<Dato>(new Dato("Catedral", 60));
		Vertice<Dato> d = new VerticeImplMatrizAdy<Dato>(new Dato("Rectorado", 45));
		Vertice<Dato> e = new VerticeImplMatrizAdy<Dato>(new Dato("Museo", 200));
		Vertice<Dato> f = new VerticeImplMatrizAdy<Dato>(new Dato("Palacio", 40));
		Vertice<Dato> g = new VerticeImplMatrizAdy<Dato>(new Dato("Coliseo", 50));
		Vertice<Dato> h = new VerticeImplMatrizAdy<Dato>(new Dato("Legislatura", 20));

		Grafo<Dato> grafo = new GrafoImplMatrizAdy<Dato>(15);
		grafo.agregarVertice(a);
		grafo.agregarVertice(b);
		grafo.agregarVertice(c);
		grafo.agregarVertice(d);
		grafo.agregarVertice(e);
		grafo.agregarVertice(f);
		grafo.agregarVertice(g);
		grafo.agregarVertice(h);

		grafo.conectar(a, b);
		grafo.conectar(a, c);
		grafo.conectar(a, g);
		grafo.conectar(a, h);
		grafo.conectar(b, c);
		grafo.conectar(c, d);
		grafo.conectar(d, e);
		grafo.conectar(d, f);
		grafo.conectar(f, g);
		grafo.conectar(g, h);

		grafo.conectar(b, a);
		grafo.conectar(c, a);
		grafo.conectar(g, a);
		grafo.conectar(h, a);
		grafo.conectar(c, b);
		grafo.conectar(d, c);
		grafo.conectar(e, d);
		grafo.conectar(f, d);
		grafo.conectar(g, f);
		grafo.conectar(h, g);

		InfoCamino resultado = Parcial.resolver(grafo, "Legislatura", 365);
		System.out.println("Camino: " + resultado.getCamino() + ". Tiempo total = " + resultado.getTiempoTot());
	}
}
