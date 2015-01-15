package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Premissa {
	private StringProperty origem;
	private StringProperty destino;
	private IntegerProperty qtdPassageiros;
	private FloatProperty orcamento;
	
	public Premissa(String origem, String destino, int qtdPassageiros, float orcamento){
		this.origem = new SimpleStringProperty(origem);
		this.destino = new SimpleStringProperty(destino);
		this.qtdPassageiros = new SimpleIntegerProperty(qtdPassageiros);
		this.orcamento = new SimpleFloatProperty(orcamento);
	}
	
	public StringProperty getOrigemProperty() {
		return origem;
	}
	public StringProperty getDestinoProperty() {
		return destino;
	}
	public IntegerProperty getQtdPassageirosProperty() {
		return qtdPassageiros;
	}
	public FloatProperty getOrcamentoProperty() {
		return orcamento;
	}
	public String getOrigem() {
		return origem.get();
	}
	public void setOrigem(String origem) {
		this.origem.set(origem);
	}
	public String getDestino() {
		return destino.get();
	}
	public void setDestino(String destino) {
		this.destino.set(destino);
	}
	public int getQtdPassageiros() {
		return qtdPassageiros.get();
	}
	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros.set(qtdPassageiros);
	}
	public float getOrcamento() {
		return orcamento.get();
	}
	public void setOrcamento(float orcamento) {
		this.orcamento.set(orcamento);
	}
	@Override
	public String toString() {
		return "Regra ["+this.getOrigem()+", "+this.getDestino()
				+", "+this.getQtdPassageiros()+", "+this.getOrcamento()+"]";
	}
	
}
