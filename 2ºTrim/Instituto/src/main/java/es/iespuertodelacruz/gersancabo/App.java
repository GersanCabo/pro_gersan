package es.iespuertodelacruz.gersancabo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import es.iespuertodelacruz.gersancabo.elementos.Alumno;
import es.iespuertodelacruz.gersancabo.elementos.Aula;
import es.iespuertodelacruz.gersancabo.elementos.Nota;
import es.iespuertodelacruz.gersancabo.elementos.Profesor;

public class App {

    ArrayList<Profesor> profesores;
    ArrayList<Nota> notas;
    ArrayList<Aula> aulas;
    ArrayList<Alumno> alumnos;

    //---------------------------------------------------
    //METODOS PARA PROFESOR
    //---------------------------------------------------

    /**
     * Metodo para insertar un profesor en la lista
     * @param profesor a insertar
     */
    public void insertar(Profesor profesor) {
        profesores.add(profesor);
    }

    /**
     * Metodo para eliminar un profesor de la lista
     * @param profesor a eliminar
     */
    public void eliminar(Profesor profesor) {
        profesores.remove(profesor);
    }

    /**
     * Metodo para comprobar si un profesor existe en la lista
     * @param profesor a comprobar
     * @return true/false depende de si existe el profesor
     */
    public boolean existe(Profesor profesor) {
        return profesores.contains(profesor);
    }

    //---------------------------------------------------
    //METODOS PARA AULA
    //---------------------------------------------------
    
    /**
     * Metodo para insertar un aula en la lista
     * @param aula a insertar
     */
    public void insertar(Aula aula) {
        aulas.add(aula);
    }

    /**
     * Metodo para eliminar un aula de la lista
     * @param aula a eliminar
     */
    public void eliminar(Aula aula) {
        aulas.remove(aula);
    }

    /**
     * Metodo para comprobar si un aula existe en la lista
     * @param aula a comprobar
     * @return true/false depende de si existe el aula
     */
    public boolean existe(Aula aula) {
        return aulas.contains(aula);
    }

    //---------------------------------------------------
    //METODOS PARA ALUMNO
    //---------------------------------------------------

    /**
     * Metodo para insertar un alumno en la lista 
     * @param alumno a insertar
     */
    public void insertar(Alumno alumno) {
        alumnos.add(alumno);
    }

    /**
     * Metodo para eliminar un alumno de la lista
     * @param alumno a eliminar
     */
    public void eliminar(Alumno alumno) {
        alumnos.remove(alumno);
    }

    /**
     * Metodo para comprobar si un alumno existe en la lista
     * @param alumno a comprobar
     * @return true/false depende de si existe el alumno
     */
    public boolean existe(Alumno alumno) {
        return alumnos.contains(alumno);
    }

    //---------------------------------------------------
    //METODOS PARA NOTA
    //---------------------------------------------------

    /**
     * Metodo para insertar una nota en la lista
     * @param nota a insertar
     */
    public void insertar(Nota nota) {
        notas.add(nota);
    }

    /**
     * MEtodo para eliminar una nota de la lista
     * @param nota a eliminar
     */
    public void eliminar(Nota nota) {
        notas.remove(nota);
    }

    /**
     * Metodo para comprobar si una nota existe en la lista
     * @param nota a comprobar
     * @return true/false depende de si existe la nota
     */
    public boolean existe(Nota nota) {
        return notas.contains(nota);
    }

    //---------------------------------------------------
    //METODOS PEDIDOS POR EL EJERCICIO
    //---------------------------------------------------

    /**
     * Metodo que lista todos los alumnos, con sus respectivas notas
     */
    public void listarNotas() {
        alumnos.toString();
    }

    /**
     * Metodo que vuelca en un fichero los atributos de todos los alumnos,
     * incluyendo sus notas
     * @throws IOException excepcion en caso de error
     */
    public void volcadoFichero() throws IOException {
        File fichero = new File("Notas.txt");
        
        try (FileWriter writer = new FileWriter(fichero);) {
            writer.write(alumnos.toString());
        }
    }

    /**
     * Metodo que busca un alumno especifico y, si lo encuentra,
     * vuelca sus datos y notas en un fichero
     * @throws IOException excepcion en caso de error
     */
    public void volcadoNotasAlumno(String dni) throws IOException {
        boolean encontrar = false;
        int i = 0;
        while(i < alumnos.size() || !encontrar) {
            Alumno alumno = alumnos.get(i);
            if (alumno.getDni().equalsIgnoreCase(dni)) {
                encontrar = true;
                File fichero = new File(alumno.getNombre() + "_" + alumno.getApellidos() + ".txt");
                try (FileWriter writer = new FileWriter(fichero);) {
                    writer.write(alumno.toString());
                }
            }
            i++;
        }
    }
}
