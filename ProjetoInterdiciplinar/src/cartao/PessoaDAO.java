package cartao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

	public void inserir(Pessoa pessoa){
        ConectaBD con = new ConectaBD();
        String sql = "INSERT INTO Pessoa (nome, cpf) VALUES (?,?)";
        try{
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getCpf());
            pst.execute();
            System.out.println(pessoa.getNome() + " inserido");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
