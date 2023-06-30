package cartao;

import java.util.Random;

public class CartaoCredito {
	
	private int idcliente;
	private String numeroCartao;
	private String dataValidade;
	private double limiteCredito;

	public CartaoCredito(int idcliente,String numeroCartao, String dataValidade, double limiteCredito) {
		this.dataValidade = dataValidade;
		this.limiteCredito = limiteCredito;
		this.numeroCartao = gerarNumeroCartao();
}


// Métodos getters e setters


public String getNumeroCartao() {
    return numeroCartao;
}

public int getIdcliente() {
	return idcliente;
}


public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
}


public void setNumeroCartao(String numeroCartao) {
    this.numeroCartao = numeroCartao;
}

public String getDataValidade() {
    return dataValidade;
}

public void setDataValidade(String dataValidade) {
    this.dataValidade = dataValidade;
}

public double getLimiteCredito() {
    return limiteCredito;
}

public void setLimiteCredito(double limiteCredito) {
    this.limiteCredito = limiteCredito;
}

private static String gerarNumeroCartao() {
    // Lógica para gerar o número do cartão adicional
    Random random = new Random();
    StringBuilder numeroCartao = new StringBuilder();
    
    // Primeiro dígito deve ser 4 para indicar que é um cartão de crédito
    numeroCartao.append("4");
    
    // Gerar os 15 dígitos restantes do número do cartão
    for (int i = 0; i < 15; i++) {
        int digit = random.nextInt(10);
        numeroCartao.append(digit);
    }
    
    return numeroCartao.toString();
}
}