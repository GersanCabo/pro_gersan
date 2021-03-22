package es.iespuertodelacruz.gersancabo.elementos;

import java.util.Objects;

import es.iespuertodelacruz.gersancabo.exceptions.PasajeroException;
import es.iespuertodelacruz.gersancabo.validaciones.DniValidacion;

public class Pasajero {
    String dni;
    String nombre;
    String ciudad;


    public Pasajero(String dni, String nombre, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }


    public Pasajero() {
    }


    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) throws PasajeroException {
        DniValidacion validacion = new DniValidacion();
        if (validacion.validar(dni)) {
            this.dni = dni;
        } else {
            throw new PasajeroException("El dni no es valido");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pasajero)) {
            return false;
        }
        Pasajero pasajero = (Pasajero) o;
        return Objects.equals(dni, pasajero.dni) && Objects.equals(nombre, pasajero.nombre) && Objects.equals(ciudad, pasajero.ciudad);
    }

    
}
