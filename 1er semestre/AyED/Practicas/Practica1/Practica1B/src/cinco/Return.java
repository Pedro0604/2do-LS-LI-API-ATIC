package cinco;

public class Return {
	public static Datos returnDatos(int[] arr){
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
		return new Datos(min, max, prom);
	}
}
