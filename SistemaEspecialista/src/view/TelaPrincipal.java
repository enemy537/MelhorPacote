package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TelaPrincipal extends BorderPane{
	
	public TelaPrincipal() {
		MenuGeral menu = new MenuGeral();	
				
		VBox vbox = new VBox(20);
		vbox.getChildren().add(menu);

		setTop(vbox);
	}

}
