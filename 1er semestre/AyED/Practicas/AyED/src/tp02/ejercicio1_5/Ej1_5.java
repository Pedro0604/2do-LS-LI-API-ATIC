package tp02.ejercicio1_5;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Ej1_5 {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		for (int i = 0; i < 10; i++) {
			l.agregarFinal(i * 34 / 3);
		}
		l.comenzar();
		System.out.println("Normal: ");
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
		System.out.println("Inverso: ");
		l.comenzar();
		imprimirRecursivoInverso(l);
	}

	public static void imprimirRecursivoInverso(ListaDeEnterosEnlazada l) {
		if (!l.fin()) {
			int sig = l.proximo();
			imprimirRecursivoInverso(l);
			System.out.println(sig);
		}
	}
}
