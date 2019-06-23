package com.pollitosSimulation.logic;

import com.pollitosSimulation.logic.entity.Dish;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class DishUtils {

	public static final String DISH_NAME_1 = "Bandeja Paisa";
	public static final String DISH_NAME_2 = "Cuchuco de Trigo";
	public static final String DISH_NAME_3 = "Paella a la Valenciana";
	public static final String DISH_NAME_4 = "Arroz con Pollo";

	/**
	 * genera un plato aleatorio de los predefinidos, incluyendo una calificación
	 * aleatoria entre 0 y 5
	 * 
	 * @return
	 */
	public static Dish getRandomDish() {
		switch (Utils.RANDOM.nextInt(4)) {
		case 0:
			return new Dish(DISH_NAME_1, Utils.randomBetween(0, 5), 25, 18000);
		case 1:
			return new Dish(DISH_NAME_2, Utils.randomBetween(0, 5), 25, 12000);
		case 2:
			return new Dish(DISH_NAME_3, Utils.randomBetween(0, 5), 25, 20000);
		case 3:
			return new Dish(DISH_NAME_4, Utils.randomBetween(0, 5), 25, 17000);
		default:
			return null;
		}
	}

}
