package tp06.ejercicio4;

import tp06.ejercicio3.*;

public class TestEjercicio4 {

	public static void main(String[] args) {
		Grafo<Integer> g = new GrafoImplMatrizAdy<Integer>(20);
		Vertice<Integer> v = new VerticeImplMatrizAdy<Integer>(1);
		Vertice<Integer> w = new VerticeImplMatrizAdy<Integer>(2);
		Vertice<Integer> x = new VerticeImplMatrizAdy<Integer>(3);
		Vertice<Integer> y = new VerticeImplMatrizAdy<Integer>(4);
		Vertice<Integer> z = new VerticeImplMatrizAdy<Integer>(5);
		Vertice<Integer> a = new VerticeImplMatrizAdy<Integer>(6);
		Vertice<Integer> b = new VerticeImplMatrizAdy<Integer>(7);
		Vertice<Integer> c = new VerticeImplMatrizAdy<Integer>(8);
		Vertice<Integer> d = new VerticeImplMatrizAdy<Integer>(9);
		Vertice<Integer> e = new VerticeImplMatrizAdy<Integer>(10);
		Vertice<Integer> zzz = new VerticeImplMatrizAdy<Integer>(999);
		g.agregarVertice(v);
		g.agregarVertice(w);
		g.agregarVertice(x);
		g.agregarVertice(y);
		g.agregarVertice(z);
		g.agregarVertice(a);
		g.agregarVertice(b);
		g.agregarVertice(c);
		g.agregarVertice(d);
		g.agregarVertice(e);
		g.agregarVertice(zzz);
		g.conectar(v, w);
		g.conectar(w, d);
		g.conectar(w, y);
		g.conectar(x, z);
		g.conectar(z, e);
		g.conectar(x, b);
		g.conectar(v, a);
		g.conectar(a, b);
		g.conectar(b, a);
		g.conectar(a, d);
		
		Recorridos<Integer> r = new Recorridos<Integer>();
		System.out.println(r.dfs(g));
		
		System.out.println(r.bfs(g));
	}

}
