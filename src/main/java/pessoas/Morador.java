package pessoas;

import recepcao.acesso.OrdemDeAcesso;
import recepcao.acesso.OrdemPessoa;

public class Morador extends Pessoa {
    private String ap;

    public Morador(String nome, String sobrenome, String CPF, String ap) {
        super(nome, sobrenome, CPF);
        this.ap = ap;
    }

    public OrdemDeAcesso criarOrdemDeAcesso(String nome, String sobrenome, String CPF, int dia, int mes, int ano) {
        Pessoa convidado = this.convidarPessoa(nome, sobrenome, CPF);
        return OrdemPessoa.criarOrdem(this, convidado, dia, mes, ano);
    }

    public Pessoa convidarPessoa(String nome, String sobrenome, String CPF) {
        return new Pessoa(nome, sobrenome, CPF);
    }

}
