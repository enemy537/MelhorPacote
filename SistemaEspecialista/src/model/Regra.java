package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

public class Regra extends Premissa {
	
	private StringProperty pacote;
	private FloatProperty fatorConfianca;
	
	public Regra(String origem, String destino, int qtdPassageiros, float orcamento,
			String pacote, int fatorConfianca) {
		
		super(origem, destino, qtdPassageiros, orcamento);
		this.pacote.set(pacote);
		this.fatorConfianca.set(fatorConfianca);
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
}