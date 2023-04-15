package cinco;

public class Cinco {

	public static void main(String[] args) {
		//a)
		int[] arr = {0, -23, 123};
		Datos d = Return.returnDatos(arr);
		System.out.println(d.toString());
		//b
		int[] arr2 = {-1231, -1232, 8};
		d = new Datos();
		Parametro.parametroDatos(arr2, d);
		System.out.println(d.toString());
		//no se como hacer el c)
		int[] arr3 = {123, -2323, 123, 1456, 723, 74, 123, -1234, -563};
	}

}
