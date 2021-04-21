package es.iespuertodelacruz.gersancabo.vista;

import es.iespuertodelacruz.gersancabo.api.Fruta;
import es.iespuertodelacruz.gersancabo.controlador.FrutaController;
import es.iespuertodelacruz.gersancabo.exception.FrutaException;

/**
 * Hello world!
 *
 */
public class AppFruteria {

    FrutaController frutaController;

    public AppFruteria() {
        frutaController = new FrutaController();
    }
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    public void insertar(Fruta fruta) throws FrutaException {
        frutaController.insertar(fruta);
    }
}
