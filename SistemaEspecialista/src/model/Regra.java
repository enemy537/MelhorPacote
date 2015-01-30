package model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Regra {
	private ObservableList<Object> expressao;
	
	public Regra(List<Object> expressao){
		this.expressao = FXCollections.observableArrayList();
		for(Object obj : expressao){
			this.expressao.add(obj);
		}
	}
	public ArrayList<Fato> getPremissas(){
		ArrayList<Fato> premissas = new ArrayList<Fato>();
		for(Object obj : this.expressao){
			if (obj.getClass() == new Fato("").getClass()){
				if(!obj.equals(this.expressao.get(this.expressao.size()-1)))
					premissas.add((Fato)obj);
			}
		}
		return premissas;
	}
	
	public Fato getConclusao(){
		return (Fato) this.expressao.get(expressao.size()-1);
	}

	public ObservableList<Object> getExpressao() {
		return expressao;
	}

	public void setExpressao(ObservableList<Object> expressao) {
		this.expressao = expressao;
	}
	
	
}