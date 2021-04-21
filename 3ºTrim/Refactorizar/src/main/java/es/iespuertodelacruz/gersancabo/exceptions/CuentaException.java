package es.iespuertodelacruz.gersancabo.exceptions;

public class CuentaException extends Exception {

    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor con mensaje
     * @param mensaje descriptivo
     */
    public CuentaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje 
     * @param mensaje descriptivo
     * @param exception descriptiva
     */
    public CuentaException(String mensaje, Exception exception) {
        super(mensaje, exception);
    }

}
