package pessoas;

import exceptions.CPFInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Moradores {

    private static List<Morador> moradores = new ArrayList<>();

    public static Morador RegistrarMorador(String nome, String sobrenome, String CPF, String ap) {
        Morador morador = new Morador(nome, sobrenome, CPF, ap);
        moradores.add(morador);
        return morador;
    }

    public static List<Morador> buscarMoradorPorNome(String nome, String sobrenome) {
        return moradores.stream().filter(morador -> morador.getNome().equals(nome)
                && morador.getSobrenome().equals(sobrenome)).collect(Collectors.toList());
    }

    public static Morador buscarMoradorPorCPF(String CPF){
        return moradores.stream().filter(morador -> morador.getCpf().equals(CPF))
                .findFirst().orElseThrow(CPFInvalidoException::new);
    }
}
