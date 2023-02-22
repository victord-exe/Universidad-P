import java.io.*;
public class Cadena {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nom;
        try{
            System.out.println("Como te llamas");
            nom = br.readLine();
            System.out.println("Me llamo " + nom);
            } catch(IOException e) {
                System.out.println("ERROR " + e);
            }
    }
}
