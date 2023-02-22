import javax.swing.JOptionPane;

public class Problema4 {

    public static void main(String args[]) {

        Cuadrado obj = new Cuadrado();

        int array[] = new int[15];
        double eleva[] = new double[array.length];

        int x;

        boolean leido = true;

        JOptionPane.showMessageDialog(null, "Algoritmo: \nElevar al cuadrado",
                "", JOptionPane.DEFAULT_OPTION);

        for (x = 0; x < array.length; x++) {
            do {
                try {
                    array[x] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de: " + (x + 1),
                            "Arreglo", JOptionPane.INFORMATION_MESSAGE));
                    leido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error " + (e), "", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                } catch (IndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Error " + (er), "", JOptionPane.ERROR_MESSAGE);
                }
            } while (!leido);
        }
        obj.setArray(array);
        obj.calcularEleva(eleva);

        for (x = 0; x < eleva.length; x++)
            JOptionPane.showMessageDialog(null, array[x] + " elevado al cuadrado es " + eleva[x],
                    "Numero " + (x + 1) + "", JOptionPane.INFORMATION_MESSAGE);
    }
}