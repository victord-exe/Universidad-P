import java.io.*;

public class Parcial2 {
    public static void main(String[] args) {
        /* Declaración de objetos */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Exponentes obj = new Exponentes();

        /* Declaración de variables */
        double n1 = 0;
        double n2 = 0;
        double suma = 0;
        boolean leido = true;
        String resp = "";

        /* Procedimientos */

        do {
            /* Ingresar por teclado n1 */
            do {
                try {
                    System.out.println("Ingrese un numero positivo");
                    n1 = Double.parseDouble(br.readLine());
                    leido = true;

                    if (n1 < 1) {
                        System.out.println("ERROR: numero negativo");
                        leido = false;
                    }
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR " + er);
                    leido = false;
                }
            } while (!leido);

            /* Ingresar por teclado n2 */
            do {
                try {
                    System.out.println("Ingrese un numero positivo");
                    n2 = Double.parseDouble(br.readLine());
                    leido = true;

                    if (n2 < 1) {
                        System.out.println("ERROR: numero negativo");
                        leido = false;
                    }
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR " + er);
                    leido = false;
                }
            } while (!leido);

            obj.setN1(n1);
            obj.setN2(n2);

            System.out.println("Respuesta: " + obj.Hallarvalor());
            System.out.println("Sumatoria de las exponenciaciones: " + obj.Sumar(suma) + "\n");

            do {
                try {
                    System.out.println("¿Desea ejecutar el programa de nuevo?");
                    System.out.println("Si / No");
                    resp = br.readLine().toLowerCase();
                    leido = true;

                    if ((resp.equals("si")) || resp.equals("no")) {
                    } else {
                        System.out.println("ERROR");
                        leido = false;
                    }
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                }
            } while (!leido);

            if (resp.equals("no")) {
                leido = false;
            }
        } while (leido);
    }

}
