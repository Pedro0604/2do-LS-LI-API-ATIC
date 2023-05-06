package primerParcial.ProgramacionIII_24_04_2023_Tema2;

import tp02.ejercicio2.ListaGenerica;

public class Dato {
	private ListaGenerica<Integer> l;
	private int cantImpares;

	public Dato(ListaGenerica<Integer> l, int cantImpares) {
		super();
		this.l = l;
		this.cantImpares = cantImpares;
	}

	public ListaGenerica<Integer> getL() {
		return l;
	}

	public void setL(ListaGenerica<Integer> l) {
		this.l = l;
	}

	public int getCantImpares() {
		return cantImpares;
	}

	public void setCantPImpares(int cantImpares) {
		this.cantImpares = cantImpares;
	}

	@Override
	public String toString() {
		return "Dato [l=" + l + ", cantImpares=" + cantImpares + "]";
	}
}
