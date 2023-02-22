import java.io.*;

public class Lab5 {
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Cuadrados obj = new Cuadrados();

        int num, i = 1;
        double cuad=0, tot = 0;
        
        while (i <= 5) {
            System.out.println("Lea un numero entero");
            num = Integer.parseInt(leer.readLine());
            obj.asignar(num);
            cuad = obj.calcularC();
            tot = obj.calcularS(tot, cuad);
            i++;
            System.out.println("CUADRADO = " + cuad);
        }
        System.out.println("SUMATORIA DE LA LISTA = " + tot);
    }
}
