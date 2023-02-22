import java.io.*;

public class Parcial1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Finca obj = new Finca();
        boolean leido = true;
        double precio = 0;
        double total = 0;

        do {
            try {
                System.out.println("Introduzca el precio de la finca: ");
                precio = Double.parseDouble(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR:" + er);
                leido = false;
            }
        } while (!leido);

        obj.setPrecio(precio);

        System.out.println("La cantidad a pagar individualmente es de: " + obj.CalcularT(total));
    }
}