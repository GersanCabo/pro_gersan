package es.iespuertodelacruz.gersancabo;

import java.util.ArrayList;

import es.iespuertodelacruz.gersancabo.elementos.Pasajero;
import es.iespuertodelacruz.gersancabo.exceptions.PasajeroException;

public class ListaPasajeros {
    
    ArrayList <Pasajero> pasajeros = new ArrayList<>();
    

    public ListaPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }


    public ListaPasajeros() {
    }

    /**
     * Metodo que inserta un pasajero
     * @param pasajero a insertar
     * @throws PasajeroException excepcion en caso de error al insertar
     */
    public void insertar(Pasajero pasajero) throws PasajeroException {
        if (!existe(pasajero)) {
            pasajeros.add(pasajero);
        } else {
            throw new PasajeroException("No se ha podido insertar el pasajero");
        }
    }

    /**
     * Metodo que nos dice si un pasajero existe en la lista o no
     * @param pasajero a buscar
     * @return true/false dependiendo de si existe o no
     */
    public boolean existe(Pasajero pasajero) {
        return pasajeros.contains(pasajero);
    }

    /**
     * Metodo que elimina un pasajero
     * @param pasajero a eliminar
     */
    public void eliminar(Pasajero pasajero) {
        pasajeros.remove(pasajero);
    }

    /**
     * Metodo que busca un pasajero segun su dni
     * @param dni del pasajero a buscar
     * @return el pasajero si esta en la lista
     */
    public Pasajero buscar(String dni) {
        boolean encontrar = false;
        int i = 0;
        Pasajero pasajeroEncontrado = null;
        while(i < pasajeros.size() || !encontrar) {
            Pasajero pasajero = pasajeros.get(i);
            if (pasajero.getDni().equalsIgnoreCase(dni)) {
                encontrar = true;
                pasajeroEncontrado = pasajero;
            }
            i++;
        }
        
        return pasajeroEncontrado;
    }

    /**
     * Metodo que nos muestra las ciudades donde ha estado el pasajero
     * @param dni del pasajero
     * @return un String con la ciudad
     */
    public String mostrarCiudades(String dni) {
        Pasajero pasajero = buscar(dni);
        return pasajero.getCiudad();
    }

}
