package pessoas;

import utils.CPF;
import utils.CPFs;

import java.util.Objects;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private CPF cpf;
    ;

    public Pessoa(String nome, String sobrenome, String CPF) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.setCpf(CPF);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf.getCpf();
    }

    public void setCpf(String cpf) {
        CPFs.registraCPF(cpf);
        this.cpf.setCpf(cpf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return nome.equals(pessoa.nome) &&
                sobrenome.equals(pessoa.sobrenome) &&
                cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, cpf);
    }
}
