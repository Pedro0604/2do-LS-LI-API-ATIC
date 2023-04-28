package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		int max = -1;
		if (!arbol.esVacio()) {
			int cantNodosNivel = 0;
			int sumaTardanzaNivel = 0;
			ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
			ArbolGeneral<AreaEmpresa> aux;
			ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos;
			cola.encolar(arbol);
			cola.encolar(null);
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux != null) {
					cantNodosNivel++;
					sumaTardanzaNivel += aux.getDato().getTardanza();
					hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				} else {
					max = Math.max(max, sumaTardanzaNivel / cantNodosNivel);
					if (!cola.esVacia()) {
						cantNodosNivel = 0;
						sumaTardanzaNivel = 0;
						cola.encolar(null);
					}
				}
			}
		}
		return max;
	}
}
