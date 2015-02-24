package view;

import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Ajuda extends BorderPane{
	
public Ajuda(){
		
		MenuGeral menu = new MenuGeral();

		TitledPane t1 = new TitledPane("Usuário", new Text("Nesta aba você vai encontrar o melhor pacote para determinadas condições."+"\n"+"\n"
				+ "Instruções: " + "\n" + "\n" + "- Clique na aba Usuário, depois clique na subseção em Executar. "+"\n"+"- Clique no botão Iniciar busca de melhor pacote e encontre o melhor pacote para você!")); 
		TitledPane t2 = new TitledPane("Especialista", new Text("Seção do especialista, está aba é encarregada de cadastrar os pacotes turísticos e regras já cadastradas."+"\n"+"\n"
				+ "Abas: " + "\n" + "\n" + "- Nova Regra "+"\n"+"	- Cadastra um novo pacote turísticos. "+"\n"+ "\n" + "- Regras: " +"\n" + "	-  Visualize todas as regras cadastradas."));

     
		 
		Accordion accordion = new Accordion();
        accordion.getPanes().add(t1);
        accordion.getPanes().add(t2);
        
        
        accordion.setMaxSize(500, 500);
        accordion.setTranslateY(getScaleY()-100);
        
        VBox vbox = new VBox(20);
		vbox.getChildren().addAll(accordion);
		vbox.setAlignment(Pos.CENTER);
		
		setCenter(vbox);
		setTop(menu);
		
	}
	
}
