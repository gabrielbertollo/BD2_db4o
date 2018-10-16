package principal;

public class Empresa {
	
	private int cod;
	private String nome;
	private String descricao;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Empresa [cod=" + cod + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	

}
