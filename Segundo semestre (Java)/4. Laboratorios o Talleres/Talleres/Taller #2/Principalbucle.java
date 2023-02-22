import java.io.*;

public class Principalbucle {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Ecuacion obj = new Ecuacion();

        int num = 0;
        int sum = 0;
        int x1 = 0;
        boolean leido = true;

        for (x1 = 1; x1 <= 5; x1++) {
            do {
                try {
                    System.out.println("Introduzca un numero positivo");
                    num = Integer.parseInt(br.readLine());
                    leido = true;   
                    while (num < 0) 
                    {
                        System.out.println("No se admiten numeros negativos");
                        num = Integer.parseInt(br.readLine());
                    }
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                } catch (NumberFormatException er) {
                    System.out.println("ERROR " + er);
                    leido = false;
                }  
            } while (!leido);
        }
        System.out.println("Sumatoria: " + sum);
    }
}
