package view;

import java.util.ArrayList;

import model.Fato;
import model.Motor;
import banco.Banco;
import EDU.purdue.cs.bloat.tree.SRStmt;
import app.Main;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Executar extends BorderPane{
	
	private Button iniciar;
	private Motor motor;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Executar(){
		
		MenuGeral vboxtop = new MenuGeral();
		final Banco banco = Main.getBanco();
		
		Image logo = new Image(getClass().getResourceAsStream("/image/logo.png"));
		iniciar = new Button("Iniciar busca do melhor pacote", new ImageView(logo));
		
		iniciar.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				motor = new Motor(banco.listarRegras());
				motor.limparMemoria();
				ObservableList<String> respostas = motor.executar();
				if(respostas.size() == 0){
					Alert alt = new Alert(AlertType.ERROR);
					alt.setTitle("Xiii... não dei.");
					alt.setHeaderText("Nenhum pacote encontrado.");
					alt.setContentText("Nenhum pacote se adequa a suas necessidades.");
					alt.show();
				}else{
					String saida = "";
					for(String string : respostas){
						saida += string + "\n";
					}
					Alert alt = new Alert(AlertType.INFORMATION);
					alt.setTitle("Encontramos algo!");
					alt.setHeaderText("Melhor Pacote encontrado.");
					alt.setContentText(saida);
					alt.show();
				}
			}	
		});
		
		VBox vbox1 = new VBox(20);
		vbox1.getChildren().addAll(iniciar);
		vbox1.setAlignment(Pos.CENTER);
	
				
		setCenter(vbox1);
		setTop(vboxtop);     //Setando menuBar sempre no topo
	}
}
