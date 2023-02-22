import javax.swing.JOptionPane;
import java.util.Arrays;

class Fecha {
    private int fecha[];

    public int[] getFecha() {
        return fecha;
    }

    public void setFecha(int[] fecha) {
        this.fecha = fecha;
    }

    public String convertirMes() {
        String mes = "";
        if (fecha[1] == 1) {
            mes = "Enero";
        } else if (fecha[1] == 2) {
            mes = "Febrero";
        } else if (fecha[1] == 3) {
            mes = "Marzo";
        } else if (fecha[1] == 4) {
            mes = "Abril";
        } else if (fecha[1] == 5) {
            mes = "Mayo";
        } else if (fecha[1] == 6) {
            mes = "Junio";
        } else if (fecha[1] == 7) {
            mes = "Julio";
        } else if (fecha[1] == 8) {
            mes = "Agosto";
        } else if (fecha[1] == 9) {
            mes = "Septiembre";
        } else if (fecha[1] == 10) {
            mes = "Octubre";
        } else if (fecha[1] == 11) {
            mes = "Noviembre";
        } else if (fecha[1] == 12) {
            mes = "Diciembre";
        }
        return mes;
    }
}

public class Problema3 {

    public static void main(String args[]) {

        Fecha obj = new Fecha();

        int array[] = new int[3];
        int i;
        String month;
        boolean leido = true;

        for (i = 0; i < array.length; i++) {

            do {

                try {

                    if (i == 0) {
                        array[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Digite el dia en formato numerico", "FECHA", JOptionPane.DEFAULT_OPTION));

                        while (array[i] < 1 || array[i] > 31) {
                            array[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Este dia no existe, digite el dia nuevamente ", "ERROR",
                                    JOptionPane.ERROR_MESSAGE));
                            leido = false;
                        }
                    }

                    else if (i == 1) {
                        array[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Digite el mes en formato numerico", "FECHA", JOptionPane.DEFAULT_OPTION));

                        while (array[i] < 1 || array[i] > 12) {
                            array[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Este mes no existe, digite el mes nuevamente ", "ERROR",
                                    JOptionPane.ERROR_MESSAGE));
                            leido = false;
                        }
                    }

                    else if (i == 2) {
                        array[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Digite el año en formato numerico", "FECHA", JOptionPane.DEFAULT_OPTION));

                        while (array[i] < 0) {
                            array[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "El algoritmo solo toma en cuenta los años despues de Cristo, ingrese el año nuevamente ",
                                    "ERROR", JOptionPane.ERROR_MESSAGE));
                            leido = false;
                        }
                    }

                    leido = true;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERROR " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;

                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "ERROR " + er, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;

                }
            } while (!leido);

        }

        obj.setFecha(array);

        month = obj.convertirMes();

        JOptionPane.showMessageDialog(null, "Su fecha en formato dd/mm/aa: " + Arrays.toString(array) +
                "\nSu fecha en formato de texto: " + array[0] + " " + month + " " + array[2], "FECHA",
                JOptionPane.DEFAULT_OPTION);

    }

}