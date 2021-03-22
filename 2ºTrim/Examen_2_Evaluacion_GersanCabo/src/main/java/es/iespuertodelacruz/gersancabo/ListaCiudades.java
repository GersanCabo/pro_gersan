package es.iespuertodelacruz.gersancabo;

import java.util.ArrayList;

import es.iespuertodelacruz.gersancabo.elementos.Ciudad;

public class ListaCiudades {
    
    ArrayList<Ciudad> ciudades = new ArrayList<>();


    public ListaCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }


    public ListaCiudades() {
    }

    /**
     * Metodo para insertar una ciudad
     * @param ciudad a insertar
     */
    public void insertar(Ciudad ciudad) {
        if (!existe(ciudad)) {
            ciudades.add(ciudad);
        } else {
            //Exception 
        }
    }

    /**
     * Metodo que comprueba si una ciudad existe en la lista
     * @param ciudad a buscar
     * @return true/false depende de si existe o no
     */
    public boolean existe(Ciudad ciudad) {
        return ciudades.contains(ciudad);
    }

    /**
     * Metodo que elimina una ciudad
     * @param ciudad a eliminar
     */
    public void eliminar(Ciudad ciudad) {
        ciudades.remove(ciudad);
    }



}
