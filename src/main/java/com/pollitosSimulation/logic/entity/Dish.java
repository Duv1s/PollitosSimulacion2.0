package com.pollitosSimulation.logic.entity;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class Dish {
	private String name;
	private int calification;
	private int gainPercentage;
	private double gain;
	private int price;

	/**
	 * crea un plato con los parametros ingresados
	 * 
	 * @param name           Nombre del plato
	 * @param calification   Calificación del plato
	 * @param gainPercentage Porcentaje de ganancias del plato
	 * @param price          precio del plato
	 */
	public Dish(String name, int calification, int gainPercentage, int price) {
		this.name = name;
		this.calification = calification;
		this.gainPercentage = gainPercentage;
		this.gain = (price * gainPercentage) / 100;
		this.price = price;
	}

	/**
	 * se sobreescribe el metodo equals para comparar los platos por el nombre
	 * 
	 * @param obj objeto a comparar
	 * @return true si tienen el mismo nombre, false en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Dish) obj).name);
	}

	/**
	 * muestra el nombre del plato y entre parentesis la calificación
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return name + " (" + calification + ")";
	}

	// Métodos getters y setters ------

	/**
	 * @return Método que obtiene el valor de la propiedad name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param Método que asigna el valor de la propiedad name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad calification.
	 */
	public int getCalification() {
		return calification;
	}

	/**
	 * @param Método que asigna el valor de la propiedad calification.
	 */
	public void setCalification(int calification) {
		this.calification = calification;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad gainPercentage.
	 */
	public int getGainPercentage() {
		return gainPercentage;
	}

	/**
	 * @param Método que asigna el valor de la propiedad gainPercentage.
	 */
	public void setGainPercentage(int gainPercentage) {
		this.gainPercentage = gainPercentage;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad gain.
	 */
	public double getGain() {
		return gain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad gain.
	 */
	public void setGain(double gain) {
		this.gain = gain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad price.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param Método que asigna el valor de la propiedad price.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}
