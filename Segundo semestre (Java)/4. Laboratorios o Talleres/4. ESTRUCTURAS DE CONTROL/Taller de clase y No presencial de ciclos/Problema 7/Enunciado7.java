import java.io.*;

public class Enunciado7 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Serie obj = new Serie();

        int i;
        double cant = 0;
        double x = 0;
        double cum = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese el valor de n");
                System.out.println("Teniendo en cuenta que n aumenta en 2 cada vez");

                cant = Double.parseDouble(br.readLine());
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
                System.out.println("Ingrese el valor de 'a'");
                x = Integer.parseInt(br.readLine());

                while (x < 0) {
                    System.out.println("el valor de 'a' no puede ser negativo, ingrese nuevamente");
                    x = Integer.parseInt(br.readLine());

                }

                leido = true;

            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }
        } while (!leido);

        obj.setA(x);

        for (i = 3; i < cant; i = i + 2) {

            obj.setN(i);
            cum += obj.CalcularS();
        }
        cum = cum + 1 + (x / cant);
        System.out.println("La respuesta es: " + cum);
    }
}
