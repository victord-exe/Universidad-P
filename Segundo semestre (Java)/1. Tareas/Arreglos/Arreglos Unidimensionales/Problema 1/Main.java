import javax.swing.JOptionPane;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        boolean leido = true;
        int num = 0;
        int tamaño = 0;
        int i;
        Arreglo obj = new Arreglo();

        do {
            try {
                tamaño = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantos multiplos desea conocer?"));
                leido = true;
                if (tamaño <=0){
                    JOptionPane.showMessageDialog(null, "No puede ingresar ceros ni numeros negativos", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                }
            } catch (NumberFormatException e) {
                leido = false;
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (!leido);

        obj.setTamaño(tamaño);

        int array[] = new int[obj.getTamaño()];

        do {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero "));
            } catch (NumberFormatException e) {
                leido = false;
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (!leido);

        obj.setNum(num);

        array = obj.Cargar(array);

        JOptionPane.showMessageDialog(null, Arrays.toString(array), "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}