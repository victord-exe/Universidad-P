import java.io.*;

public class Mainproblema12 {
    public static void main (String x1[]){
        BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
        Problema12 obj= new Problema12();
    
        int num, numero=0, sum=0, x, k;
    try{
        System.out.println("Ingresar un número para sumar desde 1 hasta el numero leído.");
        num=Integer.parseInt(leer.readLine());
    obj.setN(num);
    for(x=0;x<=obj.getN();x++){ 
    for (k=0; k<=numero; k++){ 
        sum=sum+num; 
        num=num-1;
    }
    System.out.println(x);
    }
    System.out.println("El numero ingresado es: "+obj.getN());
    System.out.println("El total es: "+sum);
    }
    catch (IOException e){
        System.out.println("Error"+e);
    }
    catch (NumberFormatException e){
    System.out.println("Error"+e);
    } 
   }
}