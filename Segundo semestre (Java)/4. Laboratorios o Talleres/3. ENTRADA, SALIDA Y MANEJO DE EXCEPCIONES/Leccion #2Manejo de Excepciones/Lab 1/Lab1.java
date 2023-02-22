import java.io.*;

public class Lab1 {

    /*
     * Imprima cantidad de pelotas compradas, el
     * descuento y el precio total a pagar.
     */

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Compras obj = new Compras();

        int cp = 0;
        double p = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese la cantidad de pelotas a comprar: ");
                cp = Integer.parseInt(br.readLine());
                leido = true;
            } catch (NumberFormatException er) {
                System.out.println("ERROR");
            } catch (IOException e) {
                System.out.println("ERROR");
                leido = false;
            }

        } while (!leido);

        do {
            try {
                System.out.println("Ingrese el precio de las pelotas: ");
                p = Double.parseDouble(br.readLine());
                leido = true;
                while (p < 0) {
                    System.out.println("No se puede ingresar numeros negativos. Ingrese otro número: ");
                    p = Double.parseDouble(br.readLine());
                }
            } catch (NumberFormatException er) {
                System.out.println("ERROR");
            } catch (IOException e) {
                System.out.println("ERROR");
                leido = false;
            }

        } while (!leido);
        obj.asignar(cp, p);
        System.out.println(" ");
        System.out.println("LA CANTIDAD DE PELOTAS COMPRADAS ES DE: " + cp);
        System.out.println("EL DESCUENTO ES DE: " + obj.calcularD(p));
        System.out.println("EL PRECIO TOTAL A PAGAR: " + obj.calcularP(p, cp));
    }
}
