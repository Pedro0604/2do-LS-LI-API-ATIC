package primerParcial.modulo1_AyED_2022.ejercicio1;

public class Dato {
	private char letra;
	private int valor;

	public Dato() {
	}

	public Dato(char letra, int valor) {
		super();
		this.letra = letra;
		this.valor = valor;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "[Letra: " + this.getLetra() + " - Valor: " + this.getValor() + "]";
	}

}
