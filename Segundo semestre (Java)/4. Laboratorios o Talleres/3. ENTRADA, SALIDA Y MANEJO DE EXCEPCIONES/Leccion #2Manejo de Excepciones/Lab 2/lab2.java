import java.io.*;
public class lab2 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pagos obj = new Pagos();

        int tipo = 0, cantm = 0, cantl = 0;

        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese el tipo de estudiante que es: Veterano = 1   Regular = 2");
                tipo = Integer.parseInt(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR");
            } catch (NumberFormatException er) {
                System.out.println("ERROR");
                leido = false;
            }
        } while (!leido);

        do {
            try {
                System.out.println("Ingrese la cantidad de materias a matricular: ");
                cantm = Integer.parseInt(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR");
            } catch (NumberFormatException er) {
                System.out.println("ERROR");
                leido = false;
            }
        } while (!leido);

        do {
            try {
                System.out.println("Ingrese la cantidad de materias con laboratorio: ");
                cantl = Integer.parseInt(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR");
            } catch (NumberFormatException er) {
                System.out.println("ERROR");
                leido = false;
            }
        } while (!leido);

        obj.asignar(tipo, cantm, cantl);
        System.out.println(" ");
        System.out.println("EL COSTO DE MATRICULA A PAGRA ES: " + obj.calcularP());
    }
}
