import java.io.*;

public class Lab3 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Ecuacion obj = new Ecuacion();

        int x = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("Ingrese un valor para X : ");
                x = Integer.parseInt(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR");
            } catch (NumberFormatException er) {
                System.out.println("ERROR");
                leido = false;
            }
        } while (!leido);
        obj.asignar(x);
        System.out.println("Y= " + obj.calcularY());
    }
}
