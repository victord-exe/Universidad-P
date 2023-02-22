import java.io.*;

public class Lab_5 {
    
    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Finca obj = new Finca();
        Double precio;
        
        try{
        System.out.println("Introduzca el precio de la finca");
        precio = Double.parseDouble(br.readLine());

        obj.setPrecio(precio);

        System.out.println("Cada persona debe pagar " + obj.CalcularT());
        } catch (IOException e){
            System.out.println("ERROR " + e);
        } catch (NumberFormatException er){
            System.out.println("ERROR " + er);
        }
    }

}
