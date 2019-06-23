package com.pollitosSimulation.logic.entity;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class Waiter {

	private boolean isAvailable;
	private int timeAvailable;

	/**
	 * crea un mesero
	 * 
	 * @param isAvailable   disponibilidad
	 * @param timeAvailable tiempo de atención
	 */
	public Waiter(boolean isAvailable, int timeAvailable) {
		this.isAvailable = isAvailable;
		this.timeAvailable = timeAvailable;
	}

	// Métodos getters y setters ------

	/**
	 * @return Método que obtiene el valor de la propiedad isAvailable.
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param Método que asigna el valor de la propiedad isAvailable.
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad timeAvailable.
	 */
	public int getTimeAvailable() {
		return timeAvailable;
	}

	/**
	 * @param Método que asigna el valor de la propiedad timeAvailable.
	 */
	public void setTimeAvailable(int timeAvailable) {
		this.timeAvailable = timeAvailable;
	}

}
