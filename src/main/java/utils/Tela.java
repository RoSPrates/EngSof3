package utils;
import pessoas.Colaborador;
import pessoas.Morador;

import javax.swing.*;

public abstract class Tela {

    static char decidir(String msg){
        String str;
        char ret = 'a';
        boolean verifica = false;
        do{
            try{
                str = JOptionPane.showInputDialog(msg);
                ret = str.charAt(0);
                return ret;
            }catch (NullPointerException ex){
                ret = 's';
                return ret;
            }catch (StringIndexOutOfBoundsException ex){
                Tela.exibe("Escolha alguma alternativa!");
                verifica = true;
            }
        }while (verifica);
        return ret;
    }

    static String escolher(String msg){
        String str;
        str = JOptionPane.showInputDialog(msg);
        return str;
    }

    static void exibe(int resposta){
        String msg = "A resposta é: ";
        msg += resposta;
        JOptionPane.showMessageDialog(null,msg);
    }
    static void exibe(double resposta){
        String msg = "A resposta é: ";
        msg += String.format("%.3f",resposta);
        JOptionPane.showMessageDialog(null,msg);
    }

    static void exibe(long resposta){
        String msg = "A resposta é: ";
        msg += resposta;
        JOptionPane.showMessageDialog(null,msg);
    }

    static void exibe(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }

    static void gerarOrdem(){
        Morador morador = new Morador(JOptionPane.showInputDialog("Digite o nome"),JOptionPane.showInputDialog("Digite o Sobrenome"),
                JOptionPane.showInputDialog("Digite o CPF"),JOptionPane.showInputDialog("Digite o Numero do Apartamento"));
        JOptionPane.showMessageDialog(null,morador.criarOrdemDeAcesso(JOptionPane.showInputDialog("Digite o nome"),JOptionPane.showInputDialog("Digite o Sobrenome"),
                JOptionPane.showInputDialog("Digite o CPF"),Integer.parseInt(JOptionPane.showInputDialog("Digite o Dia de entrada")),
                Integer.parseInt(JOptionPane.showInputDialog("Digite o mes de entrada")),Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de entrada"))));
    }

    static void BuscarOrdem(String text){
        Colaborador colaborador = new Colaborador(558L,JOptionPane.showInputDialog("Digite o nome"),JOptionPane.showInputDialog("Digite o Sobrenome"),
                JOptionPane.showInputDialog("Digite o CPF"),JOptionPane.showInputDialog("Digite o Nome do seu Cargo"));
        JOptionPane.showMessageDialog(null,colaborador.buscarOrdemPorIdDaOrdem(Long.parseLong(JOptionPane.showInputDialog(text))));
    }

}


