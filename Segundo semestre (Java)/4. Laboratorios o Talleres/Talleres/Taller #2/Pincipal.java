import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pincipal {
    public static void main(String[] args) {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Ecuacion obj = new Ecuacion();
    double x;
    try{
        System.out.println("Digite un valor real");
        x = Double.parseDouble(br.readLine());
        obj.setX(x);
        } catch(IOException e) {
            System.out.println("ERROR " + e);
        } catch(NumberFormatException er){
            System.out.println("ERROR " + er);
        }
        
    }
}
