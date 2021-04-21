package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.elementos.Alumno;
import es.iespuertodelacruz.gersancabo.exceptions.AlumnoException;

/**
 * Unit test for simple App.
 */
public class ClaseTest {

    Clase clase;

    @BeforeEach
    public void setUp() {
        if (clase == null) {
            clase = new Clase();
        }
        try {
            clase.insertar(crearAlumnoTest());
        } catch (AlumnoException e) {
            fail("Se ah producido un error al crear la lista de inicio");
        }
    }

    @Test
    public void insertarTestAlumno() {
        assertEquals(1,clase.alumnos.size(),
        "No se ha insertado correctamente el alumno");
    }

    @Test
    public void insertarTestErrorAlumno() {
        try {
            clase.insertar(crearAlumnoTest());
        } catch (AlumnoException e) {
            assertTrue(e.getMessage().contains("w"));
        }
        fail("No debe llegar hasta aquí el test");
    }

    @Test
    public void eliminarAlumno() {
        clase.eliminar(1);
        //assertEquals(clase.alumnos.size(), 0, "No se");
        assertTrue(clase.alumnos.isEmpty(),
        "No se ha eliminado el alumno de la lista");
    }

    private Alumno crearAlumnoTest() {
        return new Alumno("test", "test", 1);
    }
}
