package com.pollitosSimulation.logic.entity;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class Mesero {

	private boolean disponible;
	private int tiempoDisponible;

	/**
	 * crea un mesero
	 * 
	 * @param disponible   disponibilidad
	 * @param tiempoDisponible tiempo de atención
	 */
	public Mesero(boolean disponible, int tiempoDisponible) {
		this.disponible = disponible;
		this.tiempoDisponible = tiempoDisponible;
	}

	// Métodos getters y setters ------

	/**
	 * @return Método que obtiene el valor de la propiedad isDisponible.
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * @param Método que asigna el valor de la propiedad isDisponible.
	 */
	public void setDisponible(boolean isAvailable) {
		this.disponible = isAvailable;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad tiempoDisponible.
	 */
	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	/**
	 * @param Método que asigna el valor de la propiedad tiempoDisponible.
	 */
	public void setTiempoDisponible(int tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

}
