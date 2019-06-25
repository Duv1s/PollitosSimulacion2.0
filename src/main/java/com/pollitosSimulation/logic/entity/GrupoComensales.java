package com.pollitosSimulation.logic.entity;

import java.util.ArrayList;
import java.util.List;

import com.pollitosSimulation.logic.simulation.UtilsPlato;
import com.pollitosSimulation.logic.simulation.Utils;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class GrupoComensales {
	private int tiempo;
	private List<Plato> listaPlatos;

	/**
	 * crea un grupo de comensales aleatorio con una cantidad de una rango 1-3 y un
	 * tiempo entre 10 y 17 minutos, sin la posibilidad de que hayan dos platos
	 * iguales seguidos
	 * 
	 * @param lastPlatoInTable
	 */
	public GrupoComensales(Plato lastPlatoInTable) {
		int cantidad = Utils.aleatorioEntre(1, 3);
		tiempo = Utils.aleatorioEntre(10, 15);
		listaPlatos = new ArrayList<>(cantidad);
		Plato platoAleatorio = UtilsPlato.getPlatoAleatorio();
		while (lastPlatoInTable.equals(platoAleatorio)) {
			platoAleatorio = UtilsPlato.getPlatoAleatorio();
		}
		listaPlatos.add(platoAleatorio);
		for (int i = 0; i < cantidad - 1; i++) {
			Plato plato = UtilsPlato.getPlatoAleatorio();
			while (!validesPlato(plato)) {
				plato = UtilsPlato.getPlatoAleatorio();
			}
			listaPlatos.add(plato);
		}
	}

	/**
	 * devuelve el ultimo plato pedido por este grupo de comensales
	 * 
	 * @return último plato
	 */
	public Plato getUltimoPlato() {
		if (listaPlatos.isEmpty())
			return null;
		return listaPlatos.get(listaPlatos.size() - 1);
	}

	/**
	 * determina si puede ordenar un plato, verificando si el ultimo plato y el
	 * solicitado son distintos
	 * 
	 * @param plato plato solicitado
	 * @return true si puede ser solicitado, false en caso contrario
	 */
	private boolean validesPlato(Plato plato) {
		Plato d = getUltimoPlato();
		if (d == null)
			return true;
		return !d.equals(plato);
	}

	public int getCantidadComensales() {
		return listaPlatos.size();
	}

	/**
	 * muestra el tiempo que tardó y los platos que fueron solicitados
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tiempo: ").append(tiempo).append(",     ");
		builder.append("Platos: {");
		for (Plato plato : listaPlatos) {
			builder.append(plato.toString()).append(", ");
		}
		builder.append("}");
		return builder.toString();
	}

	// Métodos getters y setters ------

	/**
	 * @return Método que obtiene el valor de la propiedad tiempo.
	 */
	public int getTiempo() {
		return tiempo;
	}

	/**
	 * @param Método que asigna el valor de la propiedad tiempo.
	 */
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listaPlatos.
	 */
	public List<Plato> getListaPlatos() {
		return listaPlatos;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listaPlatos.
	 */
	public void setListaPlatos(List<Plato> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

}
