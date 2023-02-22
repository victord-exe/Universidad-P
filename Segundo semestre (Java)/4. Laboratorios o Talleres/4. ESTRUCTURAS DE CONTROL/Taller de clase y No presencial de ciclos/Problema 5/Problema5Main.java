import java.io.*;

public class Problema5Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Problema5 obj = new Problema5();

        int a = 0, b = 0, x=0;
        int prod = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese el primer número entero: ");
                a = Integer.parseInt(br.readLine());
                leido = true;
                while (a <= 0) {
                    System.out.println("No se aceptan numeros negativos");
                    a = Integer.parseInt(br.readLine());
                }
                obj.setNum1(a);
            } catch (IOException e) {
                System.out.println("Error" + e);
            } catch (NumberFormatException er) {
                System.out.println("Error" + er);
                leido = false;
            }
        } while (!leido);

        do {
            try {
                System.out.println("Ingrese el segundo número entero: ");
                b = Integer.parseInt(br.readLine());
                leido = true;
                while (b <= 0) {
                    System.out.println("No se aceptan numeros negativos");
                    b = Integer.parseInt(br.readLine());
                }
                obj.setNum2(b);
            } catch (IOException e) {
                System.out.println("Error" + e);
            } catch (NumberFormatException er) {
                System.out.println("Error" + er);
                leido = false;
            }

        } while (!leido);
        System.out.println("El producto de ambos numeros es: " + obj.calcularProducto(x, prod, a, b));
    }
}