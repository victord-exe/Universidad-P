package Ejemplos;


/*EJEMPLOS DEL PPT DE ENTRADA Y SALIDA CON MANEJO DE EXCEPCIONES */


public class Salario {
    private String nom;
    private float tar;
    private int hora;

    public void asignar(float t, int h, String n) {
        nom = n;
        hora = h;
        tar = t;
    }

    public float calcular() {
        return tar * hora;
    }

    String traerN() {
        return nom;
    }

    float traerT() {
        return tar;
    }

    int traerH() {
        return hora;
    }
}
