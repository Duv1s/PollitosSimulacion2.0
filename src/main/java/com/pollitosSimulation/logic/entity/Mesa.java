package com.pollitosSimulation.logic.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class Mesa {
	private int comensalesActuales;
	private boolean disponible;
	private List<GrupoComensales> listaGrupoComensales;
	private int tiempoDisponible;

	/**
	 * crea una nueva mesa
	 */
	public Mesa() {
		this.comensalesActuales = 0;
		this.disponible = true;
		this.listaGrupoComensales = new ArrayList<>();
	}

	/**
	 * devuelve el ultimo plato solicitado en esta mesa
	 * 
	 * @return último plato solicitado
	 */
	private Plato getLastDish() {
		if (listaGrupoComensales.isEmpty()) {
			return new Plato("Random Plato", 0, 0, 0);
		}
		return listaGrupoComensales.get(listaGrupoComensales.size() - 1).getUltimoPlato();
	}

	/**
	 * agrega un nuevo grupo de comensales a esta mesa
	 */
	public void addGrupo() {
		listaGrupoComensales.add(new GrupoComensales(getLastDish()));
	}

	/**
	 * devuelve el tiempo que tardo el ultimo grupo de comensales en consumir sus
	 * alimentos
	 * 
	 * @return tiempo que gasto el ultimo grupo
	 */
	public int getUltimoTiempo() {
		return listaGrupoComensales.get(listaGrupoComensales.size() - 1).getTiempo();
	}

	/**
	 * devuelve el tiempo que ha estado en operación esta mesa
	 * 
	 * @return tiempo total de servicio
	 */
	public int getTiempoTotal() {
		int tiempo = 0;
		for (GrupoComensales dg : listaGrupoComensales) {
			tiempo += dg.getTiempo();
		}
		return tiempo;
	}

	/**
	 * devuelve el total de consumos de un determinado plato
	 * 
	 * @param name nombre del plato
	 * @return total de consumos
	 */
	public int getTotalCantidadTotalPlato(String name) {
		int cantidad = 0;
		for (GrupoComensales dg : listaGrupoComensales) {
			for (Plato plato : dg.getListaPlatos()) {
				if (plato.getNombre().equals(name)) {
					cantidad++;
				}
			}
		}
		return cantidad;
	}

	/**
	 * devuelve el total de ganancias que se generaron con un determinado plato
	 * 
	 * @param name nombre del plato
	 * @return total de ganancias
	 */
	public double getGananciaTotalPlato(String name) {
		int amount = 0;
		for (GrupoComensales dg : listaGrupoComensales) {
			for (Plato plato : dg.getListaPlatos()) {
				if (plato.getNombre().equals(name)) {
					amount += plato.getGanancia();
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
	public int getTotalComensales() {
		int amount = 0;
		for (GrupoComensales dg : listaGrupoComensales) {
			amount += dg.getCantidadComensales();
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
		builder.append("Tiempo Total de Atención: ").append(getTiempoTotal()).append("\n");
		builder.append("Total de Clientes: ").append(getTotalComensales()).append("\n");
		builder.append("===========Clientes============").append("\n");
		for (GrupoComensales dg : listaGrupoComensales) {
			builder.append(dg.toString()).append("\n");
		}
		return builder.toString();
	}

	// Métodos getters y setters ------
	/**
	 * @return Método que obtiene el valor de la propiedad listaGrupoComensales.
	 */
	public List<GrupoComensales> getListaPlatos() {
		return listaGrupoComensales;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listaGrupoComensales.
	 */
	public void setListDish(List<GrupoComensales> listDish) {
		this.listaGrupoComensales = listDish;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad comensalesActuales.
	 */
	public int getComensalesActuales() {
		return comensalesActuales;
	}

	/**
	 * @param Método que asigna el valor de la propiedad comensalesActuales.
	 */
	public void setComensalesActuales(int comensalesActuales) {
		this.comensalesActuales = comensalesActuales;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad disponible.
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * @param Método que asigna el valor de la propiedad disponible.
	 */
	public void setDisponible(boolean isAvailable) {
		this.disponible = isAvailable;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad tiempoDisponible.
	 */
	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	/**
	 * @param Método que asigna el valor de la propiedad tiempoDisponible.
	 */
	public void setTiempoDisponible(int tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}
}
