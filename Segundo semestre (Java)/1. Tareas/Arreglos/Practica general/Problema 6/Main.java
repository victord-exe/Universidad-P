import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Inverso obj = new Inverso();
        boolean leido = true;

        double normal[] = new double[100];
        double inverso[] = new double[normal.length];
        int i;

        JOptionPane.showMessageDialog(null,
                "                    ¡Hola!" +
                        "\nAhora empieza el programa",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);

        for (i = 0; i < normal.length; i++) {
            do {
                try {
                    normal[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Ingrese un dato"));
                    leido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                } catch (IndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, er, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } while (!leido);
        }

        obj.setNormal(normal);

        // for (i = 0; i<normal.length; i++){
        inverso = obj.invertir(inverso);
        // }

        JOptionPane.showMessageDialog(null,
                "Por favor, espere)",
                "Procesando datos",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Vector original: " + Arrays.toString(obj.getNormal()) +
                        "\nVector invertido: " + Arrays.toString(inverso),
                "Resultados",
                JOptionPane.INFORMATION_MESSAGE);

    }
}