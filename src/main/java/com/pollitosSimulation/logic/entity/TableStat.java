package com.pollitosSimulation.logic.entity;

import java.util.List;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class TableStat {
	int time;
	int diners;
	String dishs;

	/**
	 * convierte un grupo de comensales en una tupla de estadísticas
	 * 
	 * @param time
	 * @param diners
	 * @param listDish
	 */
	public TableStat(int time, int diners, List<Dish> listDish) {
		this.time = time;
		this.diners = diners;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listDish.size(); i++) {
			sb.append(listDish.get(i).toString());
			if (i != listDish.size() - 1) {
				sb.append(",  ");
			}
		}
		dishs = sb.toString();
	}

	// Métodos getters y setters ------
	/**
	 * @return Método que obtiene el valor de la propiedad time.
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param Método que asigna el valor de la propiedad time.
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad diners.
	 */
	public int getDiners() {
		return diners;
	}

	/**
	 * @param Método que asigna el valor de la propiedad diners.
	 */
	public void setDiners(int diners) {
		this.diners = diners;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad dishs.
	 */
	public String getDishs() {
		return dishs;
	}

	/**
	 * @param Método que asigna el valor de la propiedad dishs.
	 */
	public void setDishs(String dishs) {
		this.dishs = dishs;
	}

}
