package recepcao.acesso;

import exceptions.OrdemNaoEncontradaException;
import pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class OrdemPessoa {

    private static List<OrdemDeAcesso> ordens = new ArrayList<>();
    private static Long totalDeOrdensEmitidas = 0L;


    public static OrdemDeAcesso criarOrdem(Pessoa solicitante,Pessoa haEntrar, int dia, int mes, int ano) {
        OrdemDeAcesso ordemDeAcesso = new OrdemDeAcesso((totalDeOrdensEmitidas+1), solicitante, haEntrar, dia, mes, ano);
        totalDeOrdensEmitidas++;
        ordens.add(ordemDeAcesso);
        return ordemDeAcesso;
    }

    public static  OrdemDeAcesso buscarOrdemPorId(Long id){
        return ordens.stream().filter(ordem -> ordem.getId().equals(id)).
                findFirst().orElseThrow(OrdemNaoEncontradaException::new);
    }

    public static List<OrdemDeAcesso> buscarOrdemPorCPFDeSolicitante(String CPF){
        return ordens.stream().filter(orden -> orden.getSolicitante().getCpf().equals(CPF)).
                collect(Collectors.toList());
    }

    public static List<OrdemDeAcesso> buscarOrdemPorNomeDeSolicitante(String nomeSolicitante, String sobrenomeSolicitante){
        return ordens.stream().filter(ordem -> ordem.getSolicitante().getNome().equals(nomeSolicitante)
                && ordem.getSolicitante().getSobrenome().equals(sobrenomeSolicitante)).
                collect(Collectors.toList());
    }
}
