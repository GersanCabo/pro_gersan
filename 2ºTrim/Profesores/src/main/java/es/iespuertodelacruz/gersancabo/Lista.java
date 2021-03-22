package es.iespuertodelacruz.gersancabo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import es.iespuertodelacruz.gersancabo.elementos.Profesor;

public class Lista {
    ArrayList<Profesor> lista = null;

    /**
     * Constructor por defecto de lista
     */
    public Lista() {
        lista = new ArrayList<>();
     }

     /**
      * Metodo encargado de relaizar insercion en la lista
      * @param profesor a insertar
     * @throws ProfesorException
      */
     public void insertar(Profesor profesor) throws ProfesorException {
        if (!existe(profesor)) {
            lista.add(profesor);
        } else {
            throw new ProfesorException("El profesor con DNI: "+profesor.getDni()+
            "ya existe en la lista");
        }
        
     }

     /**
      * Funcion encargada de verificar si existe el profesor 
        en la lista
      * @param profesor a buscar
      * @return existe true/false
      */

      public boolean existe(Profesor profesor) {
          /**
         boolean existe = false;
         int i = 0;
         while (i < lista.size() && !existe) {
             if (profesor.getDni().equals(lista.get(i).getDni())) {
                 existe = true;
             }
             i++;
         }
         return existe;
         // Pero pa poner esto mejor poner lo de abajo pero con el equals en profesor
         */
        return lista.contains(profesor);
     }

     /**
      * Funcion encargada de eliminar un elemento de la lista
      * @param profesor a eliminar
      */
     public void eliminar(Profesor profesor) {
        lista.remove(profesor);
     }

     /**
      * Funcion encargada de listar los elementos de la lista
      * @return String con todos los elementos de la lista
      */
     public String listar() {
        return lista.toString();
     }

     /**
      * Metodo encargado de almamcenar la informacion de la lista
      */
     public void almacenarDatos(String nombreFichero) {
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(nombreFichero);
            myWriter.write(listar());

        } catch (Exception e) {
            //TODO: handle exception
            //throw ...
        } finally {
            try {
                myWriter.close();
            } catch (IOException e) {
                // throw ... debe ser una excepcion de fichero (FicheroException)
                // o throw new Exception("Mensaje de error")
            }
        }
     }
}
