package tp04.ejercicio5;

import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio5 {

	public static void main(String[] args) {
		AreaEmpresa arEmp = new AreaEmpresa("Hola", 1);
		ArbolGeneral<AreaEmpresa> a = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 2);
		ArbolGeneral<AreaEmpresa> b = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 3);
		ArbolGeneral<AreaEmpresa> c = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 4);
		ArbolGeneral<AreaEmpresa> d = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 5);
		ArbolGeneral<AreaEmpresa> e = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 6);
		ArbolGeneral<AreaEmpresa> f = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 7);
		ArbolGeneral<AreaEmpresa> g = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 8);
		ArbolGeneral<AreaEmpresa> h = new ArbolGeneral<AreaEmpresa>(arEmp);
		arEmp = new AreaEmpresa("Hola", 9);
		ArbolGeneral<AreaEmpresa> i = new ArbolGeneral<AreaEmpresa>(arEmp);
		f.agregarHijo(g);
		e.agregarHijo(f);
		d.agregarHijo(h);
		c.agregarHijo(d);
		c.agregarHijo(e);
		b.agregarHijo(i);
		a.agregarHijo(b);
		a.agregarHijo(c);
		AnalizadorArbol analizador = new AnalizadorArbol();
		System.out.println(analizador.devolverMaximoPromedio(a));
	}

}
