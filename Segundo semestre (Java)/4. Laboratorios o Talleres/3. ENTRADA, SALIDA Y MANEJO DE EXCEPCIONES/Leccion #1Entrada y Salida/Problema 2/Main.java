import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Polinomio obj = new Polinomio();

        double x;

        System.out.println("Ingrese un numero");
        x = Double.parseDouble(br.readLine());
        obj.setX(x);

        System.out.println("X = " + x);
        System.out.println("Resultado = " + obj.CalcularP(x));
    }
}
