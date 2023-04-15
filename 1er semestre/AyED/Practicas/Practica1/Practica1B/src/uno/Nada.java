package uno;

public class Nada {
	public static void printNada(int a, int b) {
		if (a > b) {
            return;
        }
        System.out.println(a);
        printNada(a + 1, b);
	}
}
