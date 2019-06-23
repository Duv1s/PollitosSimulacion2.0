package com.pollitosSimulation.logic;

import java.util.ArrayList;
import java.util.List;

import com.pollitosSimulation.logic.entity.Table;
import com.pollitosSimulation.logic.entity.Waiter;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class RestaurantSimulation {
	private List<Waiter> listWaiter;
	private List<Table> listTables;
	private int maxDinerWorkDay;
	private int maxHourWorkDay;
	private int minDinerWorkDay;
	private int minHoursWorkDay;
	private final int timeToSimulate = 9000; //150 Horas
	private int actualSimulationTime = 0;

	/**
	 * constructor
	 * 
	 * @param waiterAmount    cantidad de meseros
	 * @param maxDinerWorkDay máximo de comensales en una jornada
	 * @param maxHourWorkDay  máximo de horas en una jornada
	 * @param minDinerWorkDay mínimo de comensales en una jornada
	 * @param minHoursWorkDay míninmo de horas en una jornada
	 * @param timeToSimulate  Tiempo a simular en minutos
	 * @param tables          cantidad de Mesas
	 */
	public RestaurantSimulation(int waiterAmount, int maxDinerWorkDay, int maxHourWorkDay, int minDinerWorkDay,
			int minHoursWorkDay, int timeToSimulate, int tables) {
		this.listWaiter = new ArrayList<>(waiterAmount);
		this.listTables = new ArrayList<>(tables);
		for (int i = 0; i < tables; i++)
			listTables.add(new Table());
		for (int i = 0; i < waiterAmount; i++)
			listWaiter.add(new Waiter(true, 2)); 
		this.maxDinerWorkDay = maxDinerWorkDay;
		this.maxHourWorkDay = maxHourWorkDay;
		this.minDinerWorkDay = minDinerWorkDay;
		this.minHoursWorkDay = minHoursWorkDay;
	}

	/**
	 * Da inicio a la simulación Mientras el tiempo transcurrido sea menor al de la
	 * simulación va a estar recorriendo mesas atendiendo comensales calculando el
	 * tiempo que tardan y sumandolo al tiempo transcurrido
	 */
	public void start() {
		boolean continu = true;
		while (continu) {
			for (Table table : listTables) {
				if (actualSimulationTime <= timeToSimulate) {
					table.addGroup();
					actualSimulationTime += table.getLastTime();
					continue;
				}
				continu = false;
			}
		}
	}

	/**
	 * Obtiene la cantidad total de ventas de un determinado plato
	 * 
	 * @param name nombre del plato
	 * @return cantidad de ventas
	 */
	public int getTotalAmountDishOf(String name) {
		int amount = 0;
		for (Table table : listTables) {
			amount += table.getTotalAmountDishOf(name);
		}
		return amount;
	}

	/**
	 * obtiene el total de ganancias de un determinado plato
	 * 
	 * @param name nombre del plato
	 * @return total de ganancias
	 */
	public double getTotalGainDishOf(String name) {
		double amount = 0;
		for (Table table : listTables) {
			amount += table.getTotalGainDishOf(name);
		}
		return amount;
	}

	/**
	 * obtiene el total de clientes atendidos durante el tiempo de la simulación
	 * 
	 * @return total de clientes atendidos
	 */
	public int getTotalDiners() {
		int amount = 0;
		for (Table table : listTables) {
			amount += table.getTotalDiners();
		}
		return amount;
	}

	/**
	 * imprime las estadisticas de la simulación
	 */
	public void printStats() {
		System.out.println("Tiempo total de simulación: " + actualSimulationTime);
		System.out.println("Total de clientes: " + getTotalDiners());
		System.out.println(DishUtils.DISH_NAME_1 + " -   Ventas: " + getTotalAmountDishOf(DishUtils.DISH_NAME_1)
				+ ",   Ganancias: " + getTotalGainDishOf(DishUtils.DISH_NAME_1));
		System.out.println(DishUtils.DISH_NAME_2 + " -   Ventas: " + getTotalAmountDishOf(DishUtils.DISH_NAME_2)
				+ ",   Ganancias: " + getTotalGainDishOf(DishUtils.DISH_NAME_2));
		System.out.println(DishUtils.DISH_NAME_3 + " -   Ventas: " + getTotalAmountDishOf(DishUtils.DISH_NAME_3)
				+ ",   Ganancias: " + getTotalGainDishOf(DishUtils.DISH_NAME_3));
		System.out.println(DishUtils.DISH_NAME_4 + " -   Ventas: " + getTotalAmountDishOf(DishUtils.DISH_NAME_4)
				+ ",   Ganancias: " + getTotalGainDishOf(DishUtils.DISH_NAME_4));
	}

	/**
	 * Imprime la información de las mesas
	 */
	public void printTableStats() {
		for (int i = 0; i < listTables.size(); i++) {
			System.out.println("=================MESA " + (i + 1) + "================");
			System.out.println(listTables.get(i).toString());
			System.out.println("===============FIN MESA " + (i + 1) + "==============");
		}
	}

	public List<Table> getListTables() {
		return listTables;
	}

	public Table getTable(int tableNumber) {
		return listTables.get(tableNumber - 1);
	}

	public int getActualSimulationTime() {
		return actualSimulationTime;
	}

	// Métodos getters y setters ------

	/**
	 * @return Método que obtiene el valor de la propiedad listWaiter.
	 */
	public List<Waiter> getListWaiter() {
		return listWaiter;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listWaiter.
	 */
	public void setListWaiter(List<Waiter> listWaiter) {
		this.listWaiter = listWaiter;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad maxDinerWorkDay.
	 */
	public int getMaxDinerWorkDay() {
		return maxDinerWorkDay;
	}

	/**
	 * @param Método que asigna el valor de la propiedad maxDinerWorkDay.
	 */
	public void setMaxDinerWorkDay(int maxDinerWorkDay) {
		this.maxDinerWorkDay = maxDinerWorkDay;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad maxHourWorkDay.
	 */
	public int getMaxHourWorkDay() {
		return maxHourWorkDay;
	}

	/**
	 * @param Método que asigna el valor de la propiedad maxHourWorkDay.
	 */
	public void setMaxHourWorkDay(int maxHourWorkDay) {
		this.maxHourWorkDay = maxHourWorkDay;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad minDinerWorkDay.
	 */
	public int getMinDinerWorkDay() {
		return minDinerWorkDay;
	}

	/**
	 * @param Método que asigna el valor de la propiedad minDinerWorkDay.
	 */
	public void setMinDinerWorkDay(int minDinerWorkDay) {
		this.minDinerWorkDay = minDinerWorkDay;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad minHoursWorkDay.
	 */
	public int getMinHoursWorkDay() {
		return minHoursWorkDay;
	}

	/**
	 * @param Método que asigna el valor de la propiedad minHoursWorkDay.
	 */
	public void setMinHoursWorkDay(int minHoursWorkDay) {
		this.minHoursWorkDay = minHoursWorkDay;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad timeToSimulate.
	 */
	public int getTimeToSimulate() {
		return timeToSimulate;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listTables.
	 */
	public void setListTables(List<Table> listTables) {
		this.listTables = listTables;
	}

	/**
	 * @param Método que asigna el valor de la propiedad actualSimulationTime.
	 */
	public void setActualSimulationTime(int actualSimulationTime) {
		this.actualSimulationTime = actualSimulationTime;
	}

}
