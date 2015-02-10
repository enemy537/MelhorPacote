package view;

import java.util.ArrayList;

import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import model.Fato;
import model.Motor;
import banco.Banco;
import EDU.purdue.cs.bloat.tree.SRStmt;
import app.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Executar extends BorderPane{
	
	private Button iniciar;
	private Motor motor;
	
	public Executar(){
		
		MenuGeral vboxtop = new MenuGeral();
		Banco banco = Main.getBanco();
		
		iniciar = new Button("Iniciar execução");
		
		iniciar.setOnAction(new EventHandler() {
			
			@Override
			public void handle(Event arg0) {
				motor = new Motor(banco.listarRegras());
				motor.limparMemoria();
				ArrayList<Object> retorno = motor.novaPergunta();
				while(true){
					if(retorno.size() == 2 && ((Fato)retorno.get(0)).getValor() == true){
						Dialogs.create()
						.title("Melhor Pacote para você")
						.masthead(null)
						.message(((Fato)retorno.get(0)).toString())
						.showInformation();
						break;
					}else if(retorno.size() == 2 && ((Fato)retorno.get(0)).getValor() == false){
						retorno = motor.novaPergunta();
					}else{
						Dialogs.create()
						.title("Nenhum pacote encontrado.")
						.masthead(null)
						.message("Nenhum pacote se adequa a suas necessidades.")
						.showInformation();
						break;
					}
				}
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
