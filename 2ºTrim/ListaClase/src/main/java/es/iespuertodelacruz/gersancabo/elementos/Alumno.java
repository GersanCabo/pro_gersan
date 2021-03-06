package es.iespuertodelacruz.gersancabo.elementos;

public class Alumno extends Persona {
    int posicion;


    public Alumno(String nombre, String apellido, int posicion) {
        super(nombre, apellido);
        this.posicion = posicion;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }


    @Override
    public String toString() {
        return "{" +
            " posicion='" + getPosicion() + "'" +
            "}";
    }
    

}
