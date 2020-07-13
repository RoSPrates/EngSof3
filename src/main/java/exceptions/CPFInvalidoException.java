package exceptions;

public class CPFInvalidoException extends RuntimeException {

    public CPFInvalidoException(String mensage) {
        super(mensage);
    }

    public CPFInvalidoException() {
    }
}
