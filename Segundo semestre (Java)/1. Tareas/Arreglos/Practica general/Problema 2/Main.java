import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sumatoria obj = new Sumatoria();

        double[] a = new double[5];
        double[] b = new double[a.length];
        double[] c = new double[b.length];

        int i;
        boolean leido = true;

        for (i = 0; i < c.length; i++) {
            do {
                try {
                    a[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Introduzca un valor para el arreglo a en la posición [" + (i + 1) + "]: "));
                    leido = true;
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null, er, "ERROR", JOptionPane.WARNING_MESSAGE);
                    leido = false;
                }

            } while (!leido);
        }

        for (i = 0; i < c.length; i++) {
            do {
                try {
                    b[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Introduzca un valor para el arreglo b en la posición [" + (i + 1) + "]: "));
                    leido = true;
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null, er, "ERROR", JOptionPane.WARNING_MESSAGE);
                    leido = false;
                }

            } while (!leido);
        }

        obj.setA(a);
        obj.setB(b);

        c = obj.Sumar(c);

        JOptionPane.showMessageDialog(null, "Arreglo A: " + Arrays.toString(a) + "\nArreglo B: " + Arrays.toString(b),
                "ARREGLOS", JOptionPane.INFORMATION_MESSAGE);

        for (i = 0; i < c.length; i++) {
            JOptionPane.showMessageDialog(null,
                    "Suma del arreglo: " + a[i] + " + " + b[i] + " = " + c[i],
                    "SUMA", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
