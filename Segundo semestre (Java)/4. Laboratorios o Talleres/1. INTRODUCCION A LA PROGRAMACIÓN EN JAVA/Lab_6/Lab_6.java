
/*Taller de clase de Entrada y salida Manejo de try y catch*/
import java.io.*;
public class Lab_6 {
    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Finca obj = new Finca();
        Double precio;
        int x;
        boolean leido = true;
        
        System.out.println("Analisis del pago de 5 fincas diferentes");
        for(x=1;x<=5;x++){  

            do{

                try{

                    System.out.println("Introduzca el precio de la finca " + x);
                    precio = Double.parseDouble(br.readLine());
                    leido = true;

                    while (precio < 0){
                        System.out.println("El precio no puede ser ni cero, ni negativo");
                        System.out.println("Introduzca el precio de la finca " + x);
                        precio = Double.parseDouble(br.readLine());
                    }

                    obj.setPrecio(precio);
                    System.out.println("Cada persona debe pagar " + obj.CalcularT());

                } catch (IOException e){
                    System.out.println("ERROR " + e);
                } catch (NumberFormatException er){
                    System.out.println("ERROR " + er);
                    leido = false;
                } 
                
            } while(!leido);
        }
    }
}