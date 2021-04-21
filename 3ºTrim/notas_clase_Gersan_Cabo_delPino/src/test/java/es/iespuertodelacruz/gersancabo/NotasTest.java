package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NotasTest {
    Notas notas;

    @BeforeEach
    public void setUp() {
        if (notas == null) {
            notas = crearNotas();
            notas.generarNotas(40);
        }
    }

    @Test
    public void generarNotasTest() {
        assertEquals(40,notas.control.size());
    }

    @Test
    public void buscarMenorTest() {
        int menor = notas.buscarMenor();
        assertTrue(notas.control.contains(menor));
    }

    @Test
    public void buscarMayorTest() {
        int mayor = notas.buscarMayor();
        assertTrue(notas.control.contains(mayor));
    }

    @Test
    public void listarTest() {
        assertEquals(notas.control.toString(), notas.listar());
    }

    @Test
    public void constructorConParametrosNotasTest() {
        ArrayList<Integer> control = new ArrayList<>();
        int maximaNota = 0;
        int minimaNota = 0;
        int indiceMaximaNota = 0;
        int indiceMinimaNota = 0;
        int postEvaluacion = 0;
        Notas notas2 = new Notas(control, maximaNota, minimaNota, indiceMaximaNota, 
                        indiceMinimaNota, postEvaluacion);
        assertNotNull(notas2);
    }

    private Notas crearNotas() {
        Notas notas = new Notas();
        notas.setControl(new ArrayList<>());
        notas.setIndiceMaximaNota(0);
        notas.setIndiceMinimaNota(0);
        notas.setMaximaNota(0);
        notas.setMinimaNota(0);
        notas.setPostEvaluacion(0);
        return notas;
    }
}
