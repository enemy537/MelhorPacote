package view;

import app.Main;
import banco.Banco;
import model.Regra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ListarRegras extends BorderPane{
	
	private TableView<Regra> tabela;
	private Banco banco = Main.getBanco();
	private ObservableList<Regra> listaRegrasTabela;
	private Button excluir, editar;
	
	public ListarRegras(){
		
		MenuGeral menu = new MenuGeral();
		
		listaRegrasTabela = FXCollections.observableArrayList(banco.listarRegras().getRegras());
		
		TableColumn expressao = new TableColumn();
		expressao.setText("Regra");
		expressao.setMinWidth(1200);
		expressao.setCellValueFactory(new PropertyValueFactory("expressao"));
	        
		excluir = new Button("Excluir");
		editar = new Button("Editar");
		
		tabela = new TableView();
	    tabela.setItems(listaRegrasTabela);
	    tabela.getColumns().addAll(expressao);
	    
	    VBox boxTop = new VBox(20);
		boxTop.getChildren().addAll(menu, tabela, excluir, editar);
		
		excluir.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				Regra r = tabela.getSelectionModel().getSelectedItem();
				new TelaAux(r, "Deseja remover essa regra?", tabela);
				
			}
		});
		
		
		
		setTop(boxTop);
		boxTop.setAlignment(Pos.CENTER);
		
	}

}
