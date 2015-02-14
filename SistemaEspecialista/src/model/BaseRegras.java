package model;

import java.util.ArrayList;

public class BaseRegras {
	private ArrayList<Regra> regras;
	
	public BaseRegras(){
		this.regras = new ArrayList<Regra>();
	}
	public BaseRegras(ArrayList<Regra> regras){
		this.regras = regras;
	}

	public void adicionar(Regra regra){
		this.regras.add(regra);
	}
	
	public void alterarFatos(ArrayList<Fato> fatos){
		int contadorRegras = 0;
		for(Regra regra : this.regras){
			for(Fato fato : fatos){
				if(regra.getPremissas().contains(fato) || regra.getConclusao() == fato){
					Regra novaRegra =  this.regras.get(contadorRegras);
					novaRegra.setFato(fato);
					this.regras.set(contadorRegras, novaRegra);
				}
			}
			contadorRegras++;
		}
	}
	
	public Regra buscaConclusao(Fato fato){
		for(Regra regra : this.regras){
			if(regra.getExpressao().get(regra.getExpressao().size()-1).equals(fato)){
				return regra;
			}
		}
		return null;
	}
	
	public ArrayList<Regra> copia(){
		ArrayList<Regra> copia = new ArrayList<Regra>();
		for(Regra regra : this.regras){
			copia.add(regra);
		}
		return copia;
	}

	public ArrayList<Regra> getRegras() {
		return regras;
	}
	
	@Override
	public String toString() {
		String retorno = "";
		for(Regra regra : this.regras){
			retorno += regra.toString() + "\n";
		}
		return retorno;
	}
}
