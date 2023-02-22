
import javax.swing.*;

class Vota {

    private int vot;

    public void asignar(int v) {
        vot = v;
    }

    public int calcular(int cuenta) {
        cuenta = cuenta + 1;
        return cuenta;
    }

    public int traer() {
        return vot;
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Icon iconV = new ImageIcon("votar.jfif");
        String[] choices = { "PRD", "CAMBIO DEMOCRATICO", "INDEPENDIENTE", "SALIR" };
        Vota obj = new Vota();
        int prd = 0;
        int cdem = 0;
        int indep = 0;
        int voto = 0;
        while (voto != 3) {
            voto = JOptionPane.showOptionDialog(
                    null // Determina el tipo de marco de la ventana que se centrara en la pantalla.
                    , "Cual es su Voto?" // Mensaje que aparece dentro de la ventanae
                    , "VOTACION PARA PRESIDENTE" // Tiulo del cuadro de dialogo
                    , JOptionPane.YES_NO_OPTION // Tipo de option a manejar (el nombre de la constante o el valor
                                                // numerico que expresa)
                    // ,0
                    , JOptionPane.PLAIN_MESSAGE // Tipo de mensaje, igual la constante o el valor numerico que expresa
                    , null // Icono si es NULL (Ninguno)
                    , choices // Diferentes opciones del boton.
                    , "" // Ninguno porque no usamos un marco particular sino el de por defecto
            );
            obj.asignar(voto);
            switch (obj.traer()) {
                case 0:
                    prd = obj.calcular(prd);
                    break;
                case 1:
                    cdem = obj.calcular(cdem);
                    break;
                case 2:
                    indep = obj.calcular(indep);
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "\n\n\n\n\n\nTOTAL DE VOTOS = " + (prd + cdem + indep)
                + "\nPRD = " + prd
                + "\nCD= " + cdem
                + "\nINDEPENDIENTE = " + indep, "\nTOTAL DE LA VOTACION", 1, iconV);

    }
}