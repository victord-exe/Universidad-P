import java.io.*;

public class Enunciado4 {

    public static void main(String arg[]) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Nomina obj = new Nomina();

        int cantP = 0, x;
        double b = 0, salario = 0, mayorS = 0, tot = 0;
        String id = "";
        String mayorId = "";
        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese la cantidad de profesores"); // Dato para el for
                cantP = Integer.parseInt(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("Error" + e);

            } catch (NumberFormatException er) {
                System.out.println("Error" + er);
                leido = false;
            }
        } while (!leido);

        for (x = 1; x <= cantP; x++) {
            do {
                try {
                    System.out.println("Digite la cedula del profesor " + x);
                    id = br.readLine();
                    leido = true;

                } catch (IOException e) {
                    System.out.println("Error" + e);

                } catch (NumberFormatException er) {
                    System.out.println("Error" + er);
                    leido = false;
                }
            } while (!leido);

            do {
                try {
                    System.out.println("Digite el salario del profesor " + x);
                    salario = Double.parseDouble(br.readLine());
                    leido = true;
                } catch (IOException e) {
                    System.out.println("Error" + e);

                } catch (NumberFormatException er) {
                    System.out.println("Error" + er);
                    leido = false;
                }
            } while (!leido);

            obj.setSal(salario);

            tot = tot + salario;

            b = obj.calcularProme(tot, cantP);

            if (salario > mayorS) {
                mayorS = salario;
                mayorId = id;
            }

            System.out.println("El total de la nomina es: " + tot);
            System.out.println("El promedio de los salarios es " + b);
            System.out.println("Empleado con mayor salario: " + mayorId + " " + mayorS);
        }
    }
}
