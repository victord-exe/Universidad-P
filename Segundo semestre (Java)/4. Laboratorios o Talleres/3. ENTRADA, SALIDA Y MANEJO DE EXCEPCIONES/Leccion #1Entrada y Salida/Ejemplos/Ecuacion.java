package Ejemplos;

/*EJEMPLOS DEL PPT DE ENTRADA Y SALIDA */

public class Ecuacion {
    private int x;

    public void asignar(int x1) {
        x = x1;
    }

    public double calcular() {
        return x + Math.pow(x, x) - 35;
    }

    public int traerX() {
        return x;
    }
}
