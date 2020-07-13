package exceptions;

public class MoradorInvalidoException extends RuntimeException{

    public MoradorInvalidoException(String mensage) {
        super(mensage);
    }

    public MoradorInvalidoException() {}
}
