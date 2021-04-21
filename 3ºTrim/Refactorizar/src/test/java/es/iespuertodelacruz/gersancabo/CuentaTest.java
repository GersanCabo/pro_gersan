package es.iespuertodelacruz.gersancabo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.gersancabo.exceptions.CuentaException;

public class CuentaTest {
    Cuenta cuenta;
    double CANTIDAD = 300;
    double CANTIDAD_NEGATIVA = -1;
    double cantidadSobrepasada = 0;

    @BeforeEach
    public void setUp() {
        if (cuenta == null) {
            cuenta = crearCuenta();
        }
        if (cantidadSobrepasada == 0) {
            cantidadSobrepasada = cuenta.getSaldo() + 1;
        }
    }

    @AfterEach
    public void after() {
        if (cuenta != null) {
            cuenta = null;
        }
    }

    @Test
    public void ingresarTest() {
            double saldoEsperado = cuenta.getSaldo() + CANTIDAD;
            try {
                cuenta.ingresar(CANTIDAD);
            } catch (CuentaException e) {
                fail("No ha sido posible ingresar la cantidad");
            } finally {
                assertEquals(cuenta.getSaldo(), saldoEsperado,"El saldo no es el esperado");
            }
    }

    @Test
    public void retirarTest() {
            double saldoEsperado = cuenta.getSaldo() - CANTIDAD;
            try {
                cuenta.retirar(CANTIDAD);
            } catch (CuentaException e) {
                fail("No ha sido posible retirar la cantidad");
            } finally {
                assertEquals(cuenta.getSaldo(), saldoEsperado, "El saldo no es el esperado");
            }
    }

    @Test
    public void ingresarNegativoTest() {
        try {
            cuenta.ingresar(CANTIDAD_NEGATIVA);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("negativa"), "El mensaje de excepcion no es el esperado");
        }
    }

    @Test
    public void retirarNegativoTest() {
        try {
            cuenta.retirar(CANTIDAD_NEGATIVA);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("negativa"), "El nensaje de excepcion no es el esperado");
        }
    }

    @Test
    public void retirarInsuficienteSaldoTest() {
        try {
            cuenta.retirar(cantidadSobrepasada);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("suficiente"), "El mensaje de excepcion no es el esperado");
        }
    }

    @Test
    public void constructorVacioTest() {
        Cuenta cuentaVacia = new Cuenta();
        cuentaVacia.setIdentificador("hola");
        cuentaVacia.setNombre("mundo");
        cuentaVacia.setSaldo(1);
        cuentaVacia.setTipoInteres(0.5);
        assertNotEquals(null, cuentaVacia,"La cuenta no deberia ser nula");
    }

    @Test
    public void toStringTest() {
        String mensaje = cuenta.toString();
        assertTrue(mensaje.contains(cuenta.getNombre()),"El toString no es el esperado");
    }

    @Test
    public void generarExceptionTest() {
        Exception cuentaException = new CuentaException("mensaje de error", new Exception());
        assertTrue(cuentaException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
    }

    private Cuenta crearCuenta() {
        return new Cuenta("test","test",5000,0.5);
    }
}
