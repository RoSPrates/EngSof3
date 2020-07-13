package utils;

import exceptions.CPFJaRegistradoException;

import java.util.ArrayList;
import java.util.List;

public abstract class CPFs {

    private static List<CPF> cpfs = new ArrayList<>();

    public static void registraCPF(String cpf){
        if(cpfRegistrado(cpf)) throw new CPFJaRegistradoException("CPF ja registrado");
        cpfs.add(new CPF(cpf));
    }

    public static boolean cpfRegistrado(String cpf){
        return cpfs.stream().anyMatch(cpf1 -> cpf1.getCpf().equals(cpf));
    }
}
