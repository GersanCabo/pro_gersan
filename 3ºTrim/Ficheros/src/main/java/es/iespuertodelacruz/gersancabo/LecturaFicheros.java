package es.iespuertodelacruz.gersancabo;

import java.io.File;
import java.util.Scanner;

import es.iespuertodelacruz.gersancabo.exception.FicheroException;

public class LecturaFicheros {
    
    /**
    * Funcion encargada de leer un fichero
    * 
    * @param nombre nombre del fichero a leer
    * @throws FicheroException Error controlado en la lectura del fichero
    */
   public String leer(String nombre) throws FicheroException {
        StringBuilder informacion = null;
        File fichero = null;
        Scanner scanner = null;

        try {
            fichero = new File(nombre);
            if (!validarFichero(fichero)) {
                throw new FicheroException("El fichero a leer no existe");
            }
            informacion = new StringBuilder();
            scanner = new Scanner(fichero);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine(); // Guardamos la linea en un String
                informacion.append(linea + "/n");
            }
        } catch (FicheroException e) {  
            throw e;
        }catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return informacion.toString();
    }

    /**
    * Funcion que verifica si el fichero existo
    * @param fichero
    * @return
    */
    public boolean validarFichero(File fichero) {
        return fichero.exists();
    }

}
