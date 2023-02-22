import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        Polinomio obj = new Polinomio();

        double x = 0;
        boolean leido = true;
        do {
            try {
                x = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
                leido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e);
                leido = false;
            }
        } while (!leido);
        obj.setX(x);
        JOptionPane.showMessageDialog(null, "Resultado: " + obj.CalcularP(x));
    }
}
