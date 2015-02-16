package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import banco.Banco;
import app.Main;
import model.Conector;
import model.Fato;
import model.Regra;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CadastrarRegra extends BorderPane{
	
	private TextField texto;
	private Label se, ajuda, exemplo;
	private Button salvar, cancelar;
	private Banco banco = Main.getBanco();
	private final ProgressIndicator pi;
	
	public Regra trataString(String stringOriginal){
		
		ArrayList<Object> lista = new ArrayList<Object>();
		
		String conclusao = stringOriginal.split("ENTAO")[1];
		
		String[] stringComSplit = stringOriginal.split(" ");
		
		String premissa = "";
		
		for (String string : stringComSplit) {
			
			if (!(string.equals("E") || string.equals("OU") || string.equals("ENTAO"))) {
				premissa += string + " ";
			} else {
				Fato f = new Fato(premissa);
				lista.add(f);
				
				Conector c = new Conector(string);
				lista.add(c);
				
				premissa = "";
			}
		}
		
		Fato concl = new Fato(conclusao);
		lista.add(concl);
			
		Regra r = new Regra(lista, (float)pi.getProgress());
		return r;
	}
	//private void limpaCampos() {
      //  texto.setText("");
        
//}
	public CadastrarRegra(){
		
		MenuGeral vboxtop = new MenuGeral();
		Banco banco = Main.getBanco();
		
		ajuda = new Label("Utilize 'E', 'OU' e 'ENTAO' como conectores");
		exemplo = new Label("Ex.: SE gosta de praia OU quer gastar ate R$ 500 ENTAO pacote = X");
		se = new Label("Se");
		
		texto = new TextField();
		texto.setMinSize(600,30);

		salvar = new Button("Salvar");
		cancelar = new Button("Cancelar");
		
		Text fc = new Text("Fator de Confianca:  ");
		
		final Slider slider = new Slider();
		slider.setMin(0);
        slider.setMax(100);
        
        pi = new ProgressIndicator(0);
 
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                pi.setProgress(new_val.doubleValue()/100);
            }
        });
        slider.setMax(100);
        
        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(fc,slider,pi);
		
		
		
		cancelar.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new TelaPrincipal());
			}
		});
		
		salvar.setOnAction(new EventHandler() {
			
			@Override
			public void handle(Event arg0) {
				banco.addObjeto(trataString(texto.getText()));
				texto.setText("");
			}
		});
		
		HBox hbox1 = new HBox(10);
		hbox1.getChildren().addAll(se, texto);
		
		HBox hbox2 = new HBox(10);
		hbox2.getChildren().addAll(salvar,cancelar);
					
		VBox vbox = new VBox(30);
		vbox.getChildren().addAll(ajuda,exemplo,hbox1,hbox2,hbox);

		hbox.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
				
		vbox.setPadding(new Insets(10,100,10,100));
				
		setCenter(vbox);
		setTop(vboxtop);     //Setando menuBar sempre no topo
	}
	
	
}
