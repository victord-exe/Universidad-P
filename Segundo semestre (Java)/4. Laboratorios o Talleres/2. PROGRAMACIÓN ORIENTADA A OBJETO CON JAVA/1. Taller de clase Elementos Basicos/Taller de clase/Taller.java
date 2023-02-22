public class Taller {
    public static void main(String[] args) {

        Funcion obj = new Funcion();

        double raiz = 0;
        double potencia = 0;

        obj.setX(10);
        obj.setY(3);
        obj.setNumero(2);

        System.out.println("\nEl resultado de la funciòn F(x, y) es: " + obj.calcularF(raiz, potencia));
    }
}
