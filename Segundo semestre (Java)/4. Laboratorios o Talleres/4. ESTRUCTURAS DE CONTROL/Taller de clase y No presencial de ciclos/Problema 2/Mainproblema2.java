// Elabore un programa que imprima las potencias de 2 que no excedan a 8500.
public class Mainproblema2 {
    public static void main(String x1[]) {
        Problema2 obj = new Problema2();

        double pot = 0;
        int cont = 0;
        boolean control = true;

        while (control) {
            pot = obj.calcularP(cont, pot);
            if (pot < 8500) {
                System.out.println("2 ** " + cont + " = " + pot);
                cont = cont + 1;
                control = true;
            } else {
                control = false;
            }
        }

    }
}
