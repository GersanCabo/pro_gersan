package es.iespuertodelacruz.gersancabo.elementos;

import java.util.Objects;

public class Ciudad {
    String nombre;
    String pais;


    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Ciudad() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ciudad)) {
            return false;
        }
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(nombre, ciudad.nombre) && Objects.equals(pais, ciudad.pais);
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", pais='" + getPais() + "'" +
            "}";
    }
    

}
