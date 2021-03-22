package es.iespuertodelacruz.gersancabo.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DniValidacion {
    private String patron = "^[0-9]{8}[A-Z-a-z]";
    Pattern pattern;
    Matcher matcher;

    /**
     * Funcion que evalua si un dni es valido
     *
     * @param valor a evaluar
     * @return true/false en funcion si es correcto o no
     */
    public boolean validar(String valor) {
        boolean resultado = false;

        this.pattern = Pattern.compile(patron);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();

        return resultado;
    }
}
