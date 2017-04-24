package view;

import app.Main;
import banco.Banco;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JanelaExecucao extends BorderPane {

	private Button sim,nao;
	
	public JanelaExecucao() {

		MenuGeral vboxtop = new MenuGeral();
		
		sim = new Button("Sim");
		nao = new Button("Não");
		
		VBox vbox1 = new VBox(20);
		vbox1.getChildren().addAll(sim,nao);
		vbox1.setAlignment(Pos.CENTER);
	
		HBox hboxGeral = new HBox(30);
		hboxGeral.getChildren().addAll(vbox1);
		hboxGeral.setPadding(new Insets(10,100,10,100));
				
		setCenter(hboxGeral);
		setTop(vboxtop);     //Setando menuBar sempre no topo
       
	}
}
