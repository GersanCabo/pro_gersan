package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.elementos.Planta;

public class GestionPlantasTest {

    GestionPlantas gestionPlantas;
    Planta planta;
    Float ganancia;
    String id;

    @BeforeEach
    public void setUp() {
        if (gestionPlantas == null) {
            gestionPlantas = new GestionPlantas();
        }
        if (planta == null) {
            planta = crearPlanta();
        }
        if (ganancia == null) {
            ganancia = 1.25F;
        }
        if (id == null) {
            id = planta.getId();
        }
        gestionPlantas.insertar(id, planta, ganancia);
    }

    @AfterEach
    public void after() {
        if (gestionPlantas.plantas.containsKey(id)) {
            gestionPlantas.plantas.remove(id);
        }
    }

    @Test
    public void insertarTest() {
        assertTrue(gestionPlantas.plantas.containsValue(planta),"La planta no esta en la lista");
    }

    @Test
    public void buscarIdTest() {
        Planta resultado = gestionPlantas.buscarId(id);
        assertEquals(planta, resultado, "La planta encontrada no es igual a la esperada");
    }

    @Test
    public void buscarPlantaTest() {
        Planta resultado = gestionPlantas.buscarPlanta(planta);
        assertEquals(planta, resultado, "La planta encontrada no es igual a la esperada");
    }

    @Test
    public void contarArticulosTest() {
        int articulos = gestionPlantas.contarArticulos(id);
        assertEquals(planta.getArticulos(), articulos, "El numero de articulos no es correcto");
    }

    @Test
    public void eliminarTest() {
        gestionPlantas.eliminar(id);
        assertTrue(gestionPlantas.plantas.isEmpty(), "La lista no esta vacia");
    }

    @Test
    public void mostrarInformacionTest() {
        String resultado = gestionPlantas.mostrarInformacion(id);
        assertEquals(planta.toString(), resultado, "La informacion mostrada no es la esperada");
    }

    private Planta crearPlanta() {
        return new Planta("1", "test", 1, 1, 1);
    }
}
