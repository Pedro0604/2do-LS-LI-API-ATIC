package primerParcial.modulo1_AyED_2022.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class TestCodigoZigZag {

	public static void main(String[] args) {
		ArbolBinario<Character> a = new ArbolBinario<Character>('#');
		ArbolBinario<Character> b = new ArbolBinario<Character>('#');
		ArbolBinario<Character> c = new ArbolBinario<Character>('#');
		ArbolBinario<Character> d = new ArbolBinario<Character>('#');
		ArbolBinario<Character> e = new ArbolBinario<Character>('#');
		ArbolBinario<Character> f = new ArbolBinario<Character>('#');
		ArbolBinario<Character> g = new ArbolBinario<Character>('C');
		ArbolBinario<Character> h = new ArbolBinario<Character>('S');
		ArbolBinario<Character> i = new ArbolBinario<Character>('#');
		ArbolBinario<Character> j = new ArbolBinario<Character>('E');
		ArbolBinario<Character> k = new ArbolBinario<Character>('D');
		ArbolBinario<Character> l = new ArbolBinario<Character>('#');
		ArbolBinario<Character> m = new ArbolBinario<Character>('#');
		ArbolBinario<Character> n = new ArbolBinario<Character>('R');
		ArbolBinario<Character> ñ = new ArbolBinario<Character>('O');
		ArbolBinario<Character> o = new ArbolBinario<Character>('A');
		ArbolBinario<Character> p = new ArbolBinario<Character>('G');

		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		c.agregarHijoIzquierdo(e);
		c.agregarHijoDerecho(f);
		d.agregarHijoIzquierdo(g);
		d.agregarHijoDerecho(h);
		e.agregarHijoIzquierdo(i);
		e.agregarHijoDerecho(j);
		f.agregarHijoIzquierdo(k);
		f.agregarHijoDerecho(l);
		i.agregarHijoIzquierdo(m);
		i.agregarHijoDerecho(n);
		l.agregarHijoDerecho(ñ);
		m.agregarHijoIzquierdo(o);
		m.agregarHijoDerecho(p);

		a.printTree();

		ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		lista.agregarFinal("101");
		lista.agregarFinal("001");
		lista.agregarFinal("10001");
		lista.agregarFinal("1111");
		lista.agregarFinal("1001");
		lista.agregarFinal("110");
		lista.agregarFinal("1111");

		System.out.println(CodigoZigZag.descifrarCodigo(a, lista));
	}

}
