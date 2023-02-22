import java.io.*;

public class Main {
    public static void main(String[] args) {

        /* Objetos */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Variables */
        char jornada;
        String lectura;
        int a;

        /* Procesos */

        System.out.println("\n    Bienvenido a ");
        System.out.println(" *** EL CONEJO ***\n");

        System.out.println("Digite el turno M/T");
        System.out.println("M --> mañana");
        System.out.println("T --> Tarde");

        try {
            jornada = (char) Character.toUpperCase(br.read());

            try {
                while (jornada != 'M' || jornada != 'T') {
                    System.out.println("Caracter invalido, intente de nuevo.");
                    jornada = (char) Character.toUpperCase(br.read());

                }
            } catch (IOException e) {
                System.out.println("ERROR " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR " + er);
                // leido = false;
            }

            System.out.println("el caracter leido es " + jornada);

        } catch (IOException e) {
            System.out.println("ERROR " + e);
        } catch (NumberFormatException er) {
            System.out.println("ERROR " + er);
            // leido = false;
        }

        System.out.println("Digite el número del servicio que desea utilizar");
        try {
            a = Integer.parseInt(br.readLine());
            while (a < 0 && a > 4) {

            }
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        } catch (NumberFormatException er) {
            System.out.println("ERROR " + er);
            // leido = false;
            System.out.println("");

        }
    }
}
