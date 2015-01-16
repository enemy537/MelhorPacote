package app;

import java.util.ArrayList;

import banco.Banco;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.TelaPrincipal;
import model.Motor;
import model.Premissa;
import model.Regra;

public class Main extends Application{
	
	private Scene scene;
	private static Banco bd;
	
	public static Banco getBanco(){
		return bd;
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		if(bd == null){
			bd = new Banco();	
		}
		
		TelaPrincipal root = new TelaPrincipal();
		scene = new Scene(root,1200,500, Color.LIGHTGRAY);
		
		primaryStage.setTitle("Melhor Pacote");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent arg0) {
				bd.close();
			}
		});
			
	}

	public static void main(String[] args) {
		Motor motor = new Motor();
		
		Regra r1 = new Regra("AL", "FRIO",3,5000,"Argentina", 54);
		Regra r2 = new Regra("AL", "FRIO",3,5000,"França", 12);
		Regra r3 = new Regra("SP","CALOR",5,2000,"Nordeste", 89);
		
		ArrayList<Regra> regras = new ArrayList<Regra>();
		regras.add(r1); regras.add(r2); regras.add(r3);
		
		motor.setRegras(regras);
		
		Premissa premissa = new Premissa("AL", "FRIO",3,5000);
		
		motor.setPremissa(premissa);
		
		System.out.println(regras);
		launch(args);
	}

}
