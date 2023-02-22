
/* VICTOR RODRÍGUEZ 20-70-7414 */
import java.io.*;

class Farah {
    private int far;

    void asignar(int f) {
        far = f;
    }

    void calcularC(int[] c, int d) {
        c[d] = (far - 32) * 5 / 9;
    }

    String visualizar(int[] cel) {

        String salida = "\n";
        int d, dia = 8;
        for (d = 0; d < cel.length; d++)
            if (cel[d] >= 20 && cel[d] <= 28)
                salida = salida + (dia + d) + " de Junio " + cel[d] + " grados\n";
            else if (dia == 9 && d == cel.length)
                salida = "NO HAY TEMPERATURAS EN EL RANGO SOLICITADO";
        return salida;
    }

    int traer() {
        return far;
    }

}

class SemestralDIIA {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Farah obj = new Farah();
        int d, f = 8, fara;
        boolean leido = true;
        int celsius[] = new int[23];
        System.out.println("*******VIAJEROS A NEW YORK *****\n");
        for (d = 0; d < celsius.length; d++) {
            do {
                try {
                    leido = true;
                    System.out.println("Ingrese LA TEMPERATURA EN FARANHEIT");
                    fara = Integer.parseInt(br.readLine());
                    obj.asignar(fara);
                    obj.calcularC(celsius, d);
                } catch (NumberFormatException e) {
                    leido = false;
                    System.out.println("\nError de Entrada o conversion de datos\n" + e);
                } catch (IOException e) {
                    leido = false;
                    System.out.println("\nError \n" + e);
                }
            } while (!leido);
        }

        System.out.println("\n\nTEMPERATURAS EN CELSIUS \n DIA TEMPERATURA");
        for (d = 0; d < celsius.length; d++) {
            System.out.println("\t" + (f) + "\t\t\t\t" + celsius[d]);
            f++;
        }
        System.out.println(obj.visualizar(celsius));
    }
}
