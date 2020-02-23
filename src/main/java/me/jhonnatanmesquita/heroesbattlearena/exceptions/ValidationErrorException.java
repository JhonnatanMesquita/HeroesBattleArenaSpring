package me.jhonnatanmesquita.heroesbattlearena.exceptions;

public class ValidationErrorException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ValidationErrorException(String msg){
        super(msg);
    }

    public ValidationErrorException(String msg, Throwable cause){
        super(msg, cause);
    }
}
