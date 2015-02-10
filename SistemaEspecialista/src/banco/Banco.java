package banco;

import java.util.ArrayList;

import model.BaseRegras;
import model.Fato;
import model.Regra;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Banco {
	
		// Em db são guardados os objetos
		private ObjectContainer db;
		
		
		// Criando o banco
		public Banco() {
			db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "db");
		}
		
		// Adicionando no ObjectContainer
		public void addObjeto(Object o){
			db.store(o);
		}

		
		// Listando todos os objetos de determinada classe
		public ObjectSet listaObjeto(Class c){
			ObjectSet lista = db.query(c);
			return lista;
		}
		
		
		// Excluindo determinado objeto
		public void excluirObjeto(Object o){
			db.delete(o);
		}

		
		// Fechando banco
		public void close() {
			db.close();
		}
		
		
		// Lista regras
		public BaseRegras listarRegras(){

			ObjectSet listaDoBanco = db.query(Regra.class);
			BaseRegras listaRegras = new BaseRegras();
			
			for (int i = 0; i < listaDoBanco.size(); i++) {
				listaRegras.adicionar((Regra) listaDoBanco.get(i));
			}
			return listaRegras;
		}
		
		// Lista fatos
		public ArrayList<Fato> listarFatos(){

			ObjectSet listaDoBanco = db.query(Fato.class);
			ArrayList<Fato> listaFatos = new ArrayList<>();
			
			for (int i = 0; i < listaDoBanco.size(); i++) {
				listaFatos.add((Fato) listaDoBanco.get(i));
			}
			return listaFatos;
		}
		
		

				
		
}		
