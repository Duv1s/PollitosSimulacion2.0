package com.pollitosSimulation.logic.entity;

import java.util.List;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class EstadisticasMesa {
	int tiempo;
	int comensales;
	String plato;

	/**
	 * convierte un grupo de comensales en una tupla de estadísticas
	 *
	 * @param tiempo
	 * @param comensales
	 * @param listPlatos
	 */
	public EstadisticasMesa(int tiempo, int comensales, List<Plato> listPlatos) {
		this.tiempo = tiempo;
		this.comensales = comensales;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listPlatos.size(); i++) {
			sb.append(listPlatos.get(i).toString());
			if (i != listPlatos.size() - 1) {
				sb.append(",  ");
			}
		}
		plato = sb.toString();
	}

	// Métodos getters y setters ------
	/**
	 * @return Método que obtiene el valor de la propiedad tiempo.
	 */
	public int getTime() {
		return tiempo;
	}

	/**
	 * @param Método que asigna el valor de la propiedad tiempo.
	 */
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad comensales.
	 */
	public int getDiners() {
		return comensales;
	}

	/**
	 * @param Método que asigna el valor de la propiedad comensales.
	 */
	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad plato.
	 */
	public String getDishs() {
		return plato;
	}

	/**
	 * @param Método que asigna el valor de la propiedad plato.
	 */
	public void setPlato(String plato) {
		this.plato = plato;
	}

}
