package es.iespuertodelacruz.gersancabo.elementos;

import es.iespuertodelacruz.gersancabo.validacion.PersonaValidacion;

public class Persona extends PersonaValidacion {
    String nombre;
    String apellidos;
    String dni;

    /**
     * Constructor con parametros
     * @param nombre de la persona
     * @param apellidos de la persona
     * @param dni de la persona
     */
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        validar(dni);
        this.dni = dni;
    }

    /**
     * Constructor vacio
     */
    public Persona() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


}
