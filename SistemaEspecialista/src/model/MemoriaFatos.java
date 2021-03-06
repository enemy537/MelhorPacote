package model;

import java.util.ArrayList;

public class MemoriaFatos {
	private ArrayList<Fato> lista;
	
	public MemoriaFatos(){
		this.lista = new ArrayList<Fato>();
	}
	public void clear(){
		this.lista.clear();
	}
	public void inserir(Fato fato){
		this.lista.add(fato);
	}
	public Fato busca(Fato fato){
		Fato retorno = null;
		if(this.lista.contains(fato)){
			retorno = fato;
		}
		return retorno;
	}
	public Fato retorna(Fato fato){
		Fato retorno = null;
		for(Fato fato_ : this.lista){
			if(fato_.equals(fato)){
				return fato_;
			}
		}
		return retorno;
	}
	
	public ArrayList<Fato> getFatos(){
		return this.lista;
	}
	@Override
	public String toString() {
		String retorno = "";
		for(Fato fato : this.lista){
			retorno += fato+"\n";
		}
		return retorno;
	}
}
