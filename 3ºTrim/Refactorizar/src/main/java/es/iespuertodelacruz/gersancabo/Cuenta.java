package es.iespuertodelacruz.gersancabo;

import es.iespuertodelacruz.gersancabo.exceptions.CuentaException;

public class Cuenta {
    private String nombre;
    private String identificador;
    private double saldo;
    private double tipoInteres;

    /**
     * Constructor vacio
     */
    public Cuenta(){}

    /**
     * Constructor con los atributos
     * @param nombre del titular
     * @param identificador de la cuenta
     * @param saldo en la cuenta
     * @param tipoInteres asignado a la cuenta
     */
    public Cuenta(String nombre, String identificador, double saldo, double tipoInteres) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.saldo = saldo;
        this.tipoInteres = tipoInteres;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoInteres() {
        return this.tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * Metodo que nos permite ingresar en la cuenta
     * @param cantidad a ingresar
     * @throws CuentaException excepcion personalizada
     */
    public void ingresar(double cantidad) throws CuentaException {
        if (cantidad<0) {
            throw new CuentaException("No se puede ingresar una cantidad negativa");
        } else {
            saldo = saldo + cantidad;
        }   
    }

    /**
     * Metodo que nos permite retirar de la cuenta
     * @param cantidad a retirar
     * @throws CuentaException excepcion personalizada
     */
    public void retirar(double cantidad) throws CuentaException {
        if (cantidad <= 0) {
            throw new CuentaException("No se puede retirar una cantidad negativa");
        } else if (getSaldo() < cantidad) {
            throw new CuentaException("No hay suficiente saldo");
        } else {
            saldo = saldo - cantidad;
        }
    }

    /**
     * Funcion toString sobreescrita
     */
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            ", saldo='" + getSaldo() + "'" +
            ", tipoInteres='" + getTipoInteres() + "'" +
            "}";
    }
}
