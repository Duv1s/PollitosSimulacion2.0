package com.pollitosSimulation.logic.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class Table {
	private int currentDiners;
	private boolean isAvailable;
	private List<DinerGroup> listDinerGroups;
	private int timeAvailable;

	/**
	 * crea una nueva mesa
	 */
	public Table() {
		this.currentDiners = 0;
		this.isAvailable = true;
		this.listDinerGroups = new ArrayList<>();
	}

	/**
	 * devuelve el ultimo plato solicitado en esta mesa
	 * 
	 * @return último plato solicitado
	 */
	private Dish getLastDish() {
		if (listDinerGroups.isEmpty()) {
			return new Dish("Random Dish", 0, 0, 0);
		}
		return listDinerGroups.get(listDinerGroups.size() - 1).getLastDish();
	}

	/**
	 * agrega un nuevo grupo de comensales a esta mesa
	 */
	public void addGroup() {
		listDinerGroups.add(new DinerGroup(getLastDish()));
	}

	/**
	 * devuelve el tiempo que tardo el ultimo grupo de comensales en consumir sus
	 * alimentos
	 * 
	 * @return tiempo que gasto el ultimo grupo
	 */
	public int getLastTime() {
		return listDinerGroups.get(listDinerGroups.size() - 1).getTime();
	}

	/**
	 * devuelve el tiempo que ha estado en operación esta mesa
	 * 
	 * @return tiempo total de servicio
	 */
	public int getTotalTime() {
		int time = 0;
		for (DinerGroup dg : listDinerGroups) {
			time += dg.getTime();
		}
		return time;
	}

	/**
	 * devuelve el total de consumos de un determinado plato
	 * 
	 * @param name nombre del plato
	 * @return total de consumos
	 */
	public int getTotalAmountDishOf(String name) {
		int amount = 0;
		for (DinerGroup dg : listDinerGroups) {
			for (Dish dish : dg.getDishs()) {
				if (dish.getName().equals(name)) {
					amount++;
				}
			}
		}
		return amount;
	}

	/**
	 * devuelve el total de ganancias que se generaron con un determinado plato
	 * 
	 * @param name nombre del plato
	 * @return total de ganancias
	 */
	public double getTotalGainDishOf(String name) {
		int amount = 0;
		for (DinerGroup dg : listDinerGroups) {
			for (Dish dish : dg.getDishs()) {
				if (dish.getName().equals(name)) {
					amount += dish.getGain();
				}
			}
		}
		return amount;
	}

	/**
	 * devuelve el total de comensales que han pasado por esta mesa
	 * 
	 * @return total de comensales
	 */
	public int getTotalDiners() {
		int amount = 0;
		for (DinerGroup dg : listDinerGroups) {
			amount += dg.getDinerAmount();
		}
		return amount;
	}

	/**
	 * muestra el tiempo de atención, el total de clientes, y la informacion de los
	 * clientes y platos
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tiempo Total de Atención: ").append(getTotalTime()).append("\n");
		builder.append("Total de Clientes: ").append(getTotalDiners()).append("\n");
		builder.append("===========Clientes============").append("\n");
		for (DinerGroup dg : listDinerGroups) {
			builder.append(dg.toString()).append("\n");
		}
		return builder.toString();
	}

	// Métodos getters y setters ------
	/**
	 * @return Método que obtiene el valor de la propiedad listDinerGroups.
	 */
	public List<DinerGroup> getListDish() {
		return listDinerGroups;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listDinerGroups.
	 */
	public void setListDish(List<DinerGroup> listDish) {
		this.listDinerGroups = listDish;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad currentDiners.
	 */
	public int getCurrentDiners() {
		return currentDiners;
	}

	/**
	 * @param Método que asigna el valor de la propiedad currentDiners.
	 */
	public void setCurrentDiners(int currentDiners) {
		this.currentDiners = currentDiners;
	}

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
