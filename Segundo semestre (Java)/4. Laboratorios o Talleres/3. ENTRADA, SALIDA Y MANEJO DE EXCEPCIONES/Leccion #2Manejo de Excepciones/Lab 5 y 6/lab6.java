import java.io.*;

import javax.swing.JOptionPane;

public class lab6 {
    public static void main(String[] args) throws IOException {
        Cuadrados obj = new Cuadrados();
        int num = 0, i;
        double cuadra;
        String salida = " ";

        for (i = 1; i <= 4 ; i++) {     

            num = Integer.parseInt(JOptionPane.showInputDialog("Lea numero enteros distintos a cero"));

            obj.asignar(num);
            cuadra = obj.calcularC();

            if (cuadra != 0)
                salida = salida + "\n " + cuadra;
        }JOptionPane.showMessageDialog(null, "NUMERO AL CUADRADO" + "\n\n\t\t" +
                salida, "CUADRADO", JOptionPane.INFORMATION_MESSAGE);
    }
}
