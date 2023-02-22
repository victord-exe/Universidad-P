package Ejemplos;

/*EJEMPLOS DEL PPT DE ENTRADA Y SALIDA */

public class Promedio {
    private int num1, num2, num3;

    public void asignar(int n1, int n2, int n3) {
        num1 = n1;
        num2 = n2;
        num3 = n3;
    }

    public int calcular() {
        return (num1 + num2 + num3) / 3;
    }

    public int traer() {
        return num1;
    }

    public int traer2() {
        return num2;
    }

    public int traer3() {
        return num3;
    }
}
