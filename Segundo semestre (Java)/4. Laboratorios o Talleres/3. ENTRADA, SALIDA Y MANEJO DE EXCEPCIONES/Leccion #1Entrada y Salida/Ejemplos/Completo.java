package Ejemplos;

import java.io.*;

public class Completo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Promedio obj = new Promedio();

        String input;
        int a, b, c;
        
        System.out.println("Introduzca el primer entero");
        input = br.readLine();
        a = Integer.parseInt(input);

        System.out.println("Introduzca el segundo entero");
        input = br.readLine();
        b = Integer.parseInt(input);

        System.out.println("Introduzca tercer entero");
        input = br.readLine();
        c = Integer.parseInt(input);
        obj.asignar(a, b, c);

        System.out.println(" PROMEDIO:" + obj.calcular());
    }
}
