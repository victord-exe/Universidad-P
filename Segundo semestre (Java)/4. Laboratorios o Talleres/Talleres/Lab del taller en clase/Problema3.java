/*Realice un programa que sume dos vectores de tipo double de n dimensiones. 
Verifique que el espacio nunca será mayor que 50. Para ello deberás pedir la 
dimensión del arreglo antes de pedir los datos y comprobarlo.*/

/*   ADOO     */

/*  Suma   */

/*  -ar1[]   */
/*  -ar2[]   */
/*  -arfin[] */
/*  - num    */

/* +setters()
 * +sumar()
 * +traer()
 */

 import java.io.*;
/* 
 *                 --------------------------- class --------------------------
*/
class Suma {
    private double ar1[];   // arreglo1: atributo de la clase
    private double ar2[];   // arreglo2
    private double arfin[]; // arreglo final
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /* Constructor: crea el espacio para los arreglos. */
    public Suma(int n) { 
        this.ar1 = new double[n];
        this.ar2 = new double[n];
        this.arfin = new double[n];
    }
    
    /*        ------ Cargar ambos arreglos de la clase ------    */
    /*       ------ (Con el arreglo que viene del main) ------   */

    public void setAr1(double[] ar1) {          // Array 1
        this.ar1 = ar1;
    }

    public void setAr2(double[] ar2) {          // Array 2
        this.ar2 = ar2;
    }


/*              -------- Método para sumar los dos arreglos --------   */
    public void Sumar() {
        int f;
        for (f = 0; f < ar1.length; f++) {
            arfin[f] = ar1[f] + ar2[f];
        }
    }

    public double[] traer() {
        return arfin;
    }
}

/*                                                                                 
 *                  ---------------------------------  MAIN  --------------------------------
 */
public class Problema3 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean leido = true;
        int i = 0, n = 0;

        /*              -------- Pedir el tamaño de los arreglos al usuario --------           */
        do {
            try {

                System.out.println("Digite el tamano de los arreglos: ");
                n = Integer.parseInt(br.readLine());
                leido = true;

                if (n <= 0) {
                    System.out.println("El tamano de los arreglos no puede ser cero ni negativo");
                    System.out.println("Introduzca otro numero");
                    leido = false;

                } else if (n > 50) {
                    System.out.println("Los arreglos no pueden tener mas de 50 elementos");
                    System.out.println("Introduzca otro numero");
                    leido = false;
                }

            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }
        } while (!leido);


        /*     -------- Crear arreglos en el main y en la clase --------    */
        double ar1[] = new double[n];
        double ar2[] = new double[n];
        double arfin[] = new double[n];
        Suma obj = new Suma(n);


        /*             -------- Cargar primer arreglo --------                */
        System.out.println("A continuación: Cargaremos el primer arreglo.");
        for (i = 0; i < ar1.length; i++) {
            do {
                try {
                    System.out.println("Array1 [" + (i + 1) + "] = ");
                    ar1[i] = Double.parseDouble(br.readLine()); // Cargar el arreglo
                } catch (IOException e) {
                    System.out.println("ERROR: " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR: " + er);
                    leido = false;

                }
            } while (!leido);
        }


        /*        --------------- Cargar segundo arreglo ---------------                */
        System.out.println("Ahora, Cargaremos el segundo arreglo.");
        for (i = 0; i < ar2.length; i++) {
            do {
                try {

                    System.out.println("Array2 [" + (i + 1) + "] = ");
                    ar2[i] = Double.parseDouble(br.readLine()); // Cargar el arreglo

                } catch (IOException e) {
                    System.out.println("ERROR: " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR: " + er);
                    leido = false;

                }
            } while (!leido);
        }


        /*         --------------- Setear ambos arreglos ---------------                */
        obj.setAr1(ar1); 
        obj.setAr2(ar2);


        /*        --------------- Imprimir ambos arreglos ---------------                */
        System.out.println("\n\nPrimer Arreglo");
        for (i = 0; i < ar1.length; i++) {
            System.out.println(" Array1 [" + (i + 1) + "] = " + ar1[i]);
        }

        System.out.println("\n\nSegundo Arreglo");

        for (i = 0; i < ar2.length; i++) {
            System.out.println(" Array2 [" + (i + 1) + "] = " + ar2[i]);
        }


        /*        --------------- Calcular y traer suma ---------------                */
        obj.Sumar();
        arfin = obj.traer();


        /*        --------------- Imprimir arreglo final ---------------                */
        System.out.println("\n\nSuma de ambos arreglos");
        for (i = 0; i < arfin.length; i++) {
            System.out.println("Final array [" + (i + 1) + "] = " + arfin[i]);
        }
    }
}
