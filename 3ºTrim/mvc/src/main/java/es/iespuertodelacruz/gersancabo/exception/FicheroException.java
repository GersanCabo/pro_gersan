package es.iespuertodelacruz.gersancabo.exception;

public class FicheroException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con el mensaje personalizado
     * @param mensaje personalizado
     */
    public FicheroException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con el mensaje y la excepcion que da
     * @param mensaje de la excepcion
     * @param exception que lanza
     */
    public FicheroException(String mensaje, Exception exception) {
        super(mensaje, exception);
    }
}
