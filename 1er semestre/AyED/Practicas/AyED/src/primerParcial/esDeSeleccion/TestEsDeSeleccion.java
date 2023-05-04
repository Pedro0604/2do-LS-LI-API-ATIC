package primerParcial.esDeSeleccion;

import tp04.ejercicio1.ArbolGeneral;

public class TestEsDeSeleccion {

	public static void main(String[] args) {
		Parcial p = new Parcial();

		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(42);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(80);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(54);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(42);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(90);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(102);
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(80);
		ArbolGeneral<Integer> n = new ArbolGeneral<Integer>(42);
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		b.agregarHijo(e);
		b.agregarHijo(f);
		c.agregarHijo(g);
		c.agregarHijo(h);
		c.agregarHijo(i);
		d.agregarHijo(j);
		f.agregarHijo(k);
		f.agregarHijo(l);
		f.agregarHijo(m);
		j.agregarHijo(n);
		a.printTree();
		System.out.println(p.esDeSeleccion(a));
	}

}
