package principal;

import com.db4o.*;

public class Main {

	public static void main(String[] args) {
		//Variavel do arquivo do BD:
		ObjectContainer db = Db4o.openFile("Banco.dbo"); //Antigo: .yap
		//Criando um Objeto do tipo Empresa:
		Empresa e = new Empresa();
		//Objeto do tipo Empresa para obter o objeto consultado:
		Empresa achou_e;
		//Variavel para obter o resultado:
		ObjectSet result;
		
		//INSERT no BD:
		e.setCod(1);
		e.setNome("IBM");
		e.setDescricao("Computing Company");
		db.store(e); //Tutorial apresentava .set
		System.out.println("O objeto foi inserido");
		
		//UPDATE no BD:
		e.setCod(1);
		result = db.get(e);
		achou_e = (Empresa) result.next();
		achou_e.setCod(2);
		achou_e.setNome("Linux");
		achou_e.setDescricao("Better Computing Company");
		db.store(achou_e);
		System.out.println("O objeto foi atualizado");
		
		//SELECT no BD:
		e.setCod(1);
		result = db.get(e);
		achou_e = (Empresa) result.next();
		System.out.println(achou_e.getNome());
		
		//DELETE no BD:
		e.setCod(1);
		result = db.get(e);
		achou_e = (Empresa) result.next();
		db.delete(achou_e);
		System.out.println("O objeto foi apagado");
		
		db.close();
	}

}
