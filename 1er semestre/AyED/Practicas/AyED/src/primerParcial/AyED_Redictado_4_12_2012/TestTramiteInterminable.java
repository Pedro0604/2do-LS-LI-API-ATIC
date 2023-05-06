package primerParcial.AyED_Redictado_4_12_2012;

import tp04.ejercicio1.ArbolGeneral;

public class TestTramiteInterminable {

	public static void main(String[] args) {
		ArbolGeneral<String> a = new ArbolGeneral<String>("Silvia");
		ArbolGeneral<String> b = new ArbolGeneral<String>("Diana");
		ArbolGeneral<String> c = new ArbolGeneral<String>("Werner");
		ArbolGeneral<String> d = new ArbolGeneral<String>("Vicente");
		ArbolGeneral<String> e = new ArbolGeneral<String>("Nestor");
		ArbolGeneral<String> f = new ArbolGeneral<String>("Ernesto");
		ArbolGeneral<String> g = new ArbolGeneral<String>("Lorena");
		ArbolGeneral<String> h = new ArbolGeneral<String>("Liliana");
		ArbolGeneral<String> i = new ArbolGeneral<String>("Pablo");
		ArbolGeneral<String> j = new ArbolGeneral<String>("Julio");
		ArbolGeneral<String> k = new ArbolGeneral<String>("QueEncajonaTodo");
		ArbolGeneral<String> l = new ArbolGeneral<String>("QueEncajonaTodo");
		ArbolGeneral<String> m = new ArbolGeneral<String>("QueEncajonaTodo");
		ArbolGeneral<String> n = new ArbolGeneral<String>("QueEncajonaTodo");
		ArbolGeneral<String> ñ = new ArbolGeneral<String>("QueEncajonaTodo");

		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		b.agregarHijo(e);
		c.agregarHijo(f);
		c.agregarHijo(g);
		f.agregarHijo(h);
		f.agregarHijo(i);
		h.agregarHijo(j);
		i.agregarHijo(k);
		g.agregarHijo(l);
		j.agregarHijo(m);
		d.agregarHijo(n);
		e.agregarHijo(ñ);

		a.printTree();

		System.out.println(TramiteInterminable.tramiteInterminable(a));
	}

}
