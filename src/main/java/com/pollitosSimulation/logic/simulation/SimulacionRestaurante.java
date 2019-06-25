package com.pollitosSimulation.logic.simulation;

import java.util.ArrayList;
import java.util.List;

import com.pollitosSimulation.logic.entity.Mesa;
import com.pollitosSimulation.logic.entity.Mesero;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
public class SimulacionRestaurante {
	private List<Mesero> listaMeseros;
	private List<Mesa> listaMesas;
	private int maxComensalesDia;
	private int minComensalesDia;
	private int maxHorasPdia;
	private int minHorasPDia;
	private final int minSimulacion = 9000; //150 Horas
	private int cantidadMesas = 0;

	/**
	 * constructor
	 * 
	 * @param waiterAmount    cantidad de meseros
	 * @param maxComensalesDia máximo de comensales en una jornada
	 * @param maxHorasPdia  máximo de horas en una jornada
	 * @param minComensalesDia mínimo de comensales en una jornada
	 * @param minHorasPDia míninmo de horas en una jornada
	 * @param minSimulacion  Tiempo a simular en minutos
	 * @param mesas          cantidad de Mesas
	 */
	public SimulacionRestaurante(int waiterAmount, int maxComensalesDia, int maxHorasPdia, int minComensalesDia,
								 int minHorasPDia, int minSimulacion, int mesas) {
		this.listaMeseros = new ArrayList<>(waiterAmount);
		this.listaMesas = new ArrayList<>(mesas);
		for (int i = 0; i < mesas; i++)
			listaMesas.add(new Mesa());
		for (int i = 0; i < waiterAmount; i++)
			listaMeseros.add(new Mesero(true, 2));
		this.maxComensalesDia = maxComensalesDia;
		this.maxHorasPdia = maxHorasPdia;
		this.minComensalesDia = minComensalesDia;
		this.minHorasPDia = minHorasPDia;
	}

	/**
	 * Da inicio a la simulación Mientras el tiempo transcurrido sea menor al de la
	 * simulación va a estar recorriendo mesas atendiendo comensales calculando el
	 * tiempo que tardan y sumandolo al tiempo transcurrido
	 */
	public void start() {
		boolean continuar = true;
		while (continuar) {
			for (Mesa mesa : listaMesas) {
				if (cantidadMesas <= minSimulacion) {
					mesa.addGrupo();
					cantidadMesas += mesa.getUltimoTiempo();
					continue;
				}
				continuar = false;
			}
		}
	}

	/**
	 * Obtiene la cantidad total de ventas de un determinado plato
	 * 
	 * @param nombre nombre del plato
	 * @return cantidad de ventas
	 */
	public int getVentasTotalesPPlato(String nombre) {
		int cantidad = 0;
		for (Mesa mesa : listaMesas) {
			cantidad += mesa.getTotalCantidadTotalPlato(nombre);
		}
		return cantidad;
	}

	/**
	 * obtiene el total de ganancias de un determinado plato
	 * 
	 * @param nombre nombre del plato
	 * @return total de ganancias
	 */
	public double getGananciaTotalPPlato(String nombre) {
		double cantidad = 0;
		for (Mesa mesa : listaMesas) {
			cantidad += mesa.getGananciaTotalPlato(nombre);
		}
		return cantidad;
	}

	/**
	 * Obtiene el total de clientes atendidos durante el tiempo de la simulación
	 * 
	 * @return total de clientes atendidos
	 */
	public int getClietnesTotal() {
		int cantidad = 0;
		for (Mesa mesa : listaMesas) {
			cantidad += mesa.getTotalComensales();
		}
		return cantidad;
	}

	/**
	 * Imprime las estadisticas de la simulación
	 */
	public void printStats() {
		System.out.println("Tiempo total de simulación: " + cantidadMesas);
		System.out.println("Total de clientes: " + getClietnesTotal());
		System.out.println(UtilsPlato.PLATO_UNO + " -   Ventas: " + getVentasTotalesPPlato(UtilsPlato.PLATO_UNO)
				+ ",   Ganancias: " + getGananciaTotalPPlato(UtilsPlato.PLATO_UNO));
		System.out.println(UtilsPlato.PLATO_DOS + " -   Ventas: " + getVentasTotalesPPlato(UtilsPlato.PLATO_DOS)
				+ ",   Ganancias: " + getGananciaTotalPPlato(UtilsPlato.PLATO_DOS));
		System.out.println(UtilsPlato.PLATO_TRES + " -   Ventas: " + getVentasTotalesPPlato(UtilsPlato.PLATO_TRES)
				+ ",   Ganancias: " + getGananciaTotalPPlato(UtilsPlato.PLATO_TRES));
		System.out.println(UtilsPlato.PLATO_CUATRO + " -   Ventas: " + getVentasTotalesPPlato(UtilsPlato.PLATO_CUATRO)
				+ ",   Ganancias: " + getGananciaTotalPPlato(UtilsPlato.PLATO_CUATRO));
	}

	/**
	 * Imprime la información de las mesas
	 */
	public void printTableStats() {
		for (int i = 0; i < listaMesas.size(); i++) {
			System.out.println("=================MESA " + (i + 1) + "================");
			System.out.println(listaMesas.get(i).toString());
			System.out.println("===============FIN MESA " + (i + 1) + "==============");
		}
	}

	public List<Mesa> getListaMesas() {
		return listaMesas;
	}

	public Mesa getMesa(int tableNumber) {
		return listaMesas.get(tableNumber - 1);
	}

	public int getCantidadMesas() {
		return cantidadMesas;
	}

	// Métodos getters y setters ------

	/**
	 * @return Método que obtiene el valor de la propiedad listaMeseros.
	 */
	public List<Mesero> getListaMeseros() {
		return listaMeseros;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listaMeseros.
	 */
	public void setListaMeseros(List<Mesero> listaMeseros) {
		this.listaMeseros = listaMeseros;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad maxComensalesDia.
	 */
	public int getMaxComensalesDia() {
		return maxComensalesDia;
	}

	/**
	 * @param Método que asigna el valor de la propiedad maxComensalesDia.
	 */
	public void setMaxComensalesDia(int maxComensalesDia) {
		this.maxComensalesDia = maxComensalesDia;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad maxHorasPdia.
	 */
	public int getMaxHorasPdia() {
		return maxHorasPdia;
	}

	/**
	 * @param Método que asigna el valor de la propiedad maxHorasPdia.
	 */
	public void setMaxHorasPdia(int maxHorasPdia) {
		this.maxHorasPdia = maxHorasPdia;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad minComensalesDia.
	 */
	public int getMinComensalesDia() {
		return minComensalesDia;
	}

	/**
	 * @param Método que asigna el valor de la propiedad minComensalesDia.
	 */
	public void setMinComensalesDia(int minComensalesDia) {
		this.minComensalesDia = minComensalesDia;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad minHorasPDia.
	 */
	public int getMinHorasPDia() {
		return minHorasPDia;
	}

	/**
	 * @param Método que asigna el valor de la propiedad minHorasPDia.
	 */
	public void setMinHorasPDia(int minHorasPDia) {
		this.minHorasPDia = minHorasPDia;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad minSimulacion.
	 */
	public int getMinSimulacion() {
		return minSimulacion;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listaMesas.
	 */
	public void setListaMesas(List<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}

	/**
	 * @param Método que asigna el valor de la propiedad cantidadMesas.
	 */
	public void setCantidadMesas(int cantidadMesas) {
		this.cantidadMesas = cantidadMesas;
	}

}
