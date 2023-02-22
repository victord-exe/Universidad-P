import java.io.*;
import java.util.Arrays;

public class Problema7 {
    public static void main(String args[]) {

        Diferencia obj = new Diferencia();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m[] = new int[10];
        int n[] = new int[m.length];

        int x;
        String mensaje = "";
        boolean leido = true;

        do {
            for (x = 0; x < m.length; x++)
                try {
                    System.out.println("Digite el elemento #" + (x + 1) + " del arreglo m");
                    m[x] = Integer.parseInt(br.readLine());
                    leido = true;
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR " + er);
                    leido = false;
                } catch (IndexOutOfBoundsException err) {
                    System.out.println("ERROR " + err);
                    leido = false;
                }

        } while (!leido);

        obj.setM(m);

        do {
            for (x = 0; x < n.length; x++)
                try {
                    System.out.println("Digite el elemento #" + (x + 1) + " del arreglo n");
                    n[x] = Integer.parseInt(br.readLine());
                    leido = true;
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR " + er);
                    leido = false;
                } catch (IndexOutOfBoundsException err) {
                    System.out.println("ERROR " + err);
                    leido = false;
                }

        } while (!leido);

        obj.setN(n);

        System.out.println("Arreglo m: " + Arrays.toString(m) + "\n" + "Arreglo n: " + Arrays.toString(n));

        for (x = 0; x < m.length; x++) {
            mensaje = obj.diferenciar(x);
            System.out.println("En la posicion " + (x + 1) + " de los vectores, los numeros son " + mensaje);
        }
    }
}
