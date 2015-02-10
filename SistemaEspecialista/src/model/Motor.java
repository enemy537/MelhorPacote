package model;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public Fato provar(Regra regra){
		String string = "";
		for(Object obj : regra.getExpressao()){
			if(obj.getClass() == new Conector("").getClass()){
				String valor = ((Conector) obj).getValor();
				if(valor.equals("ENTÃO")){
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
				string += (this.memoriaFatos.retorna((Fato)obj)).getValor()+" ";
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
				Pergunta pergunta = new Pergunta(fato.getNome()+"?");
				boolean valor = pergunta.decisao;
				fato.setValor(valor);
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
	
}
