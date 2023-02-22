import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        int arabica = 0; // cantidad de café arabica que quiere el user
        int robusta = 0; // cantidad de café robusta que quiere el user
        int n = 0;       // Controla el while del JOptionPane. Al final pregunta si quiere volver a procesar.
        String nombre = "";
        boolean leido = true;

        Gestion obj = new Gestion();
        Icono icon = new Icono();

        while (n == JOptionPane.YES_NO_OPTION) {
            byte option = 0;

            /* Primer do-try-catch para leer la opción del usuario: Arabica o Robusto */
            do {
                try {
                    option = Byte
                            .parseByte(JOptionPane
                                    .showInputDialog(null,
                                            " Que cafe desea:\n" + "\n 1. Cafe Arabica" + "\n 2. cafe Robusto"));
                    leido = true;
                    if (option == 1){
                        nombre = "Arabica";
                    } else{
                        nombre = "Robusta";
                    }

                } catch (NumberFormatException e) {
                    leido = false;
                    JOptionPane.showMessageDialog(null, "ERROR: " + e);
                }
            } while (!leido);

            

            /*
             * Para case 1, ingresa la cantidad del producto de café arabica
             * y comprueba que no tenga valores negativos
             */
            switch (option) {
                case 1:
                    do {
                        try {
                            arabica = Integer
                                    .parseInt(JOptionPane
                                            .showInputDialog(" Ingrese la cantidad del Producto Cafe Arabica:"));

                            if (arabica <= 0) {
                                JOptionPane.showMessageDialog(null, "No se aceptan valores negativos");
                                leido = false;
                            }
                        } catch (NumberFormatException e) {
                            leido = false;
                            JOptionPane.showMessageDialog(null, "ERROR: " + e);
                        }
                    } while (!leido);

                    break;

            /*
             * Para case 2, ingresa la cantidad del producto de cafe robusta
             * y comprueba si hay valores negativos
            */

                case 2:
                    do {
                        try {
                            robusta = Integer
                                    .parseInt(JOptionPane
                                            .showInputDialog(" Ingrese la cantidad del Producto Cafe Robusta:"));
                            if (robusta <= 0) {
                                JOptionPane.showMessageDialog(null, "No se aceptan valores negativos");
                                leido = false;
                            }
                        } catch (NumberFormatException e) {
                            leido = false;
                            JOptionPane.showMessageDialog(null, "error de conversion: " + e);
                        }
                    } while (!leido);

                    break;
            }


            /* 
             * setea cafe según la opción que haya ingresado el user.
            */
            if (option == 1){
                obj.setCafe(arabica);
            } else if (option == 2){
                obj.setCafe(robusta);
            }

            obj.CalcularCajas();
            JOptionPane.showMessageDialog(
                null, 
            "Café: " + nombre + "\n" +
            "Numero de bolsas pedidas: " + obj.getCafe() + "     " + "Costo del pedido: " + obj.CalcularTotal(nombre) +
            "\n\n\n" + "        Bolsas usadas "  + "\n\n\n" +
            "Pequeña: " + obj.getN_cajasP() + "\n" +
            "Mediana: " + obj.getN_cajasM() + "\n" +
            "Grande: " + obj.getN_cajasG() + "\n" +
            "Costo total por pagar: " + obj.CalcularPago(nombre),
             "LA CAFETELERA S.A", JOptionPane.INFORMATION_MESSAGE, icon);
            //);

            n = JOptionPane.showConfirmDialog(null, "DESEA PROCESAR OTRO REGISTRO",
                    "", JOptionPane.YES_NO_OPTION);
                    if (n == 1){
                        arabica = 0; 
                        robusta = 0; 
                        obj.setCafe(0);
                        obj.setCafe(0);
                        
                    } 

        } 
    }
}
