package es.iespuertodelacruz.gersancabo;

import java.util.HashMap;

import es.iespuertodelacruz.gersancabo.elementos.Planta;

public class GestionPlantas {

    HashMap<String, Planta> plantas = null;

    /**
     * Constructor
     */
    public GestionPlantas() {
        plantas = new HashMap<>();
    }     

    /**
     * Metodo que inserta una planta en la lista
     * @param id de la planta
     * @param planta a insertar
     */
    public void insertar(String id, Planta planta, Float ganancia) {
        planta.setPrecioFinal(planta.getPrecioBase()*ganancia);
        plantas.put(id, planta);
    }

    /**
     * Funcion que busca una planta mediante su id
     * @param id de la planta a buscar
     * @return la planta con esa id
     */
    public Planta buscarId(String id) {
        return plantas.get(id);
    }

    /**
     * Funcion que busca una planta en la lista
     * @param planta a buscar
     * @return planta encontrada
     */
    public Planta buscarPlanta(Planta planta) {
        String id = planta.getId();
        return plantas.get(id);
    }

    /**
     * Funcion que cuenta los articulos que tiene una 
     * determinada planta
     * @param id de la planta de la que queremos ver 
     * su numero de articulos
     * @return numero de articulos (int)
     */
    public int contarArticulos(String id) {
        Planta planta = buscarId(id);
        return planta.getArticulos();
    }

    /**
     * Metodo que elimina una planta de la lista
     * @param id de la planta a eliminar
     */
    public void eliminar(String id) {
        plantas.remove(id);
    }

    /**
     * Funcion que nos muestra la informacion de una planta
     * @param id de la planta de la que queremos obtener informacion
     */
    public String mostrarInformacion(String id) {
        Planta planta = buscarId(id);
        return planta.toString();
    }
}
