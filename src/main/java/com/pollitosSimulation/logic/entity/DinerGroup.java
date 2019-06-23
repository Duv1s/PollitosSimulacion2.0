package com.pollitosSimulation.logic.entity;

import java.util.ArrayList;
import java.util.List;

import com.pollitosSimulation.logic.DishUtils;
import com.pollitosSimulation.logic.Utils;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class DinerGroup {
	private int time;
	private List<Dish> dishs;

	/**
	 * crea un grupo de comensales aleatorio con una cantidad de una rango 1-3 y un
	 * tiempo entre 10 y 17 minutos, sin la posibilidad de que hayan dos platos
	 * iguales seguidos
	 * 
	 * @param lastDishInTable
	 */
	public DinerGroup(Dish lastDishInTable) {
		int amount = Utils.randomBetween(1, 3);
		//300Comensales --> /2 = 150ComensalesXmesero --> /2 = 75ComensalesXmesa  720HTrabajadas/75 = 10min Aprox.
		//200Comensales --> /2 = 100ComensalesXMesero --> /2 = 50ComesalesXmesa   720Htrabajadas/50 = 15min Aprox.
		time = Utils.randomBetween(10, 15);  
		dishs = new ArrayList<>(amount);
		Dish d = DishUtils.getRandomDish();
		while (lastDishInTable.equals(d)) {
			d = DishUtils.getRandomDish();
		}
		dishs.add(d);
		for (int i = 0; i < amount - 1; i++) {
			Dish dish = DishUtils.getRandomDish();
			while (!canOrder(dish)) {
				dish = DishUtils.getRandomDish();
			}
			dishs.add(dish);
		}
	}

	/**
	 * devuelve el ultimo plato pedido por este grupo de comensales
	 * 
	 * @return último plato
	 */
	public Dish getLastDish() {
		if (dishs.isEmpty())
			return null;
		return dishs.get(dishs.size() - 1);
	}

	/**
	 * determina si puede ordenar un plato, verificando si el ultimo plato y el
	 * solicitado son distintos
	 * 
	 * @param dish plato solicitado
	 * @return true si puede ser solicitado, false en caso contrario
	 */
	private boolean canOrder(Dish dish) {
		Dish d = getLastDish();
		if (d == null)
			return true;
		return !d.equals(dish);
	}

	public int getDinerAmount() {
		return dishs.size();
	}

	/**
	 * muestra el tiempo que tardó y los platos que fueron solicitados
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tiempo: ").append(time).append(",     ");
		builder.append("Platos: {");
		for (Dish dish : dishs) {
			builder.append(dish.toString()).append(", ");
		}
		builder.append("}");
		return builder.toString();
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
	 * @return Método que obtiene el valor de la propiedad dishs.
	 */
	public List<Dish> getDishs() {
		return dishs;
	}

	/**
	 * @param Método que asigna el valor de la propiedad dishs.
	 */
	public void setDishs(List<Dish> dishs) {
		this.dishs = dishs;
	}

}
