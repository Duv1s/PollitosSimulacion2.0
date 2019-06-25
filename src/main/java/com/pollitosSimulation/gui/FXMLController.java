package com.pollitosSimulation.gui;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.pollitosSimulation.logic.simulation.UtilsPlato;
import com.pollitosSimulation.logic.simulation.SimulacionRestaurante;
import com.pollitosSimulation.logic.entity.GrupoComensales;
import com.pollitosSimulation.logic.entity.Mesa;
import com.pollitosSimulation.logic.entity.EstadisticasMesa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * 
 * @author Duvis Gómez && Martin Vivanco
 * @version 2.0
 */
@SuppressWarnings("restriction")
public class FXMLController implements Initializable {

	private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
	private ObservableList<EstadisticasMesa> T1, T2, T3, T4, T5;

	@FXML
	private TableView<EstadisticasMesa> Table1Stats, Table2Stats, Table3Stats, Table4Stats, Table5Stats;

	// Mesa 1
	@FXML
	private Label T1AttentionTime, T1Diners, T1D1Sells, T1D1Gains, T1D2Sells, T1D2Gains, T1D3Sells, T1D3Gains,
			T1D4Sells, T1D4Gains;
	// Mesa 2
	@FXML
	private Label T2AttentionTime, T2Diners, T2D1Sells, T2D1Gains, T2D2Sells, T2D2Gains, T2D3Sells, T2D3Gains,
			T2D4Sells, T2D4Gains;
	// Mesa 3
	@FXML
	private Label T3AttentionTime, T3Diners, T3D1Sells, T3D1Gains, T3D2Sells, T3D2Gains, T3D3Sells, T3D3Gains,
			T3D4Sells, T3D4Gains;
	// Mesa 4
	@FXML
	private Label T4AttentionTime, T4Diners, T4D1Sells, T4D1Gains, T4D2Sells, T4D2Gains, T4D3Sells, T4D3Gains,
			T4D4Sells, T4D4Gains;
	// Mesa 5
	@FXML
	private Label T5AttentionTime, T5Diners, T5D1Sells, T5D1Gains, T5D2Sells, T5D2Gains, T5D3Sells, T5D3Gains,
			T5D4Sells, T5D4Gains;
	// Total
	@FXML
	private Label TotalAttentionTime, TotalDiners, TotalD1Sells, TotalD1Gains, TotalD2Sells, TotalD2Gains, TotalD3Sells,
			TotalD3Gains, TotalD4Sells, TotalD4Gains;

	@FXML
	private TableColumn<EstadisticasMesa, Integer> T1Column1, T1Column2, T2Column1, T2Column2, T3Column1, T3Column2, T4Column1,
			T4Column2, T5Column1, T5Column2;

	@FXML
	private TableColumn<EstadisticasMesa, String> T1Column3, T2Column3, T3Column3, T4Column3, T5Column3;

	/**
	 * da inicio a la simulación cuando se presiona el botón
	 * 
	 * @param event
	 */
	@FXML
	private void start(ActionEvent event) {
		SimulacionRestaurante sumulacionResta = new SimulacionRestaurante(2, 300, 12, 200, 10, 150, 5);
		sumulacionResta.start();
		llenarTablaMesa1(sumulacionResta.getMesa(1));
		llenarTablaMesa2(sumulacionResta.getMesa(2));
		llenarTablaMesa3(sumulacionResta.getMesa(3));
		llenarTablaMesa4(sumulacionResta.getMesa(4));
		llenarTablaMesa5(sumulacionResta.getMesa(5));
		llenarEstadisticasTotales(sumulacionResta);
	}

	/**
	 * llena las estadisticas e informacion para la mesa 1
	 * 
	 * @param mesa mesa
	 */
	private void llenarTablaMesa1(Mesa mesa) {
		T1.clear();
		for (GrupoComensales gC : mesa.getListaPlatos()) {
			T1.add(new EstadisticasMesa(gC.getTiempo(), gC.getCantidadComensales(), gC.getListaPlatos()));
		}
		T1AttentionTime.setText(String.format("%.3f", ((double) mesa.getTiempoTotal()) / 60) + " Horas");
		T1Diners.setText("" + mesa.getTotalComensales());
		T1D1Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_UNO));
		T1D1Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_UNO)));
		T1D2Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_DOS));
		T1D2Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_DOS)));
		T1D3Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_TRES));
		T1D3Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_TRES)));
		T1D4Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_CUATRO));
		T1D4Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_CUATRO)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 2
	 * 
	 * @param mesa mesa
	 */
	private void llenarTablaMesa2(Mesa mesa) {
		T2.clear();
		for (GrupoComensales gC : mesa.getListaPlatos()) {
			T2.add(new EstadisticasMesa(gC.getTiempo(), gC.getCantidadComensales(), gC.getListaPlatos()));
		}
		T2AttentionTime.setText(String.format("%.3f", ((double) mesa.getTiempoTotal()) / 60) + " Horas");
		T2Diners.setText("" + mesa.getTotalComensales());
		T2D1Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_UNO));
		T2D1Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_UNO)));
		T2D2Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_DOS));
		T2D2Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_DOS)));
		T2D3Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_TRES));
		T2D3Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_TRES)));
		T2D4Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_CUATRO));
		T2D4Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_CUATRO)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 3
	 * 
	 * @param mesa mesa
	 */
	private void llenarTablaMesa3(Mesa mesa) {
		T3.clear();
		for (GrupoComensales gC : mesa.getListaPlatos()) {
			T3.add(new EstadisticasMesa(gC.getTiempo(), gC.getCantidadComensales(), gC.getListaPlatos()));
		}
		T3AttentionTime.setText(String.format("%.3f", ((double) mesa.getTiempoTotal()) / 60) + " Horas");
		T3Diners.setText("" + mesa.getTotalComensales());
		T3D1Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_UNO));
		T3D1Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_UNO)));
		T3D2Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_DOS));
		T3D2Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_DOS)));
		T3D3Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_TRES));
		T3D3Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_TRES)));
		T3D4Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_CUATRO));
		T3D4Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_CUATRO)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 4
	 * 
	 * @param mesa mesa
	 */
	private void llenarTablaMesa4(Mesa mesa) {
		T4.clear();
		for (GrupoComensales dg : mesa.getListaPlatos()) {
			T4.add(new EstadisticasMesa(dg.getTiempo(), dg.getCantidadComensales(), dg.getListaPlatos()));
		}
		T4AttentionTime.setText(String.format("%.3f", ((double) mesa.getTiempoTotal()) / 60) + " Horas");
		T4Diners.setText("" + mesa.getTotalComensales());
		T4D1Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_UNO));
		T4D1Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_UNO)));
		T4D2Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_DOS));
		T4D2Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_DOS)));
		T4D3Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_TRES));
		T4D3Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_TRES)));
		T4D4Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_CUATRO));
		T4D4Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_CUATRO)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 5
	 * 
	 * @param mesa mesa
	 */
	private void llenarTablaMesa5(Mesa mesa) {
		T5.clear();
		for (GrupoComensales gC : mesa.getListaPlatos()) {
			T5.add(new EstadisticasMesa(gC.getTiempo(), gC.getCantidadComensales(), gC.getListaPlatos()));
		}
		T5AttentionTime.setText(String.format("%.3f", ((double) mesa.getTiempoTotal()) / 60) + " Horas");
		T5Diners.setText("" + mesa.getTotalComensales());
		T5D1Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_UNO));
		T5D1Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_UNO)));
		T5D2Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_DOS));
		T5D2Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_DOS)));
		T5D3Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_TRES));
		T5D3Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_TRES)));
		T5D4Sells.setText("" + mesa.getTotalCantidadTotalPlato(UtilsPlato.PLATO_CUATRO));
		T5D4Gains.setText(currencyFormatter.format(mesa.getGananciaTotalPlato(UtilsPlato.PLATO_CUATRO)));
	}

	/**
	 * Muestra las estadisticas e información final
	 * 
	 * @param simulacionRestaurante mesa
	 */
	private void llenarEstadisticasTotales(SimulacionRestaurante simulacionRestaurante) {
		TotalAttentionTime.setText(String.format("%.3f", ((double) simulacionRestaurante.getCantidadMesas()) / 60) + " Horas");
		TotalDiners.setText("" + simulacionRestaurante.getClietnesTotal());
		TotalD1Sells.setText("" + simulacionRestaurante.getVentasTotalesPPlato(UtilsPlato.PLATO_UNO));
		TotalD1Gains.setText(currencyFormatter.format(simulacionRestaurante.getGananciaTotalPPlato(UtilsPlato.PLATO_UNO)));
		TotalD2Sells.setText("" + simulacionRestaurante.getVentasTotalesPPlato(UtilsPlato.PLATO_DOS));
		TotalD2Gains.setText(currencyFormatter.format(simulacionRestaurante.getGananciaTotalPPlato(UtilsPlato.PLATO_DOS)));
		TotalD3Sells.setText("" + simulacionRestaurante.getVentasTotalesPPlato(UtilsPlato.PLATO_TRES));
		TotalD3Gains.setText(currencyFormatter.format(simulacionRestaurante.getGananciaTotalPPlato(UtilsPlato.PLATO_TRES)));
		TotalD4Sells.setText("" + simulacionRestaurante.getVentasTotalesPPlato(UtilsPlato.PLATO_CUATRO));
		TotalD4Gains.setText(currencyFormatter.format(simulacionRestaurante.getGananciaTotalPPlato(UtilsPlato.PLATO_CUATRO)));

	}

	/**
	 * inicializa tablas y demas elementos de la Interfaz gráfica
	 * 
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		T1Column1.setCellValueFactory(new PropertyValueFactory<>("time"));
		T2Column1.setCellValueFactory(new PropertyValueFactory<>("time"));
		T3Column1.setCellValueFactory(new PropertyValueFactory<>("time"));
		T4Column1.setCellValueFactory(new PropertyValueFactory<>("time"));
		T5Column1.setCellValueFactory(new PropertyValueFactory<>("time"));
		T1Column2.setCellValueFactory(new PropertyValueFactory<>("diners"));
		T2Column2.setCellValueFactory(new PropertyValueFactory<>("diners"));
		T3Column2.setCellValueFactory(new PropertyValueFactory<>("diners"));
		T4Column2.setCellValueFactory(new PropertyValueFactory<>("diners"));
		T5Column2.setCellValueFactory(new PropertyValueFactory<>("diners"));
		T1Column3.setCellValueFactory(new PropertyValueFactory<>("dishs"));
		T2Column3.setCellValueFactory(new PropertyValueFactory<>("dishs"));
		T3Column3.setCellValueFactory(new PropertyValueFactory<>("dishs"));
		T4Column3.setCellValueFactory(new PropertyValueFactory<>("dishs"));
		T5Column3.setCellValueFactory(new PropertyValueFactory<>("dishs"));

		T1 = FXCollections.observableArrayList();
		T2 = FXCollections.observableArrayList();
		T3 = FXCollections.observableArrayList();
		T4 = FXCollections.observableArrayList();
		T5 = FXCollections.observableArrayList();

		Table1Stats.setItems(T1);
		Table2Stats.setItems(T2);
		Table3Stats.setItems(T3);
		Table4Stats.setItems(T4);
		Table5Stats.setItems(T5);

	}
}
