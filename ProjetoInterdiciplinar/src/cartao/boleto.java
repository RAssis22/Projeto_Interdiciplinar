package cartao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class Datas {
    private int diaDocumento;
    private int mesDocumento;
    private int anoDocumento;
    private int diaProcessamento;
    private int mesProcessamento;
    private int anoProcessamento;
    private int diaVencimento;
    private int mesVencimento;
    private int anoVencimento;

    public Datas comDocumento(int dia, int mes, int ano) {
        this.diaDocumento = dia;
        this.mesDocumento = mes;
        this.anoDocumento = ano;
        return this;
    }

    public Datas comProcessamento(int dia, int mes, int ano) {
        this.diaProcessamento = dia;
        this.mesProcessamento = mes;
        this.anoProcessamento = ano;
        return this;
    }

    public Datas comVencimento(int dia, int mes, int ano) {
        this.diaVencimento = dia;
        this.mesVencimento = mes;
        this.anoVencimento = ano;
        return this;
    }
}

@SuppressWarnings("serial")
public class boleto extends JFrame {

    private JButton gerarBoletoButton;

    public boleto() {
        setTitle("Interface de Geração de Boleto");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gerarBoletoButton = new JButton("Gerar Boleto");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(gerarBoletoButton);

        gerarBoletoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarBoleto();
            }
        });
    }

    public void gerarBoleto() {
        Datas datas = Datas.novasDatas()
                .comDocumento(1, 5, 2008)
                .comProcessamento(1, 5, 2008)
                .comVencimento(2, 5, 2008);

        Endereco enderecoBeneficiario = Endereco.novoEndereco()
                .comLogradouro("Av das Empresas, 555")
                .comBairro("Bairro Grande")
                .comCep("01234-555")
                .comCidade("São Paulo")
                .comUf("SP");

        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario("Fulano de Tal")
                .comAgencia("1824").comDigitoAgencia("4")
                .comCodigoBeneficiario("76000")
                .comDigitoCodigoBeneficiario("5")
                .comNumeroConvenio("1207113")
                .comCarteira("18")
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("9000206");

        Endereco enderecoPagador = Endereco.novoEndereco()
                .comLogradouro("Av dos testes, 111 apto 333")
                .comBairro("Bairro Teste")
                .comCep("01234-111")
                .comCidade("São Paulo")
                .comUf("SP");

        Pagador pagador = Pagador.novoPagador()
                .comNome("Fulano da Silva")
                .comDocumento("111.222.333-12")
                .comEndereco(enderecoPagador);

        Banco banco = new MeuBanco(); // Substitua "MeuBanco" pelo nome da sua classe que estende Banco

        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto("200.00")
                .comNumeroDoDocumento("1234")
                .comInstrucoes("instrucao 1", "instrucao 2");
    }
}
