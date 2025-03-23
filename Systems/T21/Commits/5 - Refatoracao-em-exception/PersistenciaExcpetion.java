package br.sistema.crud.jdbc.exception;

public class PersistenciaException extends Exception {

    public PersistenciaException(String msg) {
        super(msg);
    }

    public PersistenciaException(String msg, Exception exception) {
        super(msg, exception);
    }
}

