package es.iespuertodelacruz.gersancabo.elementos;

import java.util.ArrayList;

public class Alumno extends Persona {
    ArrayList<Nota> notas;

    /**
     * Constructor con parametros
     * @param nombre del alumno
     * @param apellidos del alumno
     * @param dni del alumno
     * @param notas obtenidas por el alumno
     */
    public Alumno(String nombre, String apellidos, String dni, ArrayList<Nota> notas) {
        super(nombre,apellidos,dni);
        this.notas = notas;
    }

    /**
     * Constructor vacio
     */
    public Alumno() {
    }

    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

}
