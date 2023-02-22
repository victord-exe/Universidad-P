import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Diferente obj = new Diferente();

        int i, j;
        double mayor = 0, a[], b[];
        boolean leido = true;

        a = new double[5];
        b = new double[a.length];

        JOptionPane.showMessageDialog(null,
                "A continuación: introducirá valores :)",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Todos los valores que introduzca, deberán ser diferentes" +
                        "\nDe lo contrario, tendrá un error",
                "       OJO",
                JOptionPane.WARNING_MESSAGE);

        for (i = 0; i < a.length; i++) {
            do {
                try {
                    a[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Escriba el primer valor"));
                    leido = true;
                    for (j = 0; j < b.length; j++) {
                        if (b[j] == a[i]) {
                            JOptionPane.showMessageDialog(null, "ERROR, ya introdujo este dato", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                            leido = false;
                            b[i] = 0;
                        }
                    }
                    b[i] = a[i];
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } while (!leido);
        }

        JOptionPane.showMessageDialog(null, obj.EncontrarM(mayor), "Resultados", JOptionPane.DEFAULT_OPTION);

    }
}