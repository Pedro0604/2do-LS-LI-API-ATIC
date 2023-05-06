package primerParcial.ProgramacionIII_24_04_2023_Tema1;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Dato {
	private ListaGenerica<ArbolBinario<Integer>> l;
	private int cantPares;

	public Dato(ListaGenerica<ArbolBinario<Integer>> l, int cantPares) {
		super();
		this.l = l;
		this.cantPares = cantPares;
	}

	public ListaGenerica<ArbolBinario<Integer>> getL() {
		return l;
	}

	public void setL(ListaGenerica<ArbolBinario<Integer>> l) {
		this.l = l;
	}

	public int getCantPares() {
		return cantPares;
	}

	public void setCantPares(int cantPares) {
		this.cantPares = cantPares;
	}

	@Override
	public String toString() {
		return "Dato [l=" + l + ", cantPares=" + cantPares + "]";
	}
}
