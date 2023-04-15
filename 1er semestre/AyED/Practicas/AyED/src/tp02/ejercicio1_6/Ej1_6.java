package tp02.ejercicio1_6;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Ej1_6 {

	public static void main(String[] args) {
		Ej1_6 f = new Ej1_6();
		ListaDeEnterosEnlazada l = f.calcularSucesion(83748);
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
	}

	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		l.agregarFinal(n);
		while (n != 1) {
			n = n % 2 == 0 ? n / 2 : n * 3 + 1;
			l.agregarFinal(n);
		}
		return l;
	}
}
