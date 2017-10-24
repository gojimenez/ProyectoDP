package Tablero;

import Armas.Arma;
import Estructuras.List;
import Estructuras.Stack;
import Personajes.Personaje;

public class Sala {
	
	/** 
	 * Atributos que representan las cuatro paredes de la sala,
	 * true si no hay pared y false en caso contrario. 
	 */
	private boolean norte, sur, este, oeste;	//Inicializado por defecto a true.
	
	/** Representa si el Daily Planet está o no en esta casilla. */
	private boolean Dplanet;		//Inicializado por defecto a false.
	
	/** Representa si el Hombre Puerta está o no en esta casilla. */
	private boolean Hpuerta;		//Inicializado por defecto a false.
	
	/** Lista de armas de la casilla. */
	private List <Arma> armas;
	
	/** Cola de personajes que se encuentran en la casilla. */
	private Stack <Personaje> personajes;
	
	
	/**
	 * Método constructor por defecto de Sala.
	 */
	public Sala () {
		norte = true;
		sur = true;
		este = true;
		oeste = true;
		Dplanet = false;
		Hpuerta = false;
		armas = null;
		personajes = null;
	}
	
	/**
	 * Crea una nueva Sala a partir de los datos pasados por parámetro.
	 *
	 * @param norte Pared norte de la Sala
	 * @param sur Pared sur de la Sala
	 * @param este Pared este de la Sala
	 * @param oeste Pared oeste de la Sala
	 * @param Dplanet Valor de Dplanet
	 */
	public Sala (boolean norte, boolean sur, boolean este, boolean oeste, boolean Dplanet, boolean Hpuerta) {
		this.norte = norte;
		this.sur = sur;
		this.este = este;
		this.oeste = oeste;
		this.Dplanet = Dplanet;
		this.Hpuerta = Hpuerta;
		armas = new List <Arma> ();
		personajes = new Stack <Personaje> ();
	}

	/**
	 * Devuelve el valor de la pared norte
	 * 
	 * @return true si se puede pasar, false si no se puede pasar (hay pared)
	 */
	public boolean isNorte() {
		return norte;
	}

	/**
	 * Cambia el valor de la pared norte por el pasado por parámetro
	 * 
	 * @param norte Nuevo valor de la pared norte
	 */
	public void setNorte(boolean norte) {
		this.norte = norte;
	}

	/**
	 * Devuelve el valor de la pared sur
	 * 
	 * @return true si se puede pasar, false si no se puede pasar (hay pared)
	 */
	public boolean isSur() {
		return sur;
	}

	/**
	 * Cambia el valor de la pared sur por el pasado por parámetro
	 * 
	 * @param sur Nuevo valor de la pared sur
	 */
	public void setSur(boolean sur) {
		this.sur = sur;
	}

	/**
	 * Devuelve el valor de la pared este
	 * 
	 * @return true si se puede pasar, false si no se puede pasar (hay pared)
	 */
	public boolean isEste() {
		return este;
	}

	/**
	 * Cambia el valor de la pared este por el pasado por parámetro
	 * 
	 * @param este Nuevo valor de la pared este
	 */
	public void setEste(boolean este) {
		this.este = este;
	}

	/**
	 * Devuelve el valor de la pared oeste
	 * 
	 * @return true si se puede pasar, false si no se puede pasar (hay pared)
	 */
	public boolean isOeste() {
		return oeste;
	}

	/**
	 * Cambia el valor de la pared oeste por el pasado por parámetro
	 * 
	 * @param oeste Nuevo valor de la pared oeste
	 */
	public void setOeste(boolean oeste) {
		this.oeste = oeste;
	}

	/**
	 * Devuelve si el Daily Planet está en esta sala o no
	 * 
	 * @return true si está el Daily Planet, false en caso contrario
	 */
	public boolean isDplanet() {
		return Dplanet;
	}

	/**
	 * Cambia la presencia del Daily Planet
	 * 
	 * @param dplanet Nuevo valor de Dplanet
	 */
	public void setDplanet(boolean dplanet) {
		Dplanet = dplanet;
	}
	
	/**
	 * Devuelve si el Hombre Puerta está en esta sala o no
	 * 
	 * @return true si está el Hombre Puerta, false en caso contrario
	 */
	public boolean isHpuerta() {
		return Hpuerta;
	}

	/**
	 * Cambia la presencia del Hombre Puerta
	 * 
	 * @param hpuerta Nuevo valor de Hpuerta
	 */
	public void setHpuerta(boolean hpuerta) {
		Hpuerta = hpuerta;
	}

	/**
	 * Devuelve la lista de armas
	 * 
	 * @return La lista de armas
	 */
	public List<Arma> getArmas() {
		return armas;
	}

	/**
	 * Iguala la lista de armas a la pasada por parámetro
	 * 
	 * @param armas Nueva lista de armas
	 */
	public void setArmas(List<Arma> armas) {
		this.armas = armas;
	}

	/**
	 * Devuelve la cola de personajes
	 * 
	 * @return La cola de personajes
	 */
	public Stack<Personaje> getPersonajes() {
		return personajes;
	}

	/**
	 * Iguala la cola de personajes a la pasada por parámetro
	 * 
	 * @param personajes Nueva cola de personajes
	 */
	public void setPersonajes(Stack<Personaje> personajes) {
		this.personajes = personajes;
	}	
}