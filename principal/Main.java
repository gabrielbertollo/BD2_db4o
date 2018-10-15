package principal;

import com.db4o.*;

public class Main {

	public static void main(String[] args) {
		
		ObjectContainer db = Db4o.openFile("Banco.yap");
		
		Pessoa p = new Pessoa();
		
		Pessoa achou_p;
		
		ObjectSet result;
		
		
		p.setCod(1);
		p.setNome("Gabriel");
		db.set(p);
		System.out.println("O objeto foi inserido");
		
		p.setCod(20);
		result = db.get(p);
		achou_p = (Pessoa) result.next();
		System.out.println(achou_p.getNome());
		
		

	}

}
