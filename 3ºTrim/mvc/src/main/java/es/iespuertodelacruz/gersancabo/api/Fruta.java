package es.iespuertodelacruz.gersancabo.api;

/**
 * Clase fruta de la aplicacion
 */
public class Fruta {
    String identificador;
    String nombre;
    float precio;
    float coste;

    /**
     * Constructor con todas las propiedades de la fruta
     * @param identificador de la fruta
     * @param nombre de la fruta
     * @param precio de la fruta
     * @param coste de la fruta
     */
    public Fruta(String identificador, String nombre, float precio, float coste) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.precio = precio;
        this.coste = coste;
    }

    public Fruta() {}
    
    
    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCoste() {
        return this.coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    /**
     * Funcio que realiza el calculo de una fruta
     * @return beneficio por fruta
     */
    public float beneficio() {
        return precio - coste;
    }

}
