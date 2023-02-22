import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Conversion obj = new Conversion();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int decimal = 0;

            System.out.println("Introduzca un numero para convertirlo a octal y hexadecimal");
            decimal = Integer.parseInt(br.readLine());
 
        obj.setDecimal(decimal);

        System.out.println("El numero decimal es:" + decimal);
        System.out.println("Convertido a octal: " + obj.CovnertirOctal());
        System.out.println("Convertido a hexadecimal: " + obj.ConvertirHex());

    }
}
