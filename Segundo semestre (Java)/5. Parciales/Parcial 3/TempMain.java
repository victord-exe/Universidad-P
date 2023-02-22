    /* ADOO */

    /* Temp */

    /* -array[] */

    /* +setArray()
     * +getArray()
     * CalcularT()
     */

import java.io.*;
class Temp {

    private double array[];

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public String calcularT(int i) {
        String salida = "";
        if (array[i] >= 38) {
            salida = "la temperatura de la hora 0" + i + ":00 tuvo altas temperaturas: " + array[i] + "°\n";
        } else {
            salida = "la temperatura de la hora 0" + i + ":00 tuvo bajas temperaturas: " + array[i] + "°\n";
        }
        return salida;
    }
}

public class TempMain {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Temp obj = new Temp();
        double array[] = new double[24]; //
        double temp = 0;
        boolean leido = true;
        int c, i;

        for (c = 0; c < array.length; c++) {
            do {
                try {
                    leido = true;
                    System.out.println("Introduzca la temperatura de la hora 0" + c + ":00");
                    temp = Double.parseDouble(br.readLine());
                    array[c] = temp;
                } catch (IOException e) {
                    System.out.println(e);
                    leido = false;
                } catch (NumberFormatException er) {
                    System.out.println(er);
                    leido = false;
                } catch (ArrayIndexOutOfBoundsException ar) {
                    System.out.println(ar);
                    leido = false;
                }
            } while (!leido);
        }

        obj.setArray(array);

        for (i = 0; i < array.length; i++) {
            System.out.println(obj.calcularT(i));
        }

    }
}