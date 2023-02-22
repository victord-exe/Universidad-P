package Ejemplos;

import java.io.*;

public class LabC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Ecuacion obj = new Ecuacion();
        int x;
        System.out.println("Introduzca el valor de x como entero");
        x = Integer.parseInt(br.readLine());
        obj.asignar(x);
        System.out.println(" x=" + obj.calcular());
    }
}
