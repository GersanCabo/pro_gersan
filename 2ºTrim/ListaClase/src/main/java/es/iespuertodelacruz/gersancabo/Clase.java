package es.iespuertodelacruz.gersancabo;
import java.util.HashMap;

import es.iespuertodelacruz.gersancabo.elementos.Alumno;
import es.iespuertodelacruz.gersancabo.elementos.Profesor;
import es.iespuertodelacruz.gersancabo.exceptions.AlumnoException;

public class Clase {
    Profesor profesor;
    HashMap<Integer, Alumno> alumnos;


    public Clase() {
        alumnos = new HashMap<>();
    }

    /**
     * Metodo que inserta un alumno en la lista
     * @param alumno a insertar
     * @throws AlumnoException
     */
    public void insertar(Alumno alumno) throws AlumnoException {
        alumnos.put(alumno.getPosicion(), alumno);
        if (existe(alumno)) {
            throw new AlumnoException("w");
        }
        alumnos.put(alumno.getPosicion(), alumno);
    }

    /**
     * Metodo que busca un alumno
     * @param posicion del alumno
     * @return el alumno
     */
    public Alumno buscar(Integer posicion) {
        Alumno alumno = null;
        alumno = alumnos.get(posicion);
        return alumno;
    }

    /**
     * Funvion que verifica si exiset un alumno
     * @param alumno a verificar
     * @return true7false depende de si existe o no
     */
    public boolean existe(Alumno alumno) {
        Alumno alumnoAEncontrar;
        alumnoAEncontrar = buscar(alumno.getPosicion());
        if (alumnoAEncontrar != null) {
            return true;
        } 
        else return false;
    }

    /**
     * Metood que elimina un elemento de la lista
     * @param posicion del elemento a eliminar
     */
    public void eliminar(Integer posicion) {
        alumnos.remove(posicion);
    }

    public String mostrarLista() {
        return alumnos.toString();
    }
}
