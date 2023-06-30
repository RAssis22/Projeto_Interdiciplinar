package cartao;

public static void realizarTransacao(Scanner scanner) {
        // ...

        System.out.print("Digite o número do cartão: ");
        String numeroCartao = scanner.nextLine();

        // Verificar se o cartão é válido
        boolean cartaoValido = verificarCartao(numeroCartao);

        if (cartaoValido) {
            // Cartão válido, continuar com a transação
            // ...
            System.out.println("Transação realizada com sucesso!");
        } else {
            // Cartão inválido
            System.out.println("Número de cartão inválido!");
        }
    }

    public static boolean verificarCartao(String numeroCartao) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean cartaoValido = false;

        try {
            // Registrar o driver JDBC
            Class.forName(JDBC_DRIVER);

            // Estabelecer a conexão com o banco de dados
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Preparar a consulta SQL
            String sql = "SELECT * FROM cartoes WHERE numero = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, numeroCartao);

            // Executar a consulta
            rs = stmt.executeQuery();

            // Verificar se o cartão existe no banco de dados
            if (rs.next()) {
                cartaoValido = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar os recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cartaoValido;
    }

    // ...
}