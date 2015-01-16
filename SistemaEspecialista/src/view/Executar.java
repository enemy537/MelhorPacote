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

public class Executar extends BorderPane{
	
	private ObservableList<String> destinoLista, origemLista, qtdPassLista, orcamentoLista;
	private ComboBox<String> destino, origem, qtdPassageiros, orcamento;
	private Label titulo, destinoTitle, origemTitle, qtdPassTitle, orcTitle;
	private Button ir, cancelar;
	
	public Executar(){
		
		destinoLista = FXCollections.observableArrayList("Maceio", "Palmeira");
		origemLista = FXCollections.observableArrayList("Miami", "Breu");
		qtdPassLista = FXCollections.observableArrayList("1", "2", "3");
		orcamentoLista = FXCollections.observableArrayList("Menos de R$ 800", "Entre R$ 800 e R$ 1500", "Mais de R$ 2000");
		
		MenuGeral vboxtop = new MenuGeral();
		Banco banco = Main.getBanco();
		
		destinoTitle = new Label("Para onde você quer ir ?");
		destino = new ComboBox();
		destino.setItems(destinoLista);
		destino.setPromptText("Destino");
		
		origemTitle = new Label("Saindo de onde ?");
		origem = new ComboBox();
		origem.setItems(origemLista);
		origem.setPromptText("Origem");
		
		qtdPassTitle = new Label("Quantas pessoas vão ?");
		qtdPassageiros = new ComboBox();
		qtdPassageiros.setItems(qtdPassLista);
		qtdPassageiros.setPromptText("Quantidade de Passageiros");
		
		orcTitle = new Label("Quer gastar quanto ?");
		orcamento = new ComboBox();
		orcamento.setItems(orcamentoLista);
		orcamento.setPromptText("Orçamento");
		
		ir = new Button("Tácalhepau");
		cancelar = new Button("Cancelar");
		
		
		VBox vbox1 = new VBox(20);
		vbox1.getChildren().addAll(destinoTitle, destino);
		vbox1.setAlignment(Pos.CENTER);
		
		VBox vbox2 = new VBox(20);
		vbox2.getChildren().addAll(origemTitle, origem);
		vbox2.setAlignment(Pos.CENTER);
		
		VBox vbox3 = new VBox(20);
		vbox3.getChildren().addAll(qtdPassTitle, qtdPassageiros);
		vbox3.setAlignment(Pos.CENTER);
		
		VBox vbox4 = new VBox(20);
		vbox4.getChildren().addAll(orcTitle, orcamento);
		vbox4.setAlignment(Pos.CENTER);
		
		VBox botoes = new VBox(20);
		botoes.getChildren().addAll(ir, cancelar);
		botoes.setAlignment(Pos.CENTER);
				
		HBox hboxGeral = new HBox(50);
		hboxGeral.getChildren().addAll(vbox1, vbox2, vbox3, vbox4, botoes);
		hboxGeral.setPadding(new Insets(10,100,10,100));
				
		setCenter(hboxGeral);
		setTop(vboxtop);     //Setando menuBar sempre no topo
	}
}
