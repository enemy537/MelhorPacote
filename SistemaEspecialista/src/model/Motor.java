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
	public void setRegras(ArrayList<Regra> regras){
		this.regras.addAll(regras);
	}
	public void setPremissa(Premissa premissa){
		this.premissa = premissa;
	}
	
	public ObservableList<Regra> buscaAND(){
		ObservableList<Regra> retorno = FXCollections.observableArrayList();
		for(Regra regra : this.regras){
			if(regra.comparar(premissa))
				retorno.add(regra);
		}
		return retorno;
	}
}
