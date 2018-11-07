package principal;

import java.io.IOException;
import java.util.List;
import java.util.ListResourceBundle;

import com.db4o.*;
import com.db4o.defragment.Defragment;
import com.db4o.defragment.DefragmentConfig;
import com.db4o.query.Predicate;

public class Main {

	public static void main(String[] args) {
		//Variavel do arquivo do BD:
		ObjectContainer db = Db4o.openFile("Db.dbo");
		//Criando Objetos do tipo Empresa:
		Empresa e = new Empresa(1, "IBM", "Best Place to Work");
		Empresa e2 = new Empresa(2, "Microsoft", "THE Best Place to Work");
		//Variavel para obter o resultado:
		ObjectSet result;
	
		
		//INSERT no BD:
		db.store(e); //Tutorial apresentava .set
		System.out.println("A empresa foi inserida");
		//Segunda empresa:
		db.store(e2);
		System.out.println("A segunda empresa foi inserida");
		
		
		//QBE:
		Empresa consulta = new Empresa(0, null, null);
		result = db.queryByExample(consulta);
		consulta.listResult(result);
		
		
		/*
		//NQ:
		List<Empresa> empresas = db.query(new Predicate<Empresa>() {
			public boolean match(Empresa empresa) {
				return empresa.getNome() == "IBM";
			}
		});
		System.out.println(empresas);
		*/
		
		
		
		db.commit();
		db.close();
		
		/*
		try {
			Defragment.defrag("Db.dbo");
			System.out.println("Desfragmentei.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
	}

}
