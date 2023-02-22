import java.io.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Empresas obj = new Empresas();

        double ventas[][], promedios[];
        double ventasM = 0, media = 0, mayor = 0;
        boolean leido = true;
        int i, j;

        ventas = new double[7][6];
        promedios = new double[7];

        for (i = 0; i < 7; i++) {
            System.out.println("\n********ALMACEN " + (i + 1) + "*******");
            for (j = 0; j < 6; j++) {
                do {
                    try {
                        System.out.println("Ingrese las ventas para el mes " + (j + 1) + ": ");
                        System.out.println("Posicion del arreglo: [" + i + "][" + j + "]");
                        ventasM = Double.parseDouble(br.readLine());
                        leido = true;
                        obj.setVentasM(ventasM);
                        obj.Sumar(ventas, i, j);
                        promedios[i] += obj.getVentasM();

                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: " + e);
                        leido = false;
                    } catch (ArrayIndexOutOfBoundsException er) {
                        System.out.println("ERROR:" + er);
                        leido = false;
                    } catch (IOException err) {
                        System.out.println("ERROR: " + err);
                    }
                } while (!leido);
            }
        }

        promedios = obj.calcularPromedios(promedios);
        media = obj.calcularMedia(promedios, media);
        mayor = obj.calcularMayor(promedios, mayor);

        for (i = 0; i < promedios.length; i++) {
            System.out.println("\n********ALMACEN " + (i + 1) + "*******");
            for (j = 0; j < 6; j++) {
                System.out.println("Ventas en el mes " + (j + 1) + ": $" + ventas[i][j]);
            }

            System.out.println("\nPromedio de ventas: $" + promedios[i]);

        }
        System.out.println("\nMedia de los almacenes: $" + Math.round(media));

        System.out.println("\nAlmacenes por encima de la media: ");
        for(i = 0; i<promedios.length; i++){
            if (obj.VentasSuperiores(promedios, media, i)){
                System.out.println("Almacen " + (i+1) + " con: $" + Math.round(promedios[i]));
            }
        }

        System.out.println("\n\n**Almacen con mejores ventas en los últimos 6 meses**");
        for (i = 0; i<promedios.length; i++){
            if(promedios[i] == mayor){
                System.out.println(" ********  Almacen no. " + (i+1) + " con: $" + mayor + " *******");
            }
        }
        

    }
}
