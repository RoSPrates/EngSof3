package utils;

public class Menu {
    public static void menu(){
        char escolha;
        do {
            escolha = Tela.decidir("Escolha:\nG para Gerar Ordem\n" +
                    "C para Cancelar\nS para sair.");
            switch (escolha) {
                case 'S':
                case 's':
                    Tela.exibe("Obrigado Volte sempre!");
                    break;
                case 'G':
                case 'g':
                    Tela.gerarOrdem();
                    break;
                case 'b': case'B':
                    Tela.BuscarOrdem("Digite o Id da Ordem");
                    break;
                default:
                    Tela.exibe("Opção Invalida!");
            }
        }while (escolha!='S'&&escolha!='s');
    }
}
