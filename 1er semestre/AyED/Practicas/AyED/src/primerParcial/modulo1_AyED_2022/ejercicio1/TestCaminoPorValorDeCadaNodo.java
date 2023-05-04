package primerParcial.modulo1_AyED_2022.ejercicio1;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class TestCaminoPorValorDeCadaNodo {

	public static void main(String[] args) {
		CaminoPorValorDeCadaNodo cam = new CaminoPorValorDeCadaNodo();
		ArbolGeneral<Dato> a = new ArbolGeneral<Dato>(new Dato('G', 1));
		ArbolGeneral<Dato> b = new ArbolGeneral<Dato>(new Dato('E', 3));
		ArbolGeneral<Dato> c = new ArbolGeneral<Dato>(new Dato('F', 2));
		ArbolGeneral<Dato> d = new ArbolGeneral<Dato>(new Dato('J', 2));
		ArbolGeneral<Dato> e = new ArbolGeneral<Dato>(new Dato('A', 7));
		ArbolGeneral<Dato> f = new ArbolGeneral<Dato>(new Dato('B', 9));
		ArbolGeneral<Dato> g = new ArbolGeneral<Dato>(new Dato('C', 6));
		ArbolGeneral<Dato> h = new ArbolGeneral<Dato>(new Dato('D', 10));
		ArbolGeneral<Dato> i = new ArbolGeneral<Dato>(new Dato('H', 6));
		ArbolGeneral<Dato> j = new ArbolGeneral<Dato>(new Dato('I', 10));
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		b.agregarHijo(e);
		b.agregarHijo(f);
		b.agregarHijo(g);
		c.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);

		a.printTree();
		ListaGenerica<ArbolGeneral<Dato>> l = cam.caminoPorValorDeCadaNodo(a);
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo().getDato().getLetra());
		}
	}

}
