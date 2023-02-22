import java.io.*;
class Ecuacion {
private int x;
public void asignar ( int x1) {
x = x1;}
public double calcular () {
return x + Math.pow(x,x) -35; }
public int traerX() {
return x;}
}
public class LabA {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader (new
InputStreamReader(System.in));
Ecuacion obj = new Ecuacion();
int x;
System.out.println ("Introduzca el valor de x como entero");
x = Integer.parseInt( br.readLine() );
obj.asignar(x);
System.out.println (" x="+ obj.calcular( ) ) ; }}