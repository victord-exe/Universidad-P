package Problema2;
import java.io.*;
public class MainPolinomio {

    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Polinomio obj = new Polinomio();

    int x;

    System.out.println("Ingrese un valor entero para X : ");
    x=Integer.parseInt(br.readLine());
    obj.asignar(x);
    
    System.out.println("El valor de X es: " +x);
    System.out.println("El resultado del polinomio 2x3 + 5x-3 es : " + obj.calcularPolinomio(x));

    }
}
