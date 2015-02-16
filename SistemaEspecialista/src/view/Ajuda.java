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
		
		TitledPane t1 = new TitledPane("Usu�rio", new Text("Nesta aba voc� vai encontrar o melhor pacote para determinadas condi��es."+"\n"+"\n"
				+ "Instru��es: " + "\n" + "\n" + "- V� na aba Usu�rio e clique em Executar. "+"\n"+"- Clique em Iniciar execu��o e encontre o melhor pacote para voc�!")); 
		TitledPane t2 = new TitledPane("Especialista", new Text("Acesso restrito ao especialista, est� aba � encarregada de cadastrar os pacotes tur�sticos."+"\n"+"\n"
				+ "Abas: " + "\n" + "\n" + "- Nova Regra "+"\n"+"	- Cadastra um novo pacote tur�sticos. "+"\n"+ "\n" + "- Regras: " +"\n" + "	-  Visualize todas as regras cadastradas."));
     
		 
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
