package primerParcial.MiParcial;

import tp03.ejercicio1.ArbolBinario;

public class TestParcialArbol {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(-5);
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(23);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(19);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(-3);
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(55);
		ArbolBinario<Integer> i = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> j = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> k = new ArbolBinario<Integer>(18);

		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoIzquierdo(f);
		d.agregarHijoIzquierdo(g);
		e.agregarHijoIzquierdo(h);
		e.agregarHijoDerecho(i);
		f.agregarHijoDerecho(j);
		j.agregarHijoIzquierdo(k);

		a.printTree();

		ParcialArbol p = new ParcialArbol(a);

		int[] v = { 7, 2, -5, 19, -3 };

		for (int num : v) {
			System.out.println(
					"El arbol tiene mas subarboles con hijos unicos en el subarbol izquierdo que en el derecho? "
							+ p.isLeftTree(num));
		}
	}

}
