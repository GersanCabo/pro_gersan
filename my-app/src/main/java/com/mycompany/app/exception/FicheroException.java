package com.mycompany.app.exception;

public class FicheroException extends Exception {

    private static final long serialVersionUID = -2110297560794368840L;


    public FicheroException(String mensaje) {
        super(mensaje);
    }

    public FicheroException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
