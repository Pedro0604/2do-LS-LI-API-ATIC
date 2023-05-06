package primerParcial.modulo1_AyED_2022.ejercicio6;

import tp03.ejercicio1.ArbolBinario;

public class TestNivelArbol {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> i = new ArbolBinario<Integer>(4);

		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoDerecho(f);
		e.agregarHijoIzquierdo(g);
		e.agregarHijoDerecho(h);
		f.agregarHijoIzquierdo(i);

		NivelArbol n = new NivelArbol(a);
		System.out.println(n.minEnNivelAB(1));
		System.out.println(n.minEnNivelAB(2));
		System.out.println(n.minEnNivelAB(3));
	}

}
