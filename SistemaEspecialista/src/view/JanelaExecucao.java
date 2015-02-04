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

public class JanelaExecucao extends BorderPane {

	private Button sim,nao;
	
	public boolean JanelaExecucao() {

		final Stage stage = new Stage();

        //create root node of scene, i.e. group

        Group rootGroup = new Group();

        //create scene with set width, height and color

        Scene scene = new Scene(rootGroup, 500, 200, Color.WHITESMOKE);

        //set scene to stage

        stage.setScene(scene);

        //center stage on screen

        stage.centerOnScreen();

        //show the stage

        stage.show();

        //add some node to scene
        
        
        Text text = new Text(10, 50, "Voc� gosta de praia?");

        text.setFill(Color.DODGERBLUE);
        
        text.setX(160);
        text.setEffect(new Lighting());

        text.setFont(Font.font(Font.getDefault().getFamily(), 20));
        
        sim = new Button("Sim");
        nao = new Button("N�o");
        
        
        
        HBox botoes = new HBox(20);
        botoes.getChildren().addAll(sim,nao);
        botoes.setLayoutX(200);
        botoes.setLayoutY(90);
        
        //add text to the main root group
        rootGroup.getChildren().add(botoes);
        rootGroup.getChildren().add(text);
        
        return true;
            
	}
}
