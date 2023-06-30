package cartao;


public class Pessoa {
	private String nome, cpf;
	
	public Pessoa(String nome, String cpf) {
		this.cpf = cpf;
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	 public void inserir() {
	        System.out.println("to no inserir em Pessoa");
	        PessoaDAO pessoaDAO = new PessoaDAO();
	        pessoaDAO.inserir(this);
	    }
	    
	
}
