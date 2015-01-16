package banco;

import java.util.ArrayList;

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
		public ArrayList<Regra> listarRegras(){

			ObjectSet listaDoBanco = db.query(Regra.class);
			ArrayList<Regra> listaRegras = new ArrayList<>();
			
			for (int i = 0; i < listaDoBanco.size(); i++) {
				listaRegras.add((Regra) listaDoBanco.get(i));
			}
			return listaRegras;
		}
		
}
