package view;

import java.util.ArrayList;

import banco.Banco;
import app.Main;
import model.Regra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Executar extends BorderPane{
	
	private Button iniciar,sim,nao;
	
	public Executar(){
		
		MenuGeral vboxtop = new MenuGeral();
		Banco banco = Main.getBanco();
		
		iniciar = new Button("Iniciar execução");
		
		iniciar.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
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
                
                
                Text text = new Text(10, 50, "Você gosta de praia?");

                text.setFill(Color.DODGERBLUE);
                
                text.setX(160);
                text.setEffect(new Lighting());

                text.setFont(Font.font(Font.getDefault().getFamily(), 20));
                
                sim = new Button("Sim");
                nao = new Button("Não");
                
                HBox botoes = new HBox(20);
                botoes.getChildren().addAll(sim,nao);
                botoes.setLayoutX(200);
                botoes.setLayoutY(90);
                
                //add text to the main root group
                rootGroup.getChildren().add(botoes);
                rootGroup.getChildren().add(text);
                
	
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
