package es.iespuertodelacruz.gersancabo.elementos;

public class Planta {
    
    String id;
    String nombre;
    int tamanio;
    float precioBase;
    float precioFinal;
    int articulos;

    public Planta(String id, String nombre, int tamanio, float precioBase, int articulos) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.precioBase = precioBase;
        this.articulos = articulos;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public float getPrecioBase() {
        return this.precioBase;
    }

    public float getPrecioFinal() {
        return this.precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getArticulos() {
        return this.articulos;
    }


    @Override
    public String toString() {
        return
            "id='" + getId() + "'" + "/n" +
            "nombre='" + getNombre() + "'" + "/n" +
            "tamanio='" + getTamanio() + "'" + "/n" +
            "precioBase='" + getPrecioBase() + "'" + "/n" +
            "precioFinal='" + getPrecioFinal() + "'" + "/n" +
            "articulos='" + getArticulos() + "'";
    }


}
