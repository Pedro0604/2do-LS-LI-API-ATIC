package primerParcial.modulo1_AyED_2022.ejercicio2;

public class TestArbolBinarioPrincesaAccesible {

	public static void main(String[] args) {
		ArbolBinarioPrincesaAccesible<Personaje> a = new ArbolBinarioPrincesaAccesible<Personaje>(new Personaje("x"));
		ArbolBinarioPrincesaAccesible<Personaje> b = new ArbolBinarioPrincesaAccesible<Personaje>(
				new Personaje("Dragon"));
		ArbolBinarioPrincesaAccesible<Personaje> c = new ArbolBinarioPrincesaAccesible<Personaje>(new Personaje("z"));
		ArbolBinarioPrincesaAccesible<Personaje> d = new ArbolBinarioPrincesaAccesible<Personaje>(
				new Personaje("Princesa"));
		ArbolBinarioPrincesaAccesible<Personaje> e = new ArbolBinarioPrincesaAccesible<Personaje>(new Personaje("y"));
		ArbolBinarioPrincesaAccesible<Personaje> f = new ArbolBinarioPrincesaAccesible<Personaje>(new Personaje("w"));
		ArbolBinarioPrincesaAccesible<Personaje> g = new ArbolBinarioPrincesaAccesible<Personaje>(
				new Personaje("Princesa"));

		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		c.agregarHijoDerecho(f);
		f.agregarHijoIzquierdo(g);

		System.out.println(a.PrincesaAccesible());
	}

}
