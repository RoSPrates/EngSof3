package exceptions;

public class CPFJaRegistradoException extends RuntimeException{

    public CPFJaRegistradoException(String mensage) {
        super(mensage);
    }

    public CPFJaRegistradoException() {
    }
}
