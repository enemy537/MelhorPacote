package view;

import javafx.geometry.Pos;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Sobre extends BorderPane {

	
    
    public Sobre(){

            ImageView iconeSobre = new ImageView("/image/desenvolvimento.jpg");
            //Text sobre = new Text("Sobre");
            //sobre.setFont(new Font(40));

            HBox titulo = new HBox(35);
            titulo.getChildren().addAll(iconeSobre);
            
            titulo.setTranslateY(getScaleY()+40);
            titulo.setAlignment(Pos.TOP_CENTER);
            
            MenuGeral menu = new MenuGeral();
            StackPane stack = new StackPane();
            
            stack.getChildren().addAll(titulo,menu);
            setCenter(stack);
            setTop(menu);

            
    }

}
