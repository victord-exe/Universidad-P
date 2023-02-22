import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Multiplos obj = new Multiplos();

        boolean leido = true;
        double a[] = new double[5];
        double b[] = new double[a.length];
        double c[] = new double[b.length];

        int i;

        JOptionPane.showMessageDialog(null,
                "Empezaremos llenando el primer arreglo",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);
        for (i = 0; i < a.length; i++) {
            do {
                try {
                    a[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Introduzca un número: "));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                } catch (IndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, er, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } while (!leido);
        }

        JOptionPane.showMessageDialog(null,
                "Ahora, llenaremos el segundo arreglo",
                "Segundo Arreglo",
                JOptionPane.INFORMATION_MESSAGE);

        for (i = 0; i < b.length; i++) {
            do {
                try {
                    b[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Introduzca un número: "));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                } catch (IndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, er, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } while (!leido);
        }

        obj.setA(a);
        obj.setB(b);

        c = obj.Calcular(c);

        
        JOptionPane.showMessageDialog(null, "Arreglo: " + Arrays.toString(c), "Array final", JOptionPane.DEFAULT_OPTION);
        

    }
}
