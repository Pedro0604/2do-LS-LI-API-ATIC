package primerParcial.modulo1_AyED_2022.ejercicio3;

public class TestArbolGeneralCreciente {

	public static void main(String[] args) {
		ArbolGeneralCreciente<Integer> a = new ArbolGeneralCreciente<Integer>(1);
		ArbolGeneralCreciente<Integer> b = new ArbolGeneralCreciente<Integer>(2);
		ArbolGeneralCreciente<Integer> c = new ArbolGeneralCreciente<Integer>(3);
		ArbolGeneralCreciente<Integer> d = new ArbolGeneralCreciente<Integer>(4);
		ArbolGeneralCreciente<Integer> e = new ArbolGeneralCreciente<Integer>(5);
		ArbolGeneralCreciente<Integer> f = new ArbolGeneralCreciente<Integer>(6);
		ArbolGeneralCreciente<Integer> g = new ArbolGeneralCreciente<Integer>(7);
		ArbolGeneralCreciente<Integer> h = new ArbolGeneralCreciente<Integer>(8);
		ArbolGeneralCreciente<Integer> i = new ArbolGeneralCreciente<Integer>(9);
		ArbolGeneralCreciente<Integer> j = new ArbolGeneralCreciente<Integer>(10);
		ArbolGeneralCreciente<Integer> k = new ArbolGeneralCreciente<Integer>(11);
		ArbolGeneralCreciente<Integer> l = new ArbolGeneralCreciente<Integer>(12);
		ArbolGeneralCreciente<Integer> m = new ArbolGeneralCreciente<Integer>(13);
		ArbolGeneralCreciente<Integer> n = new ArbolGeneralCreciente<Integer>(14);
		ArbolGeneralCreciente<Integer> ñ = new ArbolGeneralCreciente<Integer>(15);
		a.agregarHijo(b);
		a.agregarHijo(c);
		b.agregarHijo(d);
		c.agregarHijo(e);
		c.agregarHijo(f);
		d.agregarHijo(g);
		d.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);
		h.agregarHijo(k);
		i.agregarHijo(l);
		i.agregarHijo(m);
		j.agregarHijo(n);
		j.agregarHijo(ñ);
		System.out.println("Arbol original: ");
		a.printTree();
		System.out.println();
		if (a.arbolGeneralCreciente() != null) {
			System.out.println("Arbol creciente: ");
			a.arbolGeneralCreciente().printTree();
		} else {
			System.out.println("No es creciente");
		}
	}

}
