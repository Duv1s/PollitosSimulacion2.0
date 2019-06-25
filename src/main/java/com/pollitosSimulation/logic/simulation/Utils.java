package com.pollitosSimulation.logic.simulation;

import java.util.Random;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class Utils {
	// Objeto de la clase random
	public static final Random RANDOM = new Random();

	/**
	 * devuelve un valor aleatorio generado en el rango especificado
	 * 
	 * @param min valor minimo
	 * @param max valor maximo
	 * @return entero aleatorio
	 */
	public static int aleatorioEntre(int min, int max) {
		return RANDOM.nextInt((max - min) + 1) + min;
	}
}
