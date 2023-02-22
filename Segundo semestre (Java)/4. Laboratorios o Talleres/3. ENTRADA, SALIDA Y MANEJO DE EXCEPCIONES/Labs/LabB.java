 import java.io.*;
class Promedio {
private int num1,num2,num3;
public void asignar ( int n1, int n2, int n3) {
num1 = n1; num2= n2; num3 =n3; }
public int calcular () {
return (num1 + num2+num3) / 3; }
public int traer() {
return num1;}
public int traer2() {
return num2; }
public int traer3 () {
return num3;}
} 

public class LabB {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader (new
InputStreamReader(System.in));
Promedio obj = new Promedio();
String input;
int a , b , c;
System.out.println ("Introduzca el primer entero");
input = br.readLine();
a = Integer.parseInt(input);
System.out.println ("Introduzca el segundo entero");
input = br.readLine();
b = Integer.parseInt(input);
System.out.println ("Introduzca tercer entero");
input = br.readLine();
c = Integer.parseInt(input);
obj.asignar(a , b , c);
System.out.println (" PROMEDIO:"+ obj.calcular( ) ) ; }}


