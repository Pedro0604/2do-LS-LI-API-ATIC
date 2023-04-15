package cinco;

public class Datos {
	private int min, max;
	private double prom;

	public Datos() {

	}

	public Datos(int min, int max, double prom) {
		this.min = min;
		this.max = max;
		this.prom = prom;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public double getProm() {
		return prom;
	}

	public void setProm(double prom) {
		this.prom = prom;
	}

	@Override
	public String toString() {
		return "Datos [min=" + min + ", max=" + max + ", prom=" + prom + "]";
	}

}
