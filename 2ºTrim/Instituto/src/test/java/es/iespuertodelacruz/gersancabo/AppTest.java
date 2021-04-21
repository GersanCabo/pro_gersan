package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.elementos.Alumno;
import es.iespuertodelacruz.gersancabo.elementos.Aula;
import es.iespuertodelacruz.gersancabo.elementos.Nota;
import es.iespuertodelacruz.gersancabo.elementos.Profesor;
import es.iespuertodelacruz.gersancabo.exceptions.AppException;

public class AppTest {

    //No funcionan los tests
    //NullPointers en todos :( 

    App app;

    Nota nota;
    Alumno alumno;
    Aula aula;
    Profesor profesor;
    
    
    @BeforeEach
    public void setUp() throws AppException {
        if (app == null) {
            app = new App();
            nota = crearNota();
            app.insertar(nota);
            alumno = crearAlumno();
            app.insertar(alumno);
            aula = crearAula();
            app.insertar(aula);
            profesor = crearProfesor();
            app.insertar(profesor);
        }
    }

    @AfterEach
    public void after() {
        app.eliminar(profesor);
        app.eliminar(aula);
        app.eliminar(alumno);
        app.eliminar(nota);
    }

    @Test
    public void insertarNotasTest() {
        assertTrue(app.notas.contains(nota), "La nota no existe en la lista");
    }

    @Test
    public void insertarAlumnosTest() {
        assertTrue(app.existe(alumno), "El alumno no existe en la lista");
    }

    @Test
    public void insertarAulasTest() {
        assertTrue(app.existe(aula), "El aula no existe en la lista");
    }

    @Test
    public void insertarProfesoresTest() {
        assertTrue(app.existe(profesor), "El profesor no existe en la lista");
    }

    public Nota crearNota() {
        return new Nota("BBDD",7);
    }

    public Alumno crearAlumno() {
        return new Alumno("Pepe","Real Perez","00000000H", app.notas);
    }

    public Aula crearAula() {
        return new Aula(1,1,app.alumnos);
    }

    public Profesor crearProfesor() {
        return new Profesor("Rosa","Melano Lento","11111111A",app.aulas);
    }
}
