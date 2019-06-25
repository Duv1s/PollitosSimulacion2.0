package com.pollitosSimulation.logic.simulation;

import com.pollitosSimulation.logic.entity.Plato;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class UtilsPlato {

	public static final String PLATO_UNO = "Bandeja Paisa";
	public static final String PLATO_DOS = "Cuchuco de Trigo con Espinazo";
	public static final String PLATO_TRES = "Paella a la Valenciana";
	public static final String PLATO_CUATRO = "Arroz con Pollo";

	/**
	 * genera un plato aleatorio de los predefinidos, incluyendo una calificación
	 * aleatoria entre 0 y 5
	 * 
	 * @return
	 */
	public static Plato getPlatoAleatorio() {
		switch (Utils.RANDOM.nextInt(4)) {
		case 0:
			return new Plato(PLATO_UNO, Utils.aleatorioEntre(0, 5), 25, 18000);
		case 1:
			return new Plato(PLATO_DOS, Utils.aleatorioEntre(0, 5), 25, 12000);
		case 2:
			return new Plato(PLATO_TRES, Utils.aleatorioEntre(0, 5), 25, 20000);
		case 3:
			return new Plato(PLATO_CUATRO, Utils.aleatorioEntre(0, 5), 25, 17000);
		default:
			return null;
		}
	}

}
