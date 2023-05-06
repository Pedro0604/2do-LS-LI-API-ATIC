package primerParcial.ProgramacionIII_24_04_2023_Tema2;

import tp03.ejercicio1.ArbolBinario;

public class TestProcesadorDeArbol {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(20);
		ArbolBinario<Integer> i = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> j = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> k = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> l = new ArbolBinario<Integer>(4);

		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		d.agregarHijoDerecho(h);
		e.agregarHijoIzquierdo(i);
		f.agregarHijoIzquierdo(j);
		f.agregarHijoDerecho(k);
		g.agregarHijoDerecho(l);

		a.printTree();

		ProcesadorDeArbol p = new ProcesadorDeArbol(a);
		System.out.println(p.procesar());
	}

}
