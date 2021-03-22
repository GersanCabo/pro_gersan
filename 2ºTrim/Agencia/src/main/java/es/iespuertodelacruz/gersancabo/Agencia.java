package es.iespuertodelacruz.gersancabo;

import java.util.ArrayList;

import es.iespuertodelacruz.gersancabo.elementos.Destino;
import es.iespuertodelacruz.gersancabo.elementos.Pasajero;
import es.iespuertodelacruz.gersancabo.exception.PasajeroException;

/**
 * Hello world!
 *
 */
public class Agencia {

    ArrayList<Pasajero> pasajeros;
    ArrayList<Destino> destinos;

    public Agencia() {
        this.pasajeros = new ArrayList<>();
        this.destinos = new ArrayList<>();
    }

    public void insertar(Pasajero pasajero) {
        if (!existe(pasajero)) {
            pasajeros.add(pasajero);
        } else {
            throw new PasajeroException("El pasajero ");
        }
    }

    public boolean existe(Pasajero pasajero) {
        return pasajeros.contains(pasajero);
    }
}
