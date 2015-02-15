package view;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Pergunta extends BorderPane{
	
	private Stage stage;
	private Group rootGroup;
	private Scene scene;
	private Text text, fc, ajuda;
	private Button ok;
	private TextField campo;
	
	public Boolean decisao;

	public Pergunta(String pergunta){
		stage = new Stage();
		rootGroup = new Group();
		scene = new Scene(rootGroup, 600, 300, Color.WHITESMOKE);
		
		stage.initModality(Modality.WINDOW_MODAL);
		
		campo = new TextField();
		campo.setPromptText("SIM ou NAO");
		
		fc = new Text("Fator de Confiaça:  ");
		
		final Slider slider = new Slider();
		slider.setMin(0);
        slider.setMax(100);
        
        final ProgressIndicator pi = new ProgressIndicator(0);
 
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                pi.setProgress(new_val.doubleValue()/50);
            }
        });
        
        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(fc,slider,pi);
		
		ok = new Button("OK");
		
		ok.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				try {
					String resposta = campo.getText().toUpperCase();
					
					
					if (resposta.equals("") || (!resposta.equals("SIM") && !resposta.equals("NAO"))) {
						
						new TelaAux("Resposta inválida! Responda com SIM ou NAO");
					} else {
						stage.close();
						
					}
				} catch (Exception e) {
					new TelaAux("Resposta inválida!");
				}
			}
		});
		
		ajuda = new Text(10,10, "Responda com SIM ou NAO");
	    
	    text = new Text(10, 50, pergunta);
	    text.setFill(Color.DODGERBLUE);
	    
	    text.setTextAlignment(TextAlignment.CENTER);
	    text.setEffect(new Lighting());

	    text.setFont(Font.font(Font.getDefault().getFamily(), 20));
	    
	    VBox vbox = new VBox(20);
	    vbox.getChildren().addAll(text,ajuda,campo,hbox,ok);
	    vbox.setAlignment(Pos.CENTER);
	    vbox.setTranslateX(160);
	    
	    rootGroup.getChildren().add(vbox);
	
	    
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
