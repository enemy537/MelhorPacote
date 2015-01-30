package model;

import java.util.ArrayList;

public class BaseRegras {
	private ArrayList<Regra> regras;
	
	public BaseRegras(){
		this.regras = new ArrayList<Regra>();
	}

	public void adicionar(Regra regra){
		this.regras.add(regra);
	}
	public Regra buscaConclusao(Fato fato){
		for(Regra regra : this.regras){
			if(regra.getExpressao().get(regra.getExpressao().size()-1).equals(fato)){
				return regra;
			}
		}
		return null;
	}
}
