import java.io.*;
public class Lab3 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Ecuacion obj = new Ecuacion();

        double x = 0;
        boolean leido = true;

        do {
            try {
                System.out.println("digite el valor de X : ");
                x = Double.parseDouble(br.readLine());
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }
        } while (!leido);
        
        obj.setX(x);
        
        System.out.println("Y= " + obj.calcularY());
    }
}
