package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Motor {
	private ObservableList<Regra> regras;
	private Premissa premissa;
	
	public Motor() {
		this.regras = FXCollections.observableArrayList();
	}
	
	public void clean(){
		this.regras.clear();
		this.premissa = null;
	}
	public void getRegras(ArrayList<Regra> regras){
		this.regras.addAll(regras);
	}
	
	public Regra buscaAND(){
		
	}
}
