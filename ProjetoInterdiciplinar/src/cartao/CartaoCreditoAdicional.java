package cartao;

import java.util.Random;

public static void emitirCartaoAdicional(Scanner scanner) {
    System.out.print("Documento do titular: ");
    String documentoTitular = scanner.nextLine();

    System.out.print("Nome do adicional: ");
    String nomeAdicional = scanner.nextLine();

    // Geração automática do número do cartão adicional
    String numeroCartaoAdicional = gerarNumeroCartao();

    System.out.print("Data de validade: ");
    String dataValidade = scanner.nextLine();

    System.out.print("Limite de crédito: ");
    double limiteCredito = scanner.nextDouble();
    scanner.nextLine(); // Limpar o buffer de entrada

    try {
        CartaoCreditoAdicional cartaoAdicional = new CartaoCreditoAdicional(documentoTitular, nomeAdicional, numeroCartaoAdicional, dataValidade, limiteCredito);
        
        // Restante da lógica para emitir o cartão adicional
        // Por exemplo, você pode adicionar o cartão à lista de cartões associados ao titular,
        // armazenar os dados do cartão no banco de dados, etc.
        
        System.out.println("Cartão de crédito adicional emitido com sucesso!");
    } catch (IllegalArgumentException e) {
        System.out.println("Erro ao emitir cartão adicional: " + e.getMessage());
    }
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