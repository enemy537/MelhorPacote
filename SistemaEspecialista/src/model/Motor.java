package model;

import java.util.ArrayList;
import java.util.Scanner;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.Pergunta;
import bsh.EvalError;
import bsh.Interpreter;

public class Motor {
	private BaseRegras baseRegras;
	private MemoriaFatos memoriaFatos;
	private Interpreter interpretador;
	private int regrasRestantes;
	
	public Motor(BaseRegras baseRegras){
		this.baseRegras = baseRegras;
		this.memoriaFatos = new MemoriaFatos();
		this.interpretador = new Interpreter();
		this.regrasRestantes = baseRegras.getRegras().size() - 1;
	}
	public void limparMemoria(){
		this.memoriaFatos.clear();
	}
	public Fato provar(Regra regra){
		String string = "";
		for(Object obj : regra.getExpressao()){
			if(obj.getClass() == new Conector("").getClass()){
				String valor = ((Conector) obj).getValor();
				if(valor.equals("ENTAO")){
					try {
						Fato retorno = regra.getConclusao();
						retorno.setValor((boolean) interpretador.eval(string));
						return retorno;
					} catch (EvalError e) {
						e.printStackTrace();
					}
				}else if(valor.equals("E")){
						string += "&& ";
				}else{
						string += "|| ";
				}
			}else{
				string += ((Fato)obj).getValor()+" ";
			}
		}
		return null;
	}
	
	public Fato inferencia(Fato fato){
		if(this.memoriaFatos.busca(fato) != null){
			return this.memoriaFatos.retorna(fato);
		}else{
			Regra regra = this.baseRegras.buscaConclusao(fato);
			if(regra != null){
				for(Fato ft : regra.getPremissas()){
					this.inferencia(ft);
					if(ft == regra.getPremissas().get(regra.getPremissas().size()-1)){
						ft = this.provar(regra);	
						this.memoriaFatos.inserir(ft);
						return ft;
					}
				}
			}else{
				Pergunta pergunta = new Pergunta("Voc� "+fato.getNome()+" ?");
				fato.setValor(pergunta.getDecisao());
				fato.setFatorCerteza(pergunta.getFatorCeteza());
				this.memoriaFatos.inserir(fato);
				return fato;
				
			}
		}
		return fato;
	}
	
	public ArrayList<Object> novaPergunta(){
		ArrayList<Object> array = new ArrayList<Object>();
		if(regrasRestantes >= 0){
			Fato retorno = this.inferencia(baseRegras.getRegras().get(regrasRestantes).getConclusao());
			regrasRestantes -= 1;
			array.add(retorno); array.add(true);
		}else{
			array.add(false);
		}
		return array;
	}
	private float OR_AND(float p1, Conector conector, float p2){
		if(conector.getValor().equals("E")){
			return Math.min(p1, p1);
		}else{
			return Math.max(p1, p2);
		}
	}
	public float calcularFC(Regra regra){
		float retorno = 0f;
		ArrayList<Fato> fatos = regra.getPremissas();
		if(fatos.size() == 1){
			return fatos.get(0).getFatorCerteza() * regra.getFatorCerteza();
		}
		ArrayList<Conector> conectores = regra.getConectores();
		for(int i=0;i<fatos.size();i++){
			if(retorno != 0 && fatos.get(i).getValor()){
				retorno = OR_AND(retorno, conectores.get(i-1), fatos.get(i).getFatorCerteza());
			}
			if(fatos.get(i).getValor() && retorno == 0){
				retorno = fatos.get(i).getFatorCerteza();
			}
		}
		
		return retorno * regra.getFatorCerteza();
	}
	
	public ObservableList<String> executar(){
		ObservableList<String> retorno = FXCollections.observableArrayList();
		ArrayList<Object> arrayConclusoes = this.novaPergunta();
		BaseRegras regrasMod = new BaseRegras(this.baseRegras.copia());
		while(true){
			if(arrayConclusoes.size() == 2 && ((Fato)arrayConclusoes.get(0)).getValor() == true){
				regrasMod.alterarFatos(this.memoriaFatos.getFatos());
				for(Regra regra : regrasMod.getRegras()){
					Fato prova = this.provar(regra);
					if(prova.getValor()){
						float FC = this.calcularFC(regra);
						retorno.add(prova.getNome() + " FC = "+FC*100);
					}
				}
				break;
			}else if(arrayConclusoes.size() == 2 && ((Fato)arrayConclusoes.get(0)).getValor() == false){
				arrayConclusoes = this.novaPergunta();
			}else{
				break;
			}
		}
		return retorno;
	}
		
}

