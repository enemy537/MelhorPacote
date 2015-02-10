package view;

import model.Motor;
import banco.Banco;
import app.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Executar extends BorderPane{
	
	private Button iniciar;
	private Motor motor;
	
	public Executar(){
		
		MenuGeral vboxtop = new MenuGeral();
		Banco banco = Main.getBanco();
		
		iniciar = new Button("Iniciar execução");
		
		iniciar.setOnAction(new EventHandler() {
			
			@Override
			public void handle(Event arg0) {
				motor = new Motor(banco.listarRegras());
				motor.novaPergunta();
				
			}
		});
		
		VBox vbox1 = new VBox(20);
		vbox1.getChildren().addAll(iniciar);
		vbox1.setAlignment(Pos.CENTER);
	
		HBox hboxGeral = new HBox(30);
		hboxGeral.getChildren().addAll(vbox1);
		hboxGeral.setPadding(new Insets(10,100,10,100));
				
		setCenter(hboxGeral);
		setTop(vboxtop);     //Setando menuBar sempre no topo
	}
}
