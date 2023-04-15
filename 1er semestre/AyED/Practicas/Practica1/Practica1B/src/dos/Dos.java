package dos;
import java.util.Scanner;
public class Dos {
	public static int[] nuevoArreglo(int n) {
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i]= n*(i+1);
		}
		return arr;
	}
	
	public static void main (String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese el tamaño del arreglo: ");
		int [] arr = nuevoArreglo(s.nextInt());
		for (int el: arr) {
			System.out.println(el);
		}
	}
}
