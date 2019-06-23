package com.pollitosSimulation.gui;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.pollitosSimulation.logic.DishUtils;
import com.pollitosSimulation.logic.RestaurantSimulation;
import com.pollitosSimulation.logic.entity.DinerGroup;
import com.pollitosSimulation.logic.entity.Table;
import com.pollitosSimulation.logic.entity.TableStat;

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
public class FXMLController implements Initializable {

	private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
	private ObservableList<TableStat> T1, T2, T3, T4, T5;

	@FXML
	private TableView<TableStat> Table1Stats, Table2Stats, Table3Stats, Table4Stats, Table5Stats;

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
	private TableColumn<TableStat, Integer> T1Column1, T1Column2, T2Column1, T2Column2, T3Column1, T3Column2, T4Column1,
			T4Column2, T5Column1, T5Column2;

	@FXML
	private TableColumn<TableStat, String> T1Column3, T2Column3, T3Column3, T4Column3, T5Column3;

	/**
	 * da inicio a la simulación cuando se presiona el botón
	 * 
	 * @param event
	 */
	@FXML
	private void start(ActionEvent event) {
		RestaurantSimulation rs = new RestaurantSimulation(2, 300, 12, 200, 10, 150, 5);
		rs.start();
		fillTable1Stats(rs.getTable(1));
		fillTable2Stats(rs.getTable(2));
		fillTable3Stats(rs.getTable(3));
		fillTable4Stats(rs.getTable(4));
		fillTable5Stats(rs.getTable(5));
		fillTableTotalStats(rs);
//        rs.printTableStats();
	}

	/**
	 * llena las estadisticas e informacion para la mesa 1
	 * 
	 * @param t mesa
	 */
	private void fillTable1Stats(Table t) {
		T1.clear();
		for (DinerGroup dg : t.getListDish()) {
			T1.add(new TableStat(dg.getTime(), dg.getDinerAmount(), dg.getDishs()));
		}
		T1AttentionTime.setText(String.format("%.3f", ((double) t.getTotalTime()) / 60) + " Horas");
		T1Diners.setText("" + t.getTotalDiners());
		T1D1Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_1));
		T1D1Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_1)));
		T1D2Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_2));
		T1D2Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_2)));
		T1D3Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_3));
		T1D3Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_3)));
		T1D4Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_4));
		T1D4Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_4)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 2
	 * 
	 * @param t mesa
	 */
	private void fillTable2Stats(Table t) {
		T2.clear();
		for (DinerGroup dg : t.getListDish()) {
			T2.add(new TableStat(dg.getTime(), dg.getDinerAmount(), dg.getDishs()));
		}
		T2AttentionTime.setText(String.format("%.3f", ((double) t.getTotalTime()) / 60) + " Horas");
		T2Diners.setText("" + t.getTotalDiners());
		T2D1Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_1));
		T2D1Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_1)));
		T2D2Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_2));
		T2D2Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_2)));
		T2D3Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_3));
		T2D3Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_3)));
		T2D4Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_4));
		T2D4Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_4)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 3
	 * 
	 * @param t mesa
	 */
	private void fillTable3Stats(Table t) {
		T3.clear();
		for (DinerGroup dg : t.getListDish()) {
			T3.add(new TableStat(dg.getTime(), dg.getDinerAmount(), dg.getDishs()));
		}
		T3AttentionTime.setText(String.format("%.3f", ((double) t.getTotalTime()) / 60) + " Horas");
		T3Diners.setText("" + t.getTotalDiners());
		T3D1Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_1));
		T3D1Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_1)));
		T3D2Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_2));
		T3D2Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_2)));
		T3D3Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_3));
		T3D3Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_3)));
		T3D4Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_4));
		T3D4Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_4)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 4
	 * 
	 * @param t mesa
	 */
	private void fillTable4Stats(Table t) {
		T4.clear();
		for (DinerGroup dg : t.getListDish()) {
			T4.add(new TableStat(dg.getTime(), dg.getDinerAmount(), dg.getDishs()));
		}
		T4AttentionTime.setText(String.format("%.3f", ((double) t.getTotalTime()) / 60) + " Horas");
		T4Diners.setText("" + t.getTotalDiners());
		T4D1Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_1));
		T4D1Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_1)));
		T4D2Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_2));
		T4D2Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_2)));
		T4D3Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_3));
		T4D3Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_3)));
		T4D4Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_4));
		T4D4Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_4)));
	}

	/**
	 * llena las estadisticas e informacion para la mesa 5
	 * 
	 * @param t mesa
	 */
	private void fillTable5Stats(Table t) {
		T5.clear();
		for (DinerGroup dg : t.getListDish()) {
			T5.add(new TableStat(dg.getTime(), dg.getDinerAmount(), dg.getDishs()));
		}
		T5AttentionTime.setText(String.format("%.3f", ((double) t.getTotalTime()) / 60) + " Horas");
		T5Diners.setText("" + t.getTotalDiners());
		T5D1Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_1));
		T5D1Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_1)));
		T5D2Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_2));
		T5D2Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_2)));
		T5D3Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_3));
		T5D3Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_3)));
		T5D4Sells.setText("" + t.getTotalAmountDishOf(DishUtils.DISH_NAME_4));
		T5D4Gains.setText(currencyFormatter.format(t.getTotalGainDishOf(DishUtils.DISH_NAME_4)));
	}

	/**
	 * Muestra las estadisticas e información final
	 * 
	 * @param rs mesa
	 */
	private void fillTableTotalStats(RestaurantSimulation rs) {
		TotalAttentionTime.setText(String.format("%.3f", ((double) rs.getActualSimulationTime()) / 60) + " Horas");
		TotalDiners.setText("" + rs.getTotalDiners());
		TotalD1Sells.setText("" + rs.getTotalAmountDishOf(DishUtils.DISH_NAME_1));
		TotalD1Gains.setText(currencyFormatter.format(rs.getTotalGainDishOf(DishUtils.DISH_NAME_1)));
		TotalD2Sells.setText("" + rs.getTotalAmountDishOf(DishUtils.DISH_NAME_2));
		TotalD2Gains.setText(currencyFormatter.format(rs.getTotalGainDishOf(DishUtils.DISH_NAME_2)));
		TotalD3Sells.setText("" + rs.getTotalAmountDishOf(DishUtils.DISH_NAME_3));
		TotalD3Gains.setText(currencyFormatter.format(rs.getTotalGainDishOf(DishUtils.DISH_NAME_3)));
		TotalD4Sells.setText("" + rs.getTotalAmountDishOf(DishUtils.DISH_NAME_4));
		TotalD4Gains.setText(currencyFormatter.format(rs.getTotalGainDishOf(DishUtils.DISH_NAME_4)));

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
