package view;

import java.text.ParseException;

import banco.Banco;
import app.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuGeral extends MenuBar {
	public MenuGeral(){
		
		Menu usuario = new Menu("Usuário");
		Menu especialista = new Menu("Especialista");
		Menu ajuda = new Menu("Ajuda");
		
		
		//Parte de Usu�rio
		MenuItem executar = new MenuItem("Executar");
		
		//Parte de Especialista
		MenuItem novaRegra = new MenuItem("Nova Regra");
		MenuItem regras = new MenuItem("Regras");

		//Parte de Ajuda
		MenuItem guiaTuristico = new MenuItem("Guia Turístico");
		MenuItem desenvolvedores = new MenuItem("Desenvolvedores");
		
		usuario.getItems().addAll(executar);
		especialista.getItems().addAll(novaRegra,regras);
		ajuda.getItems().addAll(guiaTuristico, desenvolvedores);
		
		getMenus().addAll(usuario,especialista,ajuda);
		
		
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
		
		guiaTuristico.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new Ajuda());
				
			}
		});
		
		desenvolvedores.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				getScene().setRoot(new Sobre());
				
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
