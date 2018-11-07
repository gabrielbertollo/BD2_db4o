package principal;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Update {

	public static void main(String[] args) {
		ObjectContainer db = Db4o.openFile("Db.dbo");
		//Objeto do tipo Empresa para obter o objeto consultado:
		Empresa achou_e; 
		ObjectSet result;
		
		//UPDATE no BD:
		Empresa consulta2 = new Empresa(1, null, null); //Instanciando o objeto com codigo 1
		result = db.queryByExample(consulta2); //Recupera o objeto e do Banco
		achou_e = (Empresa) result.next(); //Atribui o objeto recuperado para achou_e
		achou_e.setCod(3); 
		achou_e.setNome("Linux");
		achou_e.setDescricao("Operational System");
		db.store(achou_e);
		System.out.println("O objeto foi atualizado");
		
		//QBE:
		Empresa consulta = new Empresa(0, null, null);
		result = db.queryByExample(consulta);
		consulta.listResult(result);
		
		db.commit();
		db.close();
	}

}
