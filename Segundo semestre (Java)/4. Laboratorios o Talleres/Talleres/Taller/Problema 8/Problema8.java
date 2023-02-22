import java.io.*;

public class Problema8 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Sumatoria obj = new Sumatoria();

        int i;
        int cant = 0; // n veces la formula
        double x = 0;
        double cum = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese la cantidad de veces que quiere realizar la operación");
                System.out.println("Teniendo en cuenta que n aumenta en 1 cada vez");

                cant = Integer.parseInt(br.readLine());
                leido = true;

            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }
        } while (!leido);

        do {
            try {
                System.out.println("Ingrese el valor de x");
                x = Integer.parseInt(br.readLine());
                leido = true;

            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }
        } while (!leido);

        obj.setX(x);

        for (i = 2; i <= cant+1; i++) {
            obj.setN(i);
            cum += obj.CalcularW();
        }

        System.out.println("La respuesta es: " + cum);
    }
}