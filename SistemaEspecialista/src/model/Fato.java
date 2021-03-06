package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fato {
	private float fatorCerteza;
	private StringProperty nome;
	private Boolean valor;
	
	public Fato(String nome){
		this.nome = new SimpleStringProperty();
		this.nome.setValue(nome);
		this.valor = false;
		this.fatorCerteza = 0f;
	}
	
	public Boolean getValor() {
		return valor;
	}

	public void setValor(Boolean valor) {
		this.valor = valor;
	}

	public final StringProperty nomeProperty() {
		return this.nome;
	}


	public final java.lang.String getNome() {
		return this.nomeProperty().get();
	}

	public final void setNome(final java.lang.String nome) {
		this.nomeProperty().set(nome);
	}
	
	public float getFatorCerteza() {
		return fatorCerteza;
	}
	
	public void setFatorCerteza(float fatorCerteza) {
		this.fatorCerteza = fatorCerteza;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != this.getClass())
			return false;
		Fato temp = (Fato) obj;
		return this.getNome().equals(temp.getNome());
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
