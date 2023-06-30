package cartao;
//Rodrigo Assis
//Gian Carlo

import java.util.Scanner;

import javax.swing.JOptionPane;



public class EmissaoCartaoCredito {
	public static String leString(String msg) {
		String valor = JOptionPane.showInputDialog(null, msg);
		return valor;
	}
	public EmissaoCartaoCredito(String nomeTitular, String documentoTitular, String numeroCartao, String dataValidade,
			double limiteCredito) {
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Emissão de Cartão de Crédito");
        System.out.println("--------------------------------------");

        System.out.println("Opções:");
        System.out.println("1 - Emitir nova pessoa");
        System.out.println("6 - Emitir novo cartão de crédito");
        System.out.println("2 - Emitir cartão adicional");
        System.out.println("3 - Realizar transação");
        System.out.println("4 - Efetuar pagamento");
        System.out.println("5 - Consultar saldo disponível");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        //scanner.nextLine(); // Limpar o buffer de entrada

        if (opcao == 1) {
        	//Scanner scanner = new Scanner(System.in);
        	
        	
        	String nome = leString("Digite o nome");
        	String cpf = leString("Digite o Cpf:");
        	
        	Pessoa p = new Pessoa(nome, cpf);
        	PessoaDAO pessoaDAO = new PessoaDAO();
        	pessoaDAO.inserir(p);
        }
        else if (opcao == 2) {
        	PessoaDAO pessoaDAO = new PessoaDAO();
        	
        	System.out.print("Nome do titular: ");
            String nome = scanner.nextLine();

            String cpf = scanner.nextLine();
            
        	Pessoa pessoa = new Pessoa(nome, cpf);

            pessoaDAO.inserir(pessoa);
            


            
            
            /*      emitirCartaoPrincipal(scanner);
        } else if (opcao == 2) {
            emitirCartaoAdicional(scanner);
        } else if (opcao == 3) {
            realizarTransacao(scanner);
        } else if (opcao == 4) {
            efetuarPagamento(scanner);
        } else if (opcao == 5) {
            consultarSaldo(scanner);
        } else {
            System.out.println("Opção inválida!");
        */}
    }

    public static void emitirCartaoPrincipal(Scanner scanner) {
    	System.out.print("Nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Documento do titular: ");
        String documentoTitular = scanner.nextLine();

        System.out.print("Número do cartão: ");
        String numeroCartao = scanner.nextLine();

        System.out.print("Data de validade: ");
        String dataValidade = scanner.nextLine();

        System.out.print("Limite de crédito: ");
        double limiteCredito = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        try {
            //CartaoCreditoAdicional cartao = new CartaoCreditoAdicional(nomeTitular, documentoTitular, numeroCartao, dataValidade, limiteCredito);
            // Lógica para emitir cartão principal
            // ...

            System.out.println("Cartão de crédito principal emitido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao emitir cartão principal: " + e.getMessage());
        }
    
    }

    
    	public static void emitirCartaoAdicional(Scanner scanner) {
    	    System.out.print("Documento do titular: ");
    	    String documentoTitular = scanner.nextLine();

    	    System.out.print("Nome do adicional: ");
    	    String nomeAdicional = scanner.nextLine();

    	    System.out.print("Número do cartão adicional: ");
    	    String numeroCartaoAdicional = scanner.nextLine();

    	    System.out.print("Data de validade: ");
    	    String dataValidade = scanner.nextLine();

    	    System.out.print("Limite de crédito: ");
    	    double limiteCredito = scanner.nextDouble();
    	    scanner.nextLine(); // Limpar o buffer de entrada

    	    try {
    	        //new CartaoCreditoAdicional(documentoTitular, nomeAdicional, numeroCartaoAdicional, dataValidade, limiteCredito);

    	        System.out.println("Cartão de crédito adicional emitido com sucesso!");
    	    } catch (IllegalArgumentException e) {
    	        System.out.println("Erro ao emitir cartão adicional: " + e.getMessage());
    	    }
    	
        System.out.println("Cartão de crédito adicional emitido com sucesso!");
    }

    public static void realizarTransacao(Scanner scanner) {
        // Código para realizar transação
        // ...

        System.out.println("Transação realizada com sucesso!");
    }

    public static void efetuarPagamento(Scanner scanner) {
        // Código para efetuar pagamento
        // ...

        System.out.println("Pagamento realizado com sucesso!");
    }

    public static void consultarSaldo(Scanner scanner) {
        System.out.print("Número do cartão (principal ou adicional): ");
        scanner.nextLine();

        // Verificar se o cartão existe
        // Aqui você pode adicionar a lógica para verificar no banco de dados, por exemplo

	}

}
