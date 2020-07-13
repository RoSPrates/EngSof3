package pessoas;

import recepcao.acesso.OrdemDeAcesso;
import recepcao.acesso.OrdemPessoa;

import java.util.List;

public class Colaborador extends Pessoa{

    private String cargo;
    private Long idMatrivula;

    public Colaborador(Long id, String nome, String sobrenome, String CPF, String cargo) {
        super(nome, sobrenome, CPF);
        this.cargo = cargo;
        this.idMatrivula = id;
    }

    public List<OrdemDeAcesso> buscaOrdemPorNomeDoMorador(String nome, String sobrenome){
        List<Morador> p = Moradores.buscarMoradorPorNome(nome,sobrenome);
        return OrdemPessoa.buscarOrdemPorNomeDeSolicitante(p.get(0).getNome(),p.get(0).getSobrenome());
    }

    public List<OrdemDeAcesso> buscaOrdemPorCPFDoMorador(String CPF){
        return OrdemPessoa.buscarOrdemPorCPFDeSolicitante(CPF);
    }

    public  OrdemDeAcesso buscarOrdemPorIdDaOrdem(Long id){
        return OrdemPessoa.buscarOrdemPorId(id);
    }

}
