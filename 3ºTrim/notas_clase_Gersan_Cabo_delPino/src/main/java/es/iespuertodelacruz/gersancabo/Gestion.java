package es.iespuertodelacruz.gersancabo;

import java.io.IOException;
import java.util.ArrayList;

import es.iespuertodelacruz.gersancabo.exceptions.FicheroException;

public class Gestion {
    Notas notas = new Notas();
    ArrayList<Float> calificaciones = new ArrayList<>();
    ArrayList<Integer> practicas = new ArrayList<>();
    EscrituraFicheros escrituraFicheros = new EscrituraFicheros();

    /**
     * Constructor con parametros
     * @param notas obtenidas
     * @param calificaciones obtenidas
     * @param practicas obtenidas
     * @param escrituraFicheros clase para escribir en un fichero los resultados
     */
    public Gestion(Notas notas, ArrayList<Float> calificaciones, ArrayList<Integer> practicas, EscrituraFicheros escrituraFicheros) {
        this.notas = notas;
        this.calificaciones = calificaciones;
        this.practicas = practicas;
        this.escrituraFicheros = escrituraFicheros;
    }

    /**
     * Constructor vacio
     */
    public Gestion() {}


    public Notas getNotas() {
        return this.notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public ArrayList<Float> getCalificaciones() {
        return this.calificaciones;
    }

    public void setCalificaciones(ArrayList<Float> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public ArrayList<Integer> getPracticas() {
        return this.practicas;
    }

    public void setPracticas(ArrayList<Integer> practicas) {
        this.practicas = practicas;
    }

    public EscrituraFicheros getEscrituraFicheros() {
        return this.escrituraFicheros;
    }

    public void setEscrituraFicheros(EscrituraFicheros escrituraFicheros) {
        this.escrituraFicheros = escrituraFicheros;
    }

    /**
     * Metodo que nos permite crear una lista de notas aleatorias para la practica
     */
    public void crearPracticas() {
        for(int i=0; i < notas.control.size(); i++) {
            int numero = (int)(Math.random()*11);
            practicas.set(i,numero);
        }
    }

    /**
     * Metodo que nos permite crear una lista de calificaciones segun el 
     * resultado de la practica y de la nota
     */
    public void crearCalificaciones() {
        for(int i = 0; i<notas.control.size(); i++){
            float numero = ((float) notas.control.get(i) 
                    + (float) practicas.get(i) 
                    / 2);
            calificaciones.set(i,numero);
        }
    }

    /**
     * Metodo que nos crea un fichero con las estadisticas de nuestra lista
     * @throws FicheroException excepcion personalizada
     * @throws IOException excepcion
     */
    public void crearEstadistica() throws FicheroException, IOException {
        ArrayList<Float> estadistica = new ArrayList<>();
        String documento = "";
      
        for (int i=0; i<10; i++){
            float count = 0;
            float sum = 0;
            for (int j=0; j<notas.control.size(); j++){
                if ((i < calificaciones.get(j)) && ((i+1) >= calificaciones.get(j) )) {
                    sum += calificaciones.get(j);
                    count += 1;
                }
            }
            if (count != 0){
                float numero = ( (float)count / notas.control.size());
                estadistica.set(i, numero);
            }else{ 
                estadistica.set(i, 0F);
            }
            double sol = (Math.round(estadistica.get(i) * 10000.0)) / 100.0;
            String notaTramo = "Estadistica nota tramo <=" + (i+1) + 
            "=" + sol + "%"+ "\n";
            documento.concat(notaTramo);
        }
        escrituraFicheros.crear("estadisticas", documento);
    }

    /**
     * Metodo que nos permite escribir en un fichero los aprobados y suspendidos
     * @throws FicheroException excepcion personalizada
     * @throws IOException excepcion
     */
    public void verAprobadosSuspensos() throws FicheroException, IOException {
        ArrayList<Integer> aprobados = new ArrayList<>();
        ArrayList<Integer> suspensos = new ArrayList<>();
        int numeroAprobados = 0;
        int numeroSuspensos = 0;
        for (int i=0; i<notas.control.size(); i++){
            if (notas.control.get(i) < 5){
                aprobados.add(i);
                numeroAprobados += 1;
            }else { 
                suspensos.add(i);
                numeroSuspensos += 1;
            }
        }
        String datos = "Numero aprobados: " + numeroAprobados + "\n" + 
                        "Numero suspensos: " + numeroSuspensos + "\n" + 
                        "Lista aprobados: " + aprobados.toString() + "\n" + 
                        "Lista suspendidos: " + suspensos.toString();
        escrituraFicheros.crear("aprobados y suspensos", datos);
    }
}
