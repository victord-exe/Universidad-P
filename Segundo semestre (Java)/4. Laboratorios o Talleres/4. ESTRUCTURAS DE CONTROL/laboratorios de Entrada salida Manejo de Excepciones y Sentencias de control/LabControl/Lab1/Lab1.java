import java.io.*;

public class Lab1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Compra obj = new Compra();

        int cp = 0;
        double p = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese la cantidad de pelotas ");
                cp = Integer.parseInt(br.readLine());
                leido = true;
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
            } catch (IOException e) {
                System.out.println("ERROR " + e);
                leido = false;
            }

        } while (!leido);

        do {
            try {
                System.out.println("Ingrese el precio de las pelotas: ");
                p = Double.parseDouble(br.readLine());
                leido = true;
                while (p < 0) {
                    System.out.println("ERROR: No puede ingresar numeros negativos");
                    p = Double.parseDouble(br.readLine());
                }
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
            } catch (IOException e) {
                System.out.println("ERROR " + e);
                leido = false;
            }

        } while (!leido);

        obj.setCant(cp);
        obj.setPrecio(p);

        System.out.println("\nCantidad de pelotas: " + cp);
        System.out.println("Descuento: " + obj.calcularD(p));
        System.out.println("Precio total: " + obj.calcularP(p, cp));
    }

}
