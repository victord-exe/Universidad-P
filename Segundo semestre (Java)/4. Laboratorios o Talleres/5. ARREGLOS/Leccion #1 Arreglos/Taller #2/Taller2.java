
/*ADOO
  
  Numeros

  -veca[]
  -n
  +asignarN()
  +asignarVeca()
  +buscar()
  +traerN()
  +traerVeca()
 */
import java.io.*;

class Numeros {
    private int veca[];
    private int n;

    public void asignarN(int num) {
        n = num;
    }

    public int TraerN() {
        return n;
    }

    public Numeros(int n) {
        veca = new int[n];
    }

    public void asignarVeca(int v[]) {
        veca = v;
    }

    int buscar() {
        int cuenta = 0;
        int f;
        for (f = 0; f < veca.length; f++) {
            if (n == veca[f])
                cuenta++;
        }
        return cuenta;
    }

    int[] traerVeca() {
        return veca;
    }
}

public class Lab {
    public static void main(String args[]) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean leido = true;
        int t = 0, i = 0, num = 0;

        do {
            try {
                leido = true;
                System.out.println("Ingrese el tamaño del arreglo: ");
                t = Integer.parseInt(br.readLine());

                if (t <= 0) {
                    System.out.println("El valor del arreglo no puede ser negativo, ingrese nuevamente");
                    leido = false;
                }

            }

            catch (IOException e) {
                System.out.println("ERROR" + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR" + er);
                leido = false;
            }

        } while (!leido);

        int veca[] = new int[t];
        Numeros obj = new Numeros(t);

        System.out.println("Ingrese los valores del arreglo: ");

        for (i = 0; i < veca.length; i++) {

            do {
                try {
                    leido = true;
                    veca[i] = Integer.parseInt(br.readLine());

                } catch (IOException e) {
                    System.out.println("ERROR" + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR" + er);
                    leido = false;
                }

            } while (!leido);
        }

        obj.asignarVeca(veca);

        do {
            try {
                leido = true;
                System.out.println("Deme el número a buscar en el arreglo: ");
                num = Integer.parseInt(br.readLine());

            } catch (IOException e) {
                System.out.println("ERROR" + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR" + er);
                leido = false;
            }

        } while (!leido);

        obj.asignarN(num);

        System.out.println("El valor " + obj.TraerN() + " Se encuentra " + obj.buscar() + " veces en el arreglo");

        veca = obj.traerVeca();

        for (i = 0; i < veca.length; i++) {
            System.out.println("veca[" + (i + 1) + "]= " + veca[i]);
        }
    }
}
