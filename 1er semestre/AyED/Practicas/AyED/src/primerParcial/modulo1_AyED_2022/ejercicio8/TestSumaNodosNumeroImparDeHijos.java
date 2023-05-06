package primerParcial.modulo1_AyED_2022.ejercicio8;

import tp04.ejercicio1.ArbolGeneral;

public class TestSumaNodosNumeroImparDeHijos {

	public static void main(String[] args) {
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> n = new ArbolGeneral<Integer>(13);
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		b.agregarHijo(e);
		b.agregarHijo(f);
		c.agregarHijo(g);
		c.agregarHijo(h);
		c.agregarHijo(i);
		f.agregarHijo(j);
		f.agregarHijo(k);
		f.agregarHijo(l);
		g.agregarHijo(m);
		i.agregarHijo(n);

		a.printTree();

		SumaNodosNumeroImparDeHijos s = new SumaNodosNumeroImparDeHijos(a);

		System.out.println("La suma de los nodos hijos de un nodo con cantidad impar de hijos es de: " + s.resolver());
	}

}
