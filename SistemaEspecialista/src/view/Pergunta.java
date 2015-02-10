package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Pergunta extends BorderPane{
	private Stage stage;
	private Group rootGroup;
	private Scene scene;
	private Text text;
	private Button sim,nao;
	public Boolean decisao;
	
	public Pergunta(String pergunta){
		stage = new Stage();
		rootGroup = new Group();
		scene = new Scene(rootGroup, 500, 200, Color.WHITESMOKE);
		sim = new Button("Sim");
	    nao = new Button("Não");
	   
	    
	    sim.setOnAction(new EventHandler() {
			
			@Override
			public void handle(Event arg0) {
				decisao = true;
				stage.close();
			}
		});
	    
	    nao.setOnAction(new EventHandler() {
			
			@Override
			public void handle(Event arg0) {
				decisao = false;
				stage.close();
			}
		});
	    
		stage.setScene(scene);
	    stage.centerOnScreen();
	    stage.show();
	    
	    text = new Text(10, 50, pergunta);
	    text.setFill(Color.DODGERBLUE);
	    
	    text.setX(160);
	    text.setEffect(new Lighting());

	    text.setFont(Font.font(Font.getDefault().getFamily(), 20));
	    
	    HBox botoes = new HBox(20);
	    botoes.getChildren().addAll(sim,nao);
	    botoes.setLayoutX(200);
	    botoes.setLayoutY(90);
	    
	    rootGroup.getChildren().add(botoes);
	    rootGroup.getChildren().add(text);

	}

}
