import java.io.*;
public class Lab2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pagos obj = new Pagos();

        int tipo = 0, cantm = 0, cantl = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("TIPO DE ESTUDIANTE");
                System.out.println("Veterano = 1   Regular = 2");
                tipo = Integer.parseInt(br.readLine());
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
                System.out.println("Ingrese la cantidad de materias que desea matricular: ");
                cantm = Integer.parseInt(br.readLine());
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
                System.out.println("Ingrese la cantidad de materias con laboratorio: ");
                cantl = Integer.parseInt(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }
        } while (!leido);

        obj.setCantl(cantl);
        obj.setCantm(cantm);
        obj.setTipo(tipo);

        System.out.println("\nMonto total a pagar: " + obj.calcularP());

    }
}
