package tp02.ejercicio1_3;

import java.util.Scanner;

import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		for (int i = 0; i <= 10; i++) {
			System.out.println("Ingrese un número: ");
			l.agregarFinal(s.nextInt());
		}
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
		s.close();
	}
}
