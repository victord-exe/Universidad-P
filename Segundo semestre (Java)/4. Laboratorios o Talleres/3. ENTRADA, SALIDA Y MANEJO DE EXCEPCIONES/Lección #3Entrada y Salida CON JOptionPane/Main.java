import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Polinomio obj = new Polinomio();

        int x = 0;
        boolean leido = true;
        do {
            try {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor entero para X"));
                leido = true;
            } catch (NumberFormatException e) {
                leido = false;
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        } while (!leido);
        obj.asignar(x);
        JOptionPane.showMessageDialog(null, "El resultado del polinomio 2x3 + 5x-3 es : " + obj.calcularPolinomio(x));
    }
}
