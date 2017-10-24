package Tablero;

public class Mapa {

	/** Matriz con todas las casillas del mapa. */
	private Sala[][] Casillas;
	
	/**
	 * Crea un nuevo mapa utilizando los datos pasados por parámetros.
	 *
	 * @param alto Numero de filas de la matriz Casillas
	 * @param ancho Numero de columnas de la matriz Casillas
	 */
	public Mapa (int alto, int ancho) {
		Casillas = new Sala[alto][ancho];
	}
	
	/**
	 * Crea por defecto todas las salas del mapa.
	 */
	public void MapaAbierto () {
		for (int i = 0; i < Casillas.length; i++) {
			for (int j = 0; j < Casillas[i].length; j++) {
				Casillas[i][j] = new Sala ();
			}
		}
	}
	
	/**
	 * Crea las paredes externas del mapa.
	 */
	public void ParedesExteriores () {
		MapaAbierto();
		int j;
		
		for (int i = 0; i < Casillas[0].length; i++) 	//Paredes norte
			Casillas[0][i].setNorte(false);
		j = Casillas.length - 1;
		for (int i = 0; i < Casillas[j].length; i++) 	//Paredes sur
			Casillas[j][i].setSur(false);
		for (int i = 0; i < Casillas.length; i++) 		//Paredes este
			Casillas[i][0].setEste(false);
		j = Casillas[0].length - 1;
		for (int i = 0; i < Casillas.length; i++) 		//Paredes oeste
			Casillas[i][j].setOeste(false);
	}
	
	public static void main (String args[]) {
		
	}
}
