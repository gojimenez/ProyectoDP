package Armas;

public class Arma implements Comparable <Arma> {

	/** Nombre del arma. */
	private String nombre;
	
	/** Poder del arma. */
	private Integer poder;		//Inicializado por defecto a 0
	
	/**
	 * Método constructor por defecto de Arma
	 */
	public Arma () {
		nombre = "";
		poder = 0;
	}
	
	/**
	 * Crea un nuevo arma a partir de los datos pasados por parámetro.
	 * 
	 * @param nombre Nombre del arma
	 * @param poder Poder del arma
	 */
	public Arma (String nombre, Integer poder) {
		this.nombre = nombre;
		this.poder = poder;
	}

	/**
	 * Devuelve el valor del nombre
	 * 
	 * @return nombre del arma
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el valor del nombre por el pasado por parámetro.
	 * 
	 * @param nombre Nuevo nombre del arma
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el valor del poder.
	 * 
	 * @return poder del arma
	 */
	public Integer getPoder() {
		return poder;
	}
	
	/**
	 * Cambia el valor del poder por el pasado por parámetro.
	 * 
	 * @param poder Nuevo poder del arma
	 */
	public void setPoder(Integer poder) {
		this.poder = poder;
	}
	
	/** 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo (Arma A) {
		if (this == A)
			return 0;
		return (this.getPoder().compareTo(A.getPoder()));
	}
}
