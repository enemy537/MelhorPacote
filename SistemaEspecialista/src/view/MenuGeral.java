package view;

import java.text.ParseException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuGeral extends MenuBar {
	public MenuGeral(){
		
		Menu usuario = new Menu("Usu·rio");
		Menu especialista = new Menu("Especialista");
		Menu ajuda = new Menu("Ajuda");
		Menu sobre = new Menu("Sobre");
		
		//Parte de Usu√°rio
		MenuItem executar = new MenuItem("Executar");
		
		//Parte de Especialista
		MenuItem novaRegra = new MenuItem("Nova Regra");
		MenuItem regras = new MenuItem("Regras");

		usuario.getItems().addAll(executar);
		especialista.getItems().addAll(novaRegra,regras);
		
		
		getMenus().addAll(usuario,especialista,ajuda,sobre);
		
		
		novaRegra.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new CadastrarRegra());
			}
		});
		
		regras.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new ListarRegras());
				
			}
		});
		
		ajuda.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new Ajuda());
				
			}
		});
		
		executar.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new Executar());
				
			}
		});
	}
}
