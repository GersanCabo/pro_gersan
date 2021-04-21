package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.api.Fruta;
import es.iespuertodelacruz.gersancabo.controlador.FrutaController;
import es.iespuertodelacruz.gersancabo.exception.FrutaException;

public class FrutaControllerTest extends UtilidadesTest{
    FrutaController frutaController;
    Fruta fruta;

    @BeforeEach
    public void setUp() {
        if (fruta == null) {
            fruta = generarfruta("identificador", "nombre", 1f, 1f);
        }
    }

    @Test
    public void validarTest() {
        try {
            frutaController.validarFruta(fruta);
        } catch (FrutaException e) {
            fail("Se ha producido un error validando la fruta no controlado");
        }
    }
}
