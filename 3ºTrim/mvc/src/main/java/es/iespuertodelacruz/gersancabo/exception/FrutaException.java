package es.iespuertodelacruz.gersancabo.exception;


public class FrutaException extends Exception {
    private static final long serialVersionUID = 1L;

    public FrutaException(String mensaje) {
        super(mensaje);
    }

    public FrutaException(String mensaje, Exception exception) {
        super(mensaje, exception);
    }
}
