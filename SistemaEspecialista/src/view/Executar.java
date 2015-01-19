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
import javafx.stage.Stage;

public class Executar extends BorderPane{
	
	private ObservableList<String> destinoLista, origemLista, qtdPassLista, orcamentoLista;
	private ComboBox<String> destino, origem, qtdPassageiros, orcamento;
	private Label titulo, destinoTitle, origemTitle, qtdPassTitle, orcTitle;
	private Button ir, cancelar;
	
	public Executar(){
		
		MenuGeral vboxtop = new MenuGeral();
		Banco banco = Main.getBanco();

		
		if (destinoLista == null) {
			destinoLista = FXCollections.observableArrayList("Nenhum destino cadastrado");
		}else {destinoLista = FXCollections.observableArrayList(banco.listarDestinos());}
		
		if (origemLista == null){
			origemLista = FXCollections.observableArrayList("Nenhuma origem cadastrada");
		}else {origemLista = FXCollections.observableArrayList(banco.listarOrigens());}
		
		qtdPassLista = FXCollections.observableArrayList("1","2","3","4","5","6","7");
		orcamentoLista = FXCollections.observableArrayList("Menos de R$ 800", "Entre R$ 800 e R$ 1500", "Mais de R$ 2000");
		
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
		
		ir = new Button("Gerar pacote");
		cancelar = new Button("Cancelar");
		
		ir.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				final Stage stage = new Stage();

                //create root node of scene, i.e. group

                Group rootGroup = new Group();

                //create scene with set width, height and color

                Scene scene = new Scene(rootGroup, 500, 400, Color.WHITESMOKE);

                //set scene to stage

                stage.setScene(scene);

                //center stage on screen

                stage.centerOnScreen();

                //show the stage

                stage.show();

                //add some node to scene

                Text text = new Text(10, 50, "O melhor pacote para você é:");

                text.setFill(Color.DODGERBLUE);
                
                text.setEffect(new Lighting());

                text.setFont(Font.font(Font.getDefault().getFamily(), 20));
                

                //add text to the main root group

                rootGroup.getChildren().add(text);
				
			}
		});
		
		cancelar.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new TelaPrincipal());
				
			}
		});
		
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
				
		HBox hboxGeral = new HBox(30);
		hboxGeral.getChildren().addAll(vbox1, vbox2, vbox3, vbox4, botoes);
		hboxGeral.setPadding(new Insets(10,100,10,100));
				
		setCenter(hboxGeral);
		setTop(vboxtop);     //Setando menuBar sempre no topo
	}
}
