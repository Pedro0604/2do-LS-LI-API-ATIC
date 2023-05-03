package primerParcial.esMonodistante;

import tp03.ejercicio1.ArbolBinario;

public class TestEsMonodistante {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> i = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> j = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> k = new ArbolBinario<Integer>(2);
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		e.agregarHijoIzquierdo(h);
		e.agregarHijoDerecho(i);
		f.agregarHijoIzquierdo(j);
		g.agregarHijoDerecho(k);
		EsMonodistante esM = new EsMonodistante();
		esM.setArbol(a);
		a.printTree();
		System.out.println(esM.esMonodistante(8));
	}

}
