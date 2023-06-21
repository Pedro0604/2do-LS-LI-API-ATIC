package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {
	Grafo<String> mapaCiudades;

	public Mapa(Grafo<String> mc) {
		this.mapaCiudades = mc;
	}

	// Buscar ambas ciudades y devolver la posición de la ciudad de inicio o en caso
	// de que alguna de las dos no exista, -1
	private int buscarPosIni(String ciudad1, String ciudad2) {
		int posIni = -1;
		boolean encontreCiudad2 = false;
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		Vertice<String> v;
		vertices.comenzar();

		// Recorro la lista de vértices mientras no se termine y no haya encontrado
		// alguna de las dos ciudades
		while ((!vertices.fin()) && (posIni == -1 || !encontreCiudad2)) {
			v = vertices.proximo();
			if (v.dato().equals(ciudad1)) {
				posIni = v.getPosicion();
			} else {
				if (v.dato().equals(ciudad2)) {
					encontreCiudad2 = true;
				}
			}
		}

		// Si no encontré la ciudad2, devuelvo -1, así no se hace el DFS
		if (!encontreCiudad2) {
			posIni = -1;
		}
		return posIni;
	}

	// Devolver camino
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			int posIni = buscarPosIni(ciudad1, ciudad2);
			if (posIni != -1) {
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
				devolverCaminoDFS(posIni, ciudad2, camino, marca);
			}
		}
		return camino;
	}

	// DFS devolver camino
	private boolean devolverCaminoDFS(int pos, String ciudad2, ListaGenerica<String> camino, boolean[] marca) {
		boolean encontre = false;
		marca[pos] = true;
		Vertice<String> v = this.mapaCiudades.vertice(pos);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			encontre = true;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			Arista<String> arAct;
			Vertice<String> vAct;
			int posAct;
			while (!encontre && !ady.fin()) {
				arAct = ady.proximo();
				vAct = arAct.verticeDestino();
				posAct = vAct.getPosicion();
				if (!marca[posAct]) {
					encontre = devolverCaminoDFS(posAct, ciudad2, camino, marca);
				}
			}
		}

		if (!encontre) {
			camino.eliminarEn(camino.tamanio());
		}
		return encontre;
	}

	// Buscar ambas ciudades, marcar las ciudades exceptuadas y devolver la posición
	// de la ciudad de inicio o en caso de que alguna de las dos no exista, -1
	private int buscarPosIniYMarcarExceptuadas(String ciudad1, String ciudad2, boolean[] marca,
			ListaGenerica<String> ciudades) {
		int posIni = -1;
		boolean encontreCiudad2 = false;
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		Vertice<String> v;
		vertices.comenzar();

		// Recorro la lista de vértices mientras no se termine y no haya encontrado
		// alguna de las dos ciudades
		while ((!vertices.fin()) && (posIni == -1 || !encontreCiudad2)) {
			v = vertices.proximo();
			if (ciudades.incluye(v.dato())) {
				marca[v.getPosicion()] = true;
			}
			if (v.dato().equals(ciudad1)) {
				posIni = v.getPosicion();
			} else {
				if (v.dato().equals(ciudad2)) {
					encontreCiudad2 = true;
				}
			}
		}

		// Si no encontré la ciudad2, devuelvo -1, así no se hace el DFS
		if (!encontreCiudad2) {
			posIni = -1;
		}
		return posIni;
	}

	// Devolver camino exceptuando
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			int posIni = buscarPosIniYMarcarExceptuadas(ciudad1, ciudad2, marca, ciudades);
			if (posIni != -1) {
				devolverCaminoExceptuandoDFS(posIni, ciudad2, camino, marca);
			}
		}
		return camino;
	}

	// DFS devolver camino exceptuando
	private boolean devolverCaminoExceptuandoDFS(int pos, String ciudad2, ListaGenerica<String> camino,
			boolean[] marca) {
		boolean encontre = false;
		Vertice<String> v = this.mapaCiudades.vertice(pos);
		marca[pos] = true;
		camino.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			encontre = true;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			Arista<String> arista;
			Vertice<String> verticeProx;
			int posProx;
			ady.comenzar();
			while (!encontre && !ady.fin()) {
				arista = ady.proximo();
				verticeProx = arista.verticeDestino();
				posProx = verticeProx.getPosicion();
				if (!marca[posProx]) {
					encontre = devolverCaminoExceptuandoDFS(posProx, ciudad2, camino, marca);
				}
			}
		}

		if (!encontre) {
			camino.eliminarEn(camino.tamanio());
		}
		return encontre;
	}

	// Devolver camino más corto
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			int posIni = buscarPosIni(ciudad1, ciudad2);
			if (posIni != -1) {
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
				ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<String>();
				int dist = caminoMasCortoDFS(posIni, ciudad2, camino, caminoAct, Integer.MAX_VALUE, 0, marca);
				System.out.println("Distancia del camino más corto: " + dist);
			}
		}
		return camino;
	}

	// DFS devolver camino más corto
	private int caminoMasCortoDFS(int pos, String ciudad2, ListaGenerica<String> camino,
			ListaGenerica<String> caminoAct, int distMin, int distAct, boolean[] marca) {
		marca[pos] = true;
		Vertice<String> v = this.mapaCiudades.vertice(pos);
		caminoAct.agregarFinal(v.dato());

		if (v.dato().equals(ciudad2) && (distAct < distMin)) {
			camino.copiar(caminoAct);
			distMin = distAct;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			Arista<String> arista;
			Vertice<String> vProx;
			int posProx;
			ady.comenzar();
			while (!ady.fin()) {
				arista = ady.proximo();
				vProx = arista.verticeDestino();
				posProx = vProx.getPosicion();
				if (!marca[posProx]) {
					distMin = caminoMasCortoDFS(posProx, ciudad2, camino, caminoAct, distMin, distAct + arista.peso(),
							marca);
				}
			}
		}

		marca[pos] = false;
		caminoAct.eliminarEn(caminoAct.tamanio());

		return distMin;
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			int posIni = buscarPosIni(ciudad1, ciudad2);
			if (posIni != -1) {
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
				caminoSinCargarCombustibleDFS(posIni, ciudad2, camino, tanqueAuto, tanqueAuto, marca);
			}
		}
		return camino;
	}

	private boolean caminoSinCargarCombustibleDFS(int pos, String ciudad2, ListaGenerica<String> camino, int tanqueAuto,
			int tanqueAct, boolean[] marca) {
		boolean encontre = false;
		Vertice<String> v = this.mapaCiudades.vertice(pos);
		marca[pos] = true;
		camino.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			encontre = true;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			Arista<String> arista;
			Vertice<String> vProx;
			int posProx;
			int peso;
			ady.comenzar();
			while (!encontre && !ady.fin()) {
				arista = ady.proximo();
				peso = arista.peso();
				vProx = arista.verticeDestino();
				posProx = vProx.getPosicion();
				if ((!marca[posProx]) && (peso < tanqueAct)) {
					encontre = caminoSinCargarCombustibleDFS(posProx, ciudad2, camino, tanqueAuto, tanqueAct - peso,
							marca);
				}
			}
		}
		if (!encontre) {
			camino.eliminarEn(camino.tamanio());
		}

		return encontre;
	}

	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			int posIni = buscarPosIni(ciudad1, ciudad2);
			if (posIni != -1) {
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
				int cantCargas = caminoConMenorCargaDeCombustibleDFS(posIni, ciudad2, camino,
						new ListaEnlazadaGenerica<String>(), tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE, marca);
				System.out.println("Cantidad de cargas: " + cantCargas);
			}
		}
		return camino;
	}

	private int caminoConMenorCargaDeCombustibleDFS(int pos, String ciudad2, ListaGenerica<String> camino,
			ListaGenerica<String> caminoAct, int tanqueAuto, int tanqueAct, int cantCargas, int minCargas,
			boolean[] marca) {
		marca[pos] = true;
		Vertice<String> v = this.mapaCiudades.vertice(pos);
		caminoAct.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			camino.copiar(caminoAct);
			minCargas = cantCargas;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			Arista<String> arista;
			Vertice<String> vProx;
			int posProx;
			int peso;
			ady.comenzar();
			while (minCargas > 0 && !ady.fin()) {
				arista = ady.proximo();
				peso = arista.peso();
				vProx = arista.verticeDestino();
				posProx = vProx.getPosicion();
				if (!marca[posProx]) {
					if (peso < tanqueAct) {
						minCargas = caminoConMenorCargaDeCombustibleDFS(posProx, ciudad2, camino, caminoAct, tanqueAuto,
								tanqueAct - peso, cantCargas, minCargas, marca);
					} else {
						if (peso < tanqueAuto && cantCargas + 1 < minCargas) {
							minCargas = caminoConMenorCargaDeCombustibleDFS(posProx, ciudad2, camino, caminoAct,
									tanqueAuto, tanqueAuto - peso, cantCargas + 1, minCargas, marca);
						}
					}
				}
			}
		}

		marca[pos] = false;
		caminoAct.eliminarEn(caminoAct.tamanio());

		return minCargas;
	}
}
