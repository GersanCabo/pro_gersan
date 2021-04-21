package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.excepcion.FrutaException;

public class GestionArrayListTest {
    private String colorDefecto = "Rojo";
    private int pesoDefecto = 17;

    private Fruta fruta;

    GestionArrayList gestionArrayList;

    @BeforeEach
    public void setUp() {
        if (gestionArrayList == null) {
            gestionArrayList = new GestionArrayList();
        }
        fruta = generarFruta("Verde", 15);

        gestionArrayList.insertar(fruta);
    }

    @AfterEach
    public void after() {
        try {
            if (!gestionArrayList.getLista().isEmpty()) {
                gestionArrayList.eliminar();
            }

        } catch (FrutaException e) {
            fail("Se producido un error eliminando el contenido de la lista");
        }
        
    }


    @Test
    public void eliminarElementoListaVaciaTest() {
        gestionArrayList.lista.clear();
        try {
            gestionArrayList.eliminar();
        } catch (FrutaException e) {
            assertTrue(e.getMessage().contains("vacia"));
        }
    }

    @Test
    public void eliminarElementoTest() {
        
        try {
            gestionArrayList.eliminar();
        } catch (FrutaException e) {
            fail("La lista no debe de estar vacia, debe de contener elementos");
        }
    }

    @Test
    public void obtenerElementoTest() {
        String contenido = gestionArrayList.toString();
        assertTrue(contenido.contains("15"),
         "No se ha obtenido la informacion de un elemento");
    }

    /**
     * Funcion que permite generar una fruta por defecto
     * @param color de la fruta
     * @param peso de la fruta
     * @return Fruta con los valores por defecto o indicados
     */
    private Fruta generarFruta(String color, int peso) {
        Fruta fruta = null;

        if (color != null && peso > 0) {
            fruta = new Fruta(color, peso);
        } else {
            fruta = new Fruta();
            fruta.setColor(colorDefecto);
            fruta.setPeso(pesoDefecto);
        }
        return fruta;

    }
}
