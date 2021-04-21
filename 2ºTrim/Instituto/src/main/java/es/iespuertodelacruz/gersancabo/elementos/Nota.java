package es.iespuertodelacruz.gersancabo.elementos;

public class Nota {
    String nombre;
    float calificacion;

    /**
     * Constructor con parametros
     * @param nombre de la asignatura
     * @param calificacion obtenida en la asignatura
     */
    public Nota(String nombre, float calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    /**
     * Constructor vacio
     */
    public Nota() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

}
