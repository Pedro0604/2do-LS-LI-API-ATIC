package cinco;

public class Parametro {
	public static void parametroDatos(int[] arr, Datos d) {
		int min=9999, max = -9999, suma=0, cant=arr.length;
		double prom = 0.0;
		for (int n: arr) {
			suma+=n;
			if(n<min) {
				min=n;
			}
			if(n>max) {
				max=n;
			}
		}
		prom = (double)suma / cant;
		d.setMin(min);
		d.setMax(max);
		d.setProm(prom);
	}
}
