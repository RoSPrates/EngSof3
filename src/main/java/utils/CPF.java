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
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return false;

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
