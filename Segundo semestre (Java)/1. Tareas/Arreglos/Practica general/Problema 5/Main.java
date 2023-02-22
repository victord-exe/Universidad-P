import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Problema5 obj = new Problema5();
        boolean leido = true;

        double arr[] = new double[30];
        int i;
        int nCeros = 0, nNega = 0, nPosi = 0;
        double totNega = 0, totPosi = 0;

        JOptionPane.showMessageDialog(null,
                "                    ¡Hola!" +
                        "\nAhora empieza el programa",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);

        for (i = 0; i < arr.length; i++) {
            do {
                try {
                    arr[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Ingrese un dato"));
                            leido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                } catch (IndexOutOfBoundsException er){
                    JOptionPane.showMessageDialog(null, er, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } while (!leido);
        }

        obj.setArr(arr);

        nCeros = obj.ContarCeros(nCeros);
        nNega = obj.ContarN(nNega);
        nPosi = obj.ContarPosi(nPosi);
        totNega = obj.AcumularNega(totNega);
        totPosi = obj.AcumularPosi(totPosi);

        JOptionPane.showMessageDialog(null,
                "Por favor, espere)",
                "Procesando datos",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Cantidad de digitos negativos: " + nNega +
                        "\nCantidad de ceros: " + nCeros +
                        "\nCantidad de digitos positivos: " + nPosi +
                        "\nSuma de los numeros negativos: " + totNega +
                        "\nSuma de los numeros positivos: " + totPosi,
                "Resultados",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
