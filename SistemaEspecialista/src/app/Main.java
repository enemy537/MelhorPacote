package app;

import banco.Banco;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.TelaPrincipal;

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
		primaryStage.getIcons().add(new Image("/image/logo.png"));
        primaryStage.show();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent arg0) {
				bd.close();
			}
		});
			
	}

	public static void main(String[] args) {
		launch(args);
	}

}
