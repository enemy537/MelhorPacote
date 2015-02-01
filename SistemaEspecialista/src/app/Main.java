package app;

import java.util.Arrays;
import banco.Banco;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.TelaPrincipal;
import model.BaseRegras;
import model.Conector;
import model.Fato;
import model.Motor;
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
//		Conector e = new Conector("E");
//		Conector ou = new Conector("OU");
//		Conector entao = new Conector("ENTÃO");
//		
//		Fato A = new Fato("A");Fato B = new Fato("B");Fato C = new Fato("C");
//		Fato D = new Fato("D");Fato E = new Fato("E");Fato F = new Fato("F");
//		
//		Object r1[] = {A,entao,B};
//		Regra regra1 = new Regra(Arrays.asList(r1));
//		Object r2[] = {A,entao,C};
//		Regra regra2 = new Regra(Arrays.asList(r2));
//		Object r3[] = {B,e,C,entao,D};
//		Regra regra3 = new Regra(Arrays.asList(r3));
//		Object r4[] = {D,ou,A,entao,E};
//		Regra regra4 = new Regra(Arrays.asList(r4));
//		Object r5[] = {B,entao,F};
//		Regra regra5 = new Regra(Arrays.asList(r5));
//		
//		BaseRegras regras = new BaseRegras();
//		regras.adicionar(regra1); regras.adicionar(regra2); regras.adicionar(regra3);
//		regras.adicionar(regra4); regras.adicionar(regra5);
//		
//		Motor motor = new Motor(regras);
//		System.out.println(motor.inferencia(new Fato("E")));
		
		launch(args);
	}

}
