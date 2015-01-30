package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conector {
	private StringProperty valor;
	
	public Conector(String valor){
		this.valor = new SimpleStringProperty();
		this.valor.set(valor);
	}

	public final StringProperty valorProperty() {
		return this.valor;
	}

	public final java.lang.String getValor() {
		return this.valorProperty().get();
	}

	public final void setValor(final java.lang.String valor) {
		this.valorProperty().set(valor);
	}
	
	
}
