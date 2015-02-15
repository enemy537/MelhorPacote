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
	private float fatorCerteza;

	private ObservableList<Object> expressao;
	
	public Regra(List<Object> expressao){
		this.expressao = FXCollections.observableArrayList();
		for(Object obj : expressao){
			this.expressao.add(obj);
		}
		this.fatorCerteza = 0;
	}
	public ArrayList<Fato> getPremissas(){
		ArrayList<Fato> premissas = new ArrayList<Fato>();
		Fato fato = new Fato("");
		for(Object obj : this.expressao){
			if (obj.getClass() == fato.getClass()){
				if(!obj.equals(this.expressao.get(this.expressao.size()-1)))
					premissas.add((Fato)obj);
			}
		}
		return premissas;
	}
	public ArrayList<Conector> getConectores(){
		ArrayList<Conector> conectores = new ArrayList<Conector>();
		Conector conector = new Conector("");
		for(Object obj : this.expressao){
			if (obj.getClass() == conector.getClass()){
				if(!obj.equals(this.expressao.get(this.expressao.size()-2)))
					conectores.add((Conector)obj);
			}
		}
		return conectores;
	}
	
	public Fato getConclusao(){
		return (Fato) this.expressao.get(expressao.size()-1);
	}

	public ObservableList<Object> getExpressao() {
		return expressao;
	}
	
	public void setFato(Fato fato){
		int contador = 0;
		for(Object obj : this.expressao){
			if(obj.getClass() == fato.getClass() && ((Fato)obj).equals(fato)){
				expressao.set(contador, fato);
			}
			contador++;
		}
	}
	
	public float getFatorCerteza() {
		return fatorCerteza;
	}

	public void setExpressao(ObservableList<Object> expressao) {
		this.expressao = expressao;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Object object : expressao) {
			str += object.toString() + " ";
		}
		return str;
	}
}