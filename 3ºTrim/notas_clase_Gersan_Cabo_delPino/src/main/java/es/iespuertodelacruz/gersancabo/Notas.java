package es.iespuertodelacruz.gersancabo;

import java.util.ArrayList;

public class Notas {
    ArrayList<Integer> control = new ArrayList<>();
    int maximaNota = 0;
    int minimaNota = 0;
    int indiceMaximaNota;
    int indiceMinimaNota;
    int postEvaluacion;

    /**
     * Constructor con todos los parametros
     * @param control lista de notas
     * @param maximaNota nota maxima obtenida
     * @param minimaNota nota minima pbtenida
     * @param indiceMaximaNota indice marcado por la nota maxima
     * @param indMinimaNota indice marcado por la nota minima
     * @param postEvaluacion variable donde se guarda la nota referencia
     * para saber si se ha superado la nota maxima o minima
     */
    public Notas(ArrayList<Integer> control, int maximaNota, int minimaNota, int indiceMaximaNota, int indMinimaNota, int postEvaluacion) {
        this.control = new ArrayList<>();
        this.maximaNota = maximaNota;
        this.minimaNota = minimaNota;
        this.indiceMaximaNota = indiceMaximaNota;
        this.indiceMinimaNota = indMinimaNota;
        this.postEvaluacion = postEvaluacion;
    }

    /**
     * Cosntructor vacio
     */
    public Notas() {}

    public void setControl(ArrayList<Integer> control) {
        this.control = control;
    }


    public void setMaximaNota(int maximaNota) {
        this.maximaNota = maximaNota;
    }


    public void setMinimaNota(int minimaNota) {
        this.minimaNota = minimaNota;
    }

    public void setIndiceMaximaNota(int indiceMaximaNota) {
        this.indiceMaximaNota = indiceMaximaNota;
    }

    public void setIndiceMinimaNota(int indiceMinimaNota) {
        this.indiceMinimaNota = indiceMinimaNota;
    }

    public void setPostEvaluacion(int postEvaluacion) {
        this.postEvaluacion = postEvaluacion;
    }

    /**
     * Metodo que nos permite generar una lista de notas aleatorias
     * @param numeroNotas a generar
     */
    public void generarNotas(int numeroNotas) {
        for(int i=0; i < numeroNotas; i++) {
            int numero = (int)(Math.random()*11);
            control.add(numero);
        }
    }

    /**
     * Funcion que nos busca la menor nota en la lista
     * @return menor nota
     */
    public Integer buscarMenor() {
        postEvaluacion = 11;
        for(int i=0; i<control.size(); i++){
            int preEvaluacion = control.get(i);
            if (preEvaluacion < postEvaluacion){
                minimaNota = preEvaluacion;
                postEvaluacion = control.get(i);
            }
        }
        return minimaNota;
    }

    /**
     * Funcion que nos busca la mayor nota en la lista
     * @return mayor nota
     */
    public Integer buscarMayor() {
        postEvaluacion = 0;
        for(int i=0; i<control.size(); i++){
            int preEvaluacion = control.get(i);
            if (preEvaluacion > postEvaluacion){
                maximaNota = preEvaluacion;
                postEvaluacion = control.get(i);
            }
        }
        return maximaNota;
    }

    /**
     * Funcion que nos permite listar la lista
     * @return String con la lista listada
     */
    public String listar() {
        return control.toString();
    }

    /**
     * Metodo que nos permite crear unos indices
     */
    public void crearIndices() {
        indiceMinimaNota = control.indexOf(minimaNota) + 1;
        indiceMaximaNota = control.indexOf(maximaNota) + 1;
    }
}
