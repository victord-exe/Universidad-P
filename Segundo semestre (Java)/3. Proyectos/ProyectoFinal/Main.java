import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ar[] = new int[4];
        String dato = "";
        boolean leido = true;
        
        do {
            try {

                System.out.println("Introduzca el dato: ");
                dato = br.readLine();
                leido = true;
            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR: " + er);
                leido = false;
            }
        } while (!leido);

        Cifrado obj = new Cifrado();

        obj.setDato(dato);
        obj.Cifrar();
        System.out.println("\nEl dato cifrado es: " + obj.getDatoC());
        
    }
}
