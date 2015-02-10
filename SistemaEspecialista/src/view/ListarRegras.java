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
		
		listaRegrasTabela = FXCollections.observableArrayList(banco.listarRegras().getRegras());
		
		TableColumn expressao = new TableColumn();
		expressao.setText("Regra");
		expressao.setMinWidth(1200);
		expressao.setCellValueFactory(new PropertyValueFactory("expressao"));
	        
		
		tabela = new TableView();
	    tabela.setItems(listaRegrasTabela);
	    tabela.getColumns().addAll(expressao);
	    
	    VBox boxTop = new VBox(20);
		boxTop.getChildren().addAll(menu, tabela);
		
		setTop(boxTop);
		boxTop.setAlignment(Pos.CENTER);
		
	}

}
