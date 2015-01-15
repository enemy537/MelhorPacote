package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Regra extends Premissa {
	
	private StringProperty pacote;
	private FloatProperty fatorConfianca;
	
	public Regra(String origem, String destino, int qtdPassageiros, float orcamento,
			String pacote, float fatorConfianca) {
		
		super(origem, destino, qtdPassageiros, orcamento);
		this.pacote = new SimpleStringProperty(pacote);		
		this.fatorConfianca = new SimpleFloatProperty(fatorConfianca);
	}
	
	public StringProperty getPacoteProperty() {
		return pacote;
	}
	public FloatProperty getFatorConfiancaProperty() {
		return fatorConfianca;
	}

	
	public String getPacote() {
		return pacote.get();
	}
	public void setPacote(String pacote) {
		this.pacote.set(pacote);
	}
	public float getFatorConfianca() {
		return fatorConfianca.get();
	}
	public void setFatorConfianca(float fatorConfianca) {
		this.fatorConfianca.set(fatorConfianca);
	}
	
	public boolean comparar(Premissa premissa){
		return (this.getOrigem().equals(premissa.getOrcamento()) &&
		    this.getDestino().equals(premissa.getDestino()) &&
		    this.getQtdPassageiros() == premissa.getQtdPassageiros() &&
		    this.getOrcamento() == premissa.getOrcamento());
	}

	@Override
	public String toString() {
		return "Regra ["+this.getOrigem()+", "+this.getDestino()
				+", "+this.getQtdPassageiros()+", "+this.getOrcamento()
				+", "+this.getPacote()+", "+this.getFatorConfianca()+"]";
	}
	
	
}