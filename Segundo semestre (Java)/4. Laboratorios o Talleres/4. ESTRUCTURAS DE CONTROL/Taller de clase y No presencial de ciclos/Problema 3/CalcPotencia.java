import java.io.*;

public class CalcPotencia {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Calculo obj = new Calculo();
    double x;
    int n;
    boolean cero = true;
    try {
      do {
        System.out.print("\nPrograma para calcular X elevado a la n\nIngrese X: ");
        x = Double.parseDouble(br.readLine());
        cero = false;
        if (x == 0 || x == 0.0) {
          System.out.println("No puede ingresar 0. Intente de nuevo.");
          cero = true;
        }
      } while (cero == true);

      System.out.print("Ingrese n: ");
      n = Integer.parseInt(br.readLine());

      obj.setValores(x, n);

      System.out.println("El resultado de " + x + " elevado a la " + n + " es: " + obj.calculoPotencia());
    } catch (IOException er) {
      System.out.println("error:" + er);
    } catch (NumberFormatException nfe) {
      System.out.println("error:" + nfe);
    }
  }
}
