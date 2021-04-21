package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.exception.FicheroException;

/**
 * Unit test for simple App.
 */
public class EscrituraFicheroTest {

    EscrituraFicheros escrituraFicheros = new EscrituraFicheros();

    String nombre = "testEscritura.txt";
    String cadena = "hola mundo";

    @Test
    public void crearFicheroTest() throws FicheroException, IOException {
        assertTrue(escrituraFicheros.crear(nombre, cadena), "Ha fallado la creacion del fichero");
    }

}
