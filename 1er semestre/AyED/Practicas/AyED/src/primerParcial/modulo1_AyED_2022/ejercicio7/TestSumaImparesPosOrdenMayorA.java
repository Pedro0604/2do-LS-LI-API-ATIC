package primerParcial.modulo1_AyED_2022.ejercicio7;

import tp03.ejercicio1.ArbolBinario;

public class TestSumaImparesPosOrdenMayorA {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(56);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(38);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(31);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(87);
		ArbolBinario<Integer> i = new ArbolBinario<Integer>(77);
		ArbolBinario<Integer> j = new ArbolBinario<Integer>(94);
		ArbolBinario<Integer> k = new ArbolBinario<Integer>(16);
		ArbolBinario<Integer> l = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> m = new ArbolBinario<Integer>(43);
		ArbolBinario<Integer> n = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> ñ = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> o = new ArbolBinario<Integer>(10);

		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		d.agregarHijoIzquierdo(h);
		d.agregarHijoDerecho(i);
		e.agregarHijoDerecho(j);
		i.agregarHijoIzquierdo(k);
		j.agregarHijoDerecho(l);
		k.agregarHijoDerecho(m);
		l.agregarHijoIzquierdo(n);
		m.agregarHijoIzquierdo(ñ);
		m.agregarHijoDerecho(o);

		a.printTree();
		System.out.println("La suma de los impares mayores a 30 es: "
				+ SumaImparesPosOrdenMayorA.sumaImparesPosOrdenMayorA(a, 30));
	}

}
