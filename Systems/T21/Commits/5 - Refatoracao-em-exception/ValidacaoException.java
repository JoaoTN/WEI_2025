package br.sistema.crud.jdbc.exception;

public class ValidacaoException extends Exception {

    public ValidacaoException(String msg) {
        super(msg);
    }

    public ValidacaoException(String msg, Exception exception) {
        super(msg, exception);
    }
}
