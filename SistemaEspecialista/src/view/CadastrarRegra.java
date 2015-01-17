package view;

import banco.Banco;
import app.Main;
import model.Regra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class CadastrarRegra extends BorderPane{
	
	private TextField origem, destino,qtdPassageiros, orcamento, pacote, fatorConfianca;
	private Label se, e, e1, e2, entao;
	private Button salvar, cancelar;
	
	public CadastrarRegra(){
		
		MenuGeral vboxtop = new MenuGeral();
		Banco banco = Main.getBanco();
		
		se = new Label("Se");
		
		origem = new TextField();
		origem.setPromptText("Origem");
		
		e = new Label("e");
		
		destino = new TextField();
		destino.setPromptText("Destino");
		
		e1 = new Label("e");
		
		qtdPassageiros = new TextField();
		qtdPassageiros.setPromptText("Qtd de Passageiros");
		
		e2 = new Label("e");
		
		orcamento = new TextField();
		orcamento.setPromptText("Orçamento");
		
		entao = new Label("Então:");
		
		pacote = new TextField();
		pacote.setPromptText("Pacote");
		
		fatorConfianca = new TextField();
		fatorConfianca.setPromptText("Fator Confiança");

		salvar = new Button("Salvar");
		cancelar = new Button("Cancelar");
		
		cancelar.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new TelaPrincipal());
			}
		});
		
		salvar.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				System.out.println(qtdPassageiros.getText());
				Regra regra = new Regra(origem.getText(), destino.getText(), Integer.parseInt(qtdPassageiros.getText()), Float.parseFloat(orcamento.getText()), pacote.getText(), Float.parseFloat(fatorConfianca.getText()));
				banco.addObjeto(regra);
			}
		});
		
		HBox hbox1 = new HBox(10);
		hbox1.getChildren().addAll(se, origem,e, destino,e1, qtdPassageiros,e2, orcamento);
		
		HBox hbox2 = new HBox(10);
		hbox2.getChildren().addAll(entao, pacote, fatorConfianca);
		
		HBox hbox3 = new HBox(10);
		hbox3.getChildren().addAll(salvar, cancelar);
					
		VBox vbox = new VBox(30);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3);
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
				
		vbox.setPadding(new Insets(10,100,10,100));
				
		setCenter(vbox);
		setTop(vboxtop);     //Setando menuBar sempre no topo
	}
}
