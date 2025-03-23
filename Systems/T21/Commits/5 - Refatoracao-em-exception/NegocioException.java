package br.sistema.crud.jdbc.exception;

public class NegocioException extends Exception {

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String msg, Exception exception) {
        super(msg, exception);
    }
}
