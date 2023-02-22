import java.io.*;

public class Problema9Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Problema9 obj = new Problema9();

        int n1=0, n2=0;
        int x=0;

        try {
            System.out.println("Ingrese el primer numero: ");
            n1 = Integer.parseInt(br.readLine());
            while (n1 <= 0) {
                System.out.println("No se aceptan números negativos, ingrese otro número: ");
            }
            obj.setNum1(n1);

        } catch (IOException e) {
            System.out.println("ERROR" + e);
        } catch (NumberFormatException er) {
            System.out.println("ERROR" + er);
        }
        try {
            System.out.println("Ingrese el segundo numero: ");
            n2 = Integer.parseInt(br.readLine());
            while (n2 <= 0) {
                System.out.println("No se aceptan números negativos, ingrese otro número: ");
            }
            obj.setNum2(n2);
        } catch (IOException e) {
            System.out.println("ERROR" + e);
        } catch (NumberFormatException er) {
            System.out.println("ERROR" + er);
        }
        System.out.println("Los números impares entre "+ n1 + " y " + n2 +" son:");
        System.out.println(obj.calcularImpar(x, n1, n2));
        }
        
 }
 
