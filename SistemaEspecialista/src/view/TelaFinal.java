package view;

import model.Regra;
import app.Main;
import banco.Banco;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaFinal extends BorderPane{
	
	private Stage stage;
	private Group rootGroup;
	private Scene scene;
	private Text text;
	private Button ok;
	private TableView<String> tabela;
	
	public TelaFinal(ObservableList<String> lista){
		
		stage = new Stage();
		rootGroup = new Group();
		scene = new Scene(rootGroup, 500, 200, Color.WHITESMOKE);
		
		stage.initModality(Modality.WINDOW_MODAL);
		
		ok = new Button("OK");
		
		ok.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stage.close();
			}
		});
	    
	    text = new Text(10, 50, "Melhor(es) pacote(s) pra você:");
	    text.setFill(Color.DODGERBLUE);
	    
	    text.setX(160);
	    text.setEffect(new Lighting());

	    text.setFont(Font.font(Font.getDefault().getFamily(), 20));
	   
		
		TableColumn expressao = new TableColumn();
		expressao.setText("Regra");
		expressao.setMinWidth(1200);
		expressao.setCellValueFactory(new PropertyValueFactory(""));
	        
		
		tabela = new TableView();
	    tabela.setItems(lista);
	    tabela.getColumns().addAll(expressao);
	    
	    VBox elementos = new VBox(20);
	    elementos.getChildren().addAll(tabela,ok);
	    elementos.setLayoutX(200);
	    elementos.setLayoutY(90);
	    
	    rootGroup.getChildren().add(elementos);
	    rootGroup.getChildren().add(text);
	    
	    stage.setScene(scene);
	    stage.centerOnScreen();
	    stage.show();
	}
	
}
