import java.io.*;

public class Enunciado11 {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Funcion obj = new Funcion();

        int i;
        double x = 0;
        double y = 0;
        double var1 = 1;
        double var2 = 1;
        boolean leido = true;
        char resp = 'S';

        while (resp == 'S') {
            do {
                try {
                    System.out.println("Ingrese el valor de 'x'");

                    x = Double.parseDouble(br.readLine());

                    while (x < 0) {
                        System.out.println("el valor de 'x' no puede ser negativo, ingrese nuevamente");
                        x = Double.parseDouble(br.readLine());

                    }

                    leido = true;

                } catch (IOException e) {
                    System.out.println("ERROR: " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR: " + er);
                    leido = false;
                }
            } while (!leido);

            do {
                try {
                    System.out.println("Ingrese el valor de 'y'");
                    y = Double.parseDouble(br.readLine());

                    while (y < 0) {
                        System.out.println("el valor de 'y' no puede ser negativo, ingrese nuevamente");
                        y = Double.parseDouble(br.readLine());

                    }

                    leido = true;

                } catch (IOException e) {
                    System.out.println("ERROR: " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR: " + er);
                    leido = false;
                } }
       while(!leido);
            for (i = 1; i <= x; i = i++) {

                var1 = x * i;

            }
            for (i = 1; i <= y; i = i++) {

                var2 = y * i;

            }
            obj.setX(var1);
            obj.setY(var2);

            System.out.println("La respuesta es: " + obj.calcularS());
    
            try {
                System.out.println("Desea volver a utilizar la funcion?");
                System.out.println("Ingrese 'S' para si y 'N' para no");

                resp = (char) br.read();
                br.skip(2);
            } catch (IOException e) {
                System.out.println("ERROR" + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR" + er);
            }

            }
    }
    }
