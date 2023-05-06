package primerParcial.modulo1_AyED_2022.ejercicio5;

import tp04.ejercicio1.ArbolGeneral;

public class TestCaminosPares {

	public static void main(String[] args) {
		ArbolGeneral<Character> a = new ArbolGeneral<Character>('A');
		ArbolGeneral<Character> b = new ArbolGeneral<Character>('B');
		ArbolGeneral<Character> c = new ArbolGeneral<Character>('C');
		ArbolGeneral<Character> d = new ArbolGeneral<Character>('D');
		ArbolGeneral<Character> e = new ArbolGeneral<Character>('E');
		ArbolGeneral<Character> f = new ArbolGeneral<Character>('F');
		ArbolGeneral<Character> g = new ArbolGeneral<Character>('G');
		ArbolGeneral<Character> h = new ArbolGeneral<Character>('H');
		ArbolGeneral<Character> i = new ArbolGeneral<Character>('I');

		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		b.agregarHijo(e);
		c.agregarHijo(f);
		c.agregarHijo(g);
		f.agregarHijo(h);
		f.agregarHijo(i);

		a.printTree();

		System.out.println(CaminosPares.caminosPares(a));
	}

}
