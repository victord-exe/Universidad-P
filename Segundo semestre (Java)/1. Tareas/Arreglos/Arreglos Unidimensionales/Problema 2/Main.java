import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Temperatura obj = new Temperatura();
        boolean leido = true;
        int i;
        double top = 0, lower = 0;
        double celcius[] = new double[50];
        double f[] = new double[celcius.length];

        for (i = 0; i < celcius.length; i++) {
            do {
                try {
                    celcius[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Ingrese la temperatura " + (i + 1)));
                    leido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                } catch (IndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, er, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                }

            } while (!leido);
        }

        obj.setCelcius(celcius);
        f = obj.Transformar(f);
        top = obj.ObtenerAlta(f, top);
        lower = obj.ObtenerBaja(f, lower);

        JOptionPane.showMessageDialog(null, "Presione OK para convertir", "PROCESANDO",
                JOptionPane.INFORMATION_MESSAGE);
        for (i = 0; i < f.length; i++) {
            JOptionPane.showMessageDialog(null,
                    "Temperatura no. " + (i + 1) + ": " + f[i], "Resultados", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,
                "Temperatura más alta: " + top,
                "Top",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Temperatura más baja: " + lower,
                "Top",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
