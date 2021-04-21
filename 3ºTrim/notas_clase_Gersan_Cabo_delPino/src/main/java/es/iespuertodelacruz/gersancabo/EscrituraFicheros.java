package es.iespuertodelacruz.gersancabo;

import java.io.FileWriter;
import java.io.IOException;

import es.iespuertodelacruz.gersancabo.exceptions.FicheroException;

public class EscrituraFicheros {
    
    String nombre;
    String cadenaTexto;

    /**
     * Constructor con parametros
     * @param nombre del fichero
     * @param cadenaTexto a escribir en el fichero
     */
    public EscrituraFicheros(String nombre, String cadenaTexto) {
        this.nombre = nombre;
        this.cadenaTexto = cadenaTexto;
    }

    /**
     * Constructor vacio
     */
    public EscrituraFicheros() {
    }

    /**
    * Metodo encargado de crear un fichero
    * @param nombre del fichero a crear
    * @throws FicheroException
    * @throws IOException
    */
    public boolean crear(String nombre, String cadenaTexto) throws FicheroException, IOException {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nombre);
            fichero.write(cadenaTexto + "\n");
            fichero.close();
            return true;
        } catch (Exception ex) {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    throw new IOException("No ha sido posible cerrar el fichero",e);
                }
            }
            throw new FicheroException("Se ha producido un error en la escritura del fichero", ex);
        }
    }
}
