package es.iespuertodelacruz.gersancabo.elementos;

import java.util.ArrayList;

public class Aula {
    int piso;
    int numero;
    ArrayList<Alumno> alumnos;

    /**
     * Constructor con parametros
     * @param piso en el que esta el aula
     * @param numero del aula
     * @param alumnos lista de alumnos que tienen clase en el aula
     */
    public Aula(int piso, int numero, ArrayList<Alumno> alumnos) {
        this.piso = piso;
        this.numero = numero;
        this.alumnos = alumnos;
    }

    /**
     * Constructor vacio
     */
    public Aula() {
    }

    public int getPiso() {
        return this.piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
}
