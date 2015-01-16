package view;

import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Ajuda extends BorderPane{
	
	public Ajuda(){
		
		MenuGeral menu = new MenuGeral();
		
		TitledPane t1 = new TitledPane("Cadastrar", new Text("Nesta aba você pode cadastrar um paciente, sócio, doação ou depesa referente a ONG."+"\n"+"\n"
				+ "Instruções: " + "\n" + "\n" + "- Clique na opção cadastrar "+"\n"+"- Escolha uma das possibilidades "+"\n"+"- Preencha os campos corretamente"+"\n"+"- Clique no botão cadastrar"));
      
		TitledPane t2 = new TitledPane("Consultar", new Text("Com esta função você consulta os pacientes ou sócios cadastrados e suas respectivas informações."+"\n"+"\n"
				+ "Instruções: " + "\n" + "\n" + "- Clique na opção consultar "+"\n"+"- Escolha entre Paciente ou Sócio "+"\n"+"- Busque o desejado"));
     
		TitledPane t3 = new TitledPane("Finanças", new Text("			Aqui você pode listar as doações e despesas com seus valores, descrições e meses, acessar um gráfico financeiro			" + "\n" + "	    anual ou visualizar as informações gerais da ONG."+"\n"+"\n"
				+ "            Instruções: " + "\n" + "\n" + "            - Clique na opção Finanças "+"\n"+"            - Escolha uma das opções "+"\n"+"            - Veja o controle financeiro"));
     
		Accordion accordion = new Accordion();
        accordion.getPanes().add(t1);
        accordion.getPanes().add(t2);
        accordion.getPanes().add(t3);
        
        accordion.setMaxSize(500, 500);
        accordion.setTranslateY(getScaleY()+50);
        
        VBox vbox = new VBox(30);
		vbox.getChildren().addAll(accordion);
		vbox.setAlignment(Pos.CENTER);
		
		setCenter(vbox);
		setTop(menu);
		
	}
	
}
