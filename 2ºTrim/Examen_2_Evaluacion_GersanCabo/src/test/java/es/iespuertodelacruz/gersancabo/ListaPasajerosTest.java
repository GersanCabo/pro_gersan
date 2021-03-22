package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.elementos.Ciudad;
import es.iespuertodelacruz.gersancabo.elementos.Pasajero;
import es.iespuertodelacruz.gersancabo.exceptions.PasajeroException;

public class ListaPasajerosTest {
    
    ListaPasajeros pasajeros;
    ListaCiudades ciudades;
    Pasajero pasajero;
    Ciudad ciudad;
    
    @BeforeEach
    public void setUp() {
        if (pasajeros == null) {
            pasajeros = new ListaPasajeros();
            pasajero = crearPasajero();
            try {
                pasajeros.insertar(pasajero);
            } catch (PasajeroException e) {
                fail("Ha ocurrido un error al insertar el pasajero");
            }
        }

        if (ciudades == null) {
            ciudades = new ListaCiudades();
            ciudad = crearCiudad();
            ciudades.insertar(ciudad);
        }

    }

    @AfterEach
    public void after() {
        pasajeros.eliminar(pasajero);
        ciudades.eliminar(ciudad);
    }

    @Test
    public void insertarPasajeroTest() {
        assertTrue(pasajeros.existe(pasajero), "El pasajero no existe en la lista");
    }

    @Test
    public void noInsertarPasajeroTest() {
        Pasajero pasajero = new Pasajero("0000000H","Pepe","Madrid");
        assertFalse(pasajeros.existe(pasajero), "El pasajero existe en la lista y no deberia");
    }

    @Test
    public void insertarCiudadTest() {
        assertTrue(ciudades.existe(ciudad), "La ciudad no existe en la lista");
    }

    @Test
    public void mostrarCiudadesTest() {
        String dni = "00000000H";
        assertTrue(pasajeros.mostrarCiudades(dni).contains("Madrid"), "No existe ningun pasajero con ese dni");
    }
    

    private Pasajero crearPasajero() {
        return new Pasajero("00000000H","Pepe","Madrid");
    }

    private Ciudad crearCiudad() {
        return new Ciudad("Madrid","Espania");
    }

}
