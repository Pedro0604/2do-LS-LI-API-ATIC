package primerParcial.Jueves_3_05_16hs;

import tp03.ejercicio1.ArbolBinario;

public class TestBuscadorArbol {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(20);
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(15);
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(12);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(13);
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> i = new ArbolBinario<Integer>(40);

		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoDerecho(f);
		e.agregarHijoIzquierdo(g);
		e.agregarHijoDerecho(h);
		f.agregarHijoIzquierdo(i);

		a.printTree();
		System.out.println();

		BuscadorArbol p = new BuscadorArbol(a);
		System.out.println(p.buscar());
	}

}
