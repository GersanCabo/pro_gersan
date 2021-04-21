package es.iespuertodelacruz.gersancabo.controlador;

import es.iespuertodelacruz.gersancabo.api.Fruta;
import es.iespuertodelacruz.gersancabo.exception.FrutaException;
import es.iespuertodelacruz.gersancabo.modelo.FrutaModelo;

public class FrutaController {

    FrutaModelo frutaModelo;

    public FrutaController() {
        frutaModelo = new FrutaModelo();
    }

    /**
     * Metodo encargado de realizar la validacion del objeto fruta
     * @param fruta a validar
     * @throws FrutaException con el mensaje descriptivo de lo que sucede
     */
    public void validarFruta(Fruta fruta) throws FrutaException {
        String mensaje = "";

        if (fruta == null) {
            mensaje = "Se este intantando validar un objeto vacio";
            throw new FrutaException(mensaje);
        }
        if (fruta.getIdentificador() == null || fruta.getIdentificador().isEmpty()) {
            mensaje = "El identificador de la fruta es nulo o vacio \n";
        }
        if (fruta.getNombre() == null || fruta.getNombre().isEmpty()) {
            mensaje += "El nombre de la fruta es nulo o vacio \n";
        }
        if (fruta.getCoste() < 0) {
            mensaje += "El coste de la fruta es 0 o menor \n";
        }
        if (fruta.getPrecio() < 0) {
            mensaje += "El precio de la fruta es 0 o menor \n";
        }
        if (!mensaje.isEmpty()) {
            throw new FrutaException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * @param fruta a insertar
     * @throws FrutaException con mensaje controlado
     */
    public void insertar(Fruta fruta) throws FrutaException {
        validarFruta(fruta);
        if (existe(fruta)) {
            throw new FrutaException("La fruta indicada ya existe");
        } 
        frutaModelo.insertar(fruta);
    }

    /**
     * Metodo encargado de eliminar
     * @param fruta a eliminar
     * @throws FrutaException
     */
    public void eliminar(Fruta fruta) throws FrutaException {
        validarFruta(fruta);
        if (!existe(fruta)) {
            throw new FrutaException("La fruta indicada ya existe");
        } 
        frutaModelo.eliminar(fruta);
    }

    /**
     * MEtodo enacargado de realizar la elimiancion de uan fruta
     * @param identificador del elemento a elimianr
     * @throws FrutaException controlada en caso de error
     */
    public void eliminar(String identificador) throws FrutaException {
        Fruta fruta;
        fruta = buscar(identificador);
        if (fruta == null) {
            throw new FrutaException("La fruta indicada no existe");
        }
        frutaModelo.eliminar(fruta);
    }

    /**
     * Metodo encargado de buscar por identidficador
     * @param identificador para localizar la fruta
     * @throws FrutaException
     */
    public Fruta buscar(String identificador) throws FrutaException {
        Fruta fruta = null;
        fruta = frutaModelo.buscar(identificador);
        if (fruta == null) {
            throw new FrutaException("La fruta indicada no existe2");
        }
        return fruta;
    }

    /**
     *Metodo que mdoificad una fruta
     * @param fruta a modificar
     * @throws FrutaException controlada en caso de error
     */
    public void modificar( Fruta fruta) throws FrutaException {
        Fruta frutaAlmacenada;
        validarFruta(fruta);
        frutaAlmacenada = buscar(fruta.getIdentificador());
        if (frutaAlmacenada == null) {
            throw new FrutaException("La fruta indicada no existe");
        }
        //realizamos la actualizacion del elemento fruta
        frutaModelo.modificar(fruta);
    }

    /**
     * Funcion encargada de verificar si existe la fruta
     * @param fruta a encontrar
     * @return true/false
     * @throws FrutaException
     */
    private boolean existe(Fruta fruta) throws FrutaException {
        boolean encontrada = false;
        Fruta frutaEncontrada;
        frutaEncontrada = buscar(fruta.getIdentificador());
        if (frutaEncontrada != null) {
            encontrada = true;
        }
        return encontrada;
    }
}
