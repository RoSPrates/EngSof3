package exceptions;

public class OrdemNaoEncontradaException extends RuntimeException{

    public OrdemNaoEncontradaException(String mensage){
        super(mensage);
    }

    public OrdemNaoEncontradaException(){}
}
