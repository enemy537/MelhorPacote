package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Pergunta extends BorderPane{
	
	private Stage stage;
	private Group rootGroup;
	private Scene scene;
	private Text text;
	private Button ok;
	private TextField campo;
	
	public Boolean decisao;

	public Pergunta(String pergunta){
		stage = new Stage();
		rootGroup = new Group();
		scene = new Scene(rootGroup, 500, 200, Color.WHITESMOKE);
		
		stage.initModality(Modality.WINDOW_MODAL);
		
		campo = new TextField();
		campo.setPromptText("SIM ou NAO");
		ok = new Button("OK");
		
		ok.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stage.close();
			}
		});
		
		
	    
	    text = new Text(10, 50, pergunta);
	    text.setFill(Color.DODGERBLUE);
	    
	    text.setX(160);
	    text.setEffect(new Lighting());

	    text.setFont(Font.font(Font.getDefault().getFamily(), 20));
	    
	    HBox botoes = new HBox(20);
	    botoes.getChildren().addAll(campo,ok);
	    botoes.setLayoutX(200);
	    botoes.setLayoutY(90);
	    
	    rootGroup.getChildren().add(botoes);
	    rootGroup.getChildren().add(text);
	    
	    stage.setScene(scene);
	    stage.centerOnScreen();
	    stage.showAndWait();
	    
	    if (campo.getText().equals("SIM")) {
			decisao = true;
		}else {
			decisao = false;
		}
	    
	    
	}
	public Boolean getDecisao() {
		return decisao;
	}

	
}
