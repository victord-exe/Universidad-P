package Ejemplos;

import java.io.*;

public class Ejemplo2 {
    public static void main(String args[]) {

        String input;
        float rata = 0;
        int horas = 0;
        String nombre = "";
        Salario persona = new Salario();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\n****** Calculo del Salario*****\n\n");
        boolean leido = true;
        char resp = 's';
        while (resp == 's' || resp == 'S') {
            try {
                System.out.println("\n\n NOMBRE: ");
                nombre = br.readLine();
            } catch (IOException er) {
                System.out.println(er);
            }
            do {
                try {
                    System.out.println("\n\n RATA POR HORA");
                    input = br.readLine();
                    rata = Float.parseFloat(input);
                    leido = true;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Ingrese un valor real adecuado ");
                    leido = false;
                } catch (IOException e) {
                    System.out.println(e);
                }
            } while (!leido);

        }
        persona.asignar(rata, horas, nombre);
    }
}
