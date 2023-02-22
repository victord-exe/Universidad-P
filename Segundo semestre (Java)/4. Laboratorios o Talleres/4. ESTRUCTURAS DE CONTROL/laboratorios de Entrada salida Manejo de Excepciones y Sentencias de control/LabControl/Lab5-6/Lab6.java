import java.io.*;
import javax.swing.JOptionPane;

public class Lab6 {
    public static void main(String[] args) throws IOException {
        Cuadrado obj = new Cuadrado();
        double num = 0;
        int i;
        double cuadra = 0;
        String salida = "";

        for (i = 1; i <= 4 ; i++) {     

            num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero distinto de cero: "));

            obj.setNum(num);
            cuadra = obj.calcularC();

            if (cuadra != 0)
                salida = salida + "\n " + cuadra;
        }JOptionPane.showMessageDialog(null, "NUMERO AL CUADRADO" + "\n\n\t\t" +
                salida, "CUADRADO", JOptionPane.INFORMATION_MESSAGE);
    }
}
