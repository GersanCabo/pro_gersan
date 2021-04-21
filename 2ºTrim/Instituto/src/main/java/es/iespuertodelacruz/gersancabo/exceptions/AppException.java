package es.iespuertodelacruz.gersancabo.exceptions;

public class AppException extends Exception {

    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor por defecto
     * @param mensaje de error
     */
    public AppException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     * @param mensaje de error
     * @param causa del error
     */
    public AppException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
