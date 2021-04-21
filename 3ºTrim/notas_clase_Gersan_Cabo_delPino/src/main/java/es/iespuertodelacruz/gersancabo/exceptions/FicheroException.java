package es.iespuertodelacruz.gersancabo.exceptions;

public class FicheroException extends Exception {

    private static final long serialVersionUID = -5784859412230405974L;

    /**
     * Constructor con mensaje personalizado
     * @param mensaje personalizado
     */
    public FicheroException(String mensaje) {
       super(mensaje);
    }
 
    /**
     * Constructor con el mensaje y su respectiva excepcion
     * @param mensaje de la excepcion
     * @param excepcion lanzada
     */
    public FicheroException(String mensaje, Exception excepcion) {
       super(mensaje, excepcion);
    }
}
