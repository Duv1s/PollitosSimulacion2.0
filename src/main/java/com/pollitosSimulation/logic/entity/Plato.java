package com.pollitosSimulation.logic.entity;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class Plato {
	private String nombre;
	private int calificacion;
	private int porcentajeGanancia;
	private double ganancia;
	private int precio;

	/**
	 * crea un plato con los parametros ingresados
	 * 
	 * @param nombre           Nombre del plato
	 * @param calificacion   Calificación del plato
	 * @param porcentajeGanancia Porcentaje de ganancias del plato
	 * @param precio          precio del plato
	 */
	public Plato(String nombre, int calificacion, int porcentajeGanancia, int precio) {
		this.nombre = nombre;
		this.calificacion = calificacion;
		this.porcentajeGanancia = porcentajeGanancia;
		this.ganancia = (precio * porcentajeGanancia) / 100;
		this.precio = precio;
	}

	/**
	 * se sobreescribe el metodo equals para comparar los platos por el nombre
	 * 
	 * @param obj objeto a comparar
	 * @return true si tienen el mismo nombre, false en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		return nombre.equals(((Plato) obj).nombre);
	}

	/**
	 * muestra el nombre del plato y entre parentesis la calificación
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return nombre + " (" + calificacion + ")";
	}

	// Métodos getters y setters ------

	/**
	 * @return Método que obtiene el valor de la propiedad nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param Método que asigna el valor de la propiedad nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad calificacion.
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * @param Método que asigna el valor de la propiedad calificacion.
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad porcentajeGanancia.
	 */
	public int getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	/**
	 * @param Método que asigna el valor de la propiedad porcentajeGanancia.
	 */
	public void setPorcentajeGanancia(int porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad ganancia.
	 */
	public double getGanancia() {
		return ganancia;
	}

	/**
	 * @param Método que asigna el valor de la propiedad ganancia.
	 */
	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad precio.
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param Método que asigna el valor de la propiedad precio.
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
