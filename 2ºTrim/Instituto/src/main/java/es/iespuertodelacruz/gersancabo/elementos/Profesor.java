package es.iespuertodelacruz.gersancabo.elementos;

import java.util.ArrayList;

public class Profesor extends Persona {
    ArrayList<Aula> aulas;

    /**
     * Cosntructor con parametros
     * @param nombre del profesor
     * @param apellidos del profesor
     * @param dni del profesor
     * @param aulas en las que da clase el profesor
     */
    public Profesor(String nombre, String apellidos, String dni, ArrayList<Aula> aulas) {
        super(nombre, apellidos, dni);
        this.aulas = aulas;
    }

    /**
     * Constructor vacio
     */
    public Profesor() {
    }

    public ArrayList<Aula> getAulas() {
        return this.aulas;
    }

    public void setAulas(ArrayList<Aula> aulas) {
        this.aulas = aulas;
    }

}
