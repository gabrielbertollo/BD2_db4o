package principal;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Delete {

	public static void main(String[] args) {
		ObjectContainer db = Db4o.openFile("Db.dbo");
		//Objeto do tipo Empresa para obter o objeto consultado:
		Empresa achou_e; 
		ObjectSet result;
		
		//DELETE no BD:
		Empresa consulta3 = new Empresa(2, null, null);
		result = db.queryByExample(consulta3);
		achou_e = (Empresa) result.next();
		db.delete(achou_e);
		System.out.println("O objeto foi apagado");
		
		
		//QBE:
		Empresa consulta = new Empresa(0, null, null);
		result = db.queryByExample(consulta);
		consulta.listResult(result);
		
		
		db.commit();
		db.close();

	}

}
