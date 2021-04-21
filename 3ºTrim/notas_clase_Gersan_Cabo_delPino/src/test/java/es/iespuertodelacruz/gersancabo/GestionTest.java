package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionTest {
    Gestion gestion;

    @BeforeEach
    public void setUp() {
        if (gestion == null) {
            gestion = crearGestion();
        }
    }

    @Test
    public void crearPracticasTest() {
        gestion.crearPracticas();
        assertNotNull(gestion.getPracticas());
    }

    @Test
    public void crearCalificacionesTest() {
        gestion.crearCalificaciones();
        assertNotNull(gestion.getCalificaciones());
    }

    /*@Test
    public void crearEstadisticaTest() {
        try {
            gestion.crearEstadistica();
        } catch (FicheroException e) {
            fail("Ha habido un error en la escritura del fichero");
        } catch (IOException e) {
            fail("Ha habido un error al cerrar el fichero");
        }
        File file = new File ("estadisticas");
        assertTrue(file.exists());
    }*/

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

    private Gestion crearGestion() {
        Gestion gestion = new Gestion();
        gestion.setNotas(crearNotas());
        gestion.setPracticas(new ArrayList<>());
        gestion.setCalificaciones(new ArrayList<>());
        gestion.setEscrituraFicheros(new EscrituraFicheros());
        return gestion;
    }
}
