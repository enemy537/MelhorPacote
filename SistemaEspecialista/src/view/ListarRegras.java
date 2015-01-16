package view;

import app.Main;
import banco.Banco;
import model.Regra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ListarRegras extends BorderPane{
	
	private TableView<Regra> tabela;
	private Banco banco = Main.getBanco();
	private ObservableList<Regra> listaRegrasTabela;
	
	public ListarRegras(){
		
		MenuGeral menu = new MenuGeral();
		
		listaRegrasTabela = FXCollections.observableArrayList(banco.listarRegras());
		
		TableColumn origemCol = new TableColumn();
		origemCol.setText("Origem");
		origemCol.setMinWidth(120);
		origemCol.setCellValueFactory(new PropertyValueFactory("origem"));
	        
		TableColumn destinoCol = new TableColumn();
		destinoCol.setText("Destino");
		destinoCol.setMinWidth(120);
		destinoCol.setCellValueFactory(new PropertyValueFactory("destino"));
		
		TableColumn qtdPassCol = new TableColumn();
		qtdPassCol.setText("Quantidade de Passageiros");
		qtdPassCol.setMinWidth(250);
		qtdPassCol.setCellValueFactory(new PropertyValueFactory("qtdPassageiros"));
	        
		TableColumn orcamentoCol = new TableColumn();
		orcamentoCol.setText("Orçamento");
		orcamentoCol.setMinWidth(250);
		orcamentoCol.setCellValueFactory(new PropertyValueFactory("orcamento"));
		
		TableColumn pacoteCol = new TableColumn();
		pacoteCol.setText("Pacote");
		pacoteCol.setMinWidth(250);
		pacoteCol.setCellValueFactory(new PropertyValueFactory("pacote"));
		
		tabela = new TableView();
	    tabela.setItems(listaRegrasTabela);
	    tabela.setMaxHeight(400);
	    tabela.setMaxWidth(1000);
	    tabela.getColumns().addAll(origemCol, destinoCol, qtdPassCol, orcamentoCol, pacoteCol);
	    
	    VBox boxTop = new VBox(20);
		boxTop.getChildren().addAll(menu, tabela);
		
		setTop(boxTop);
		boxTop.setAlignment(Pos.CENTER);
		
	}

}
