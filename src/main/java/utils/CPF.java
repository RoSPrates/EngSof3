package utils;

import exceptions.CPFInvalidoException;

import java.util.Objects;

public class CPF {

    private String cpf;

    public CPF(String cpf) {
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!CPF.isCpf(cpf)) throw new CPFInvalidoException("Não é um CPF valido!");
        this.cpf = cpf.replaceAll("\\D", "");
    }

    public static boolean isCpf(String cpf) {
        if (cpf == null) return false;
        cpf = cpf.replaceAll("\\D", "");
        if (!cpf.matches("(?!(\\d)\\1{10})\\d{11}") || (cpf.length() != 11)) return false;

        int soma = 0;
        for (int i = 0; i < 9; i++) soma += (Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i));
        soma = (soma * 10) % 11 > 9 ? 0 : (soma * 10) % 11;
        if (Integer.parseInt(cpf.substring(9, 10)) != soma) return false;

        soma = 0;
        for (int i = 0; i < 10; i++) soma += (Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i));
        soma = (soma * 10) % 11 > 9 ? 0 : (soma * 10) % 11;
        return Integer.parseInt(cpf.substring(10)) == soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf1 = (CPF) o;
        return cpf.equals(cpf1.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
