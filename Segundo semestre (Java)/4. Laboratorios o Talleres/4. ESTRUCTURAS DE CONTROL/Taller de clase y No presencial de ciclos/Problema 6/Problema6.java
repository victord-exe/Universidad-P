import java.io.*;

public class Problema6 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cuad_imp_consec obj = new Cuad_imp_consec();

        int y = 0;
        double z = 0;
        boolean leido = true;

        do {

            try {

                System.out.println("Ingrese el valor de la base");
                y = Integer.parseInt(br.readLine());
                leido = true;

            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }

        } while (!leido);

        obj.setY(y);
        System.out.println("Resultado: " + obj.BuscarImpares(z));

    }

}
