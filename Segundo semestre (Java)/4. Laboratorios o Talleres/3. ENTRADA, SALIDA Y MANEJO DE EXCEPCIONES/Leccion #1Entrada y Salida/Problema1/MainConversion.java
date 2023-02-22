package Problema1;
import java.io.*;
public class MainConversion {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Conversion obj = new Conversion();

        int decimal;
        System.out.println("Ingrese un numero en decimal");
        decimal=Integer.parseInt(br.readLine());
        obj.asignar(decimal);

        System.out.println("La conversion de decimal  " + decimal + "  a Octal es " +obj.convertirOctal());
        System.out.println("La conversion de Decimal  " + decimal +" a Hexadecimal es: " + obj.convertirHexadecimal());
        
    }
    
}
