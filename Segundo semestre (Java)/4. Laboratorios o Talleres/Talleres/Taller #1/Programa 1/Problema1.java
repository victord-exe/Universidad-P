public class Problema1 {
    public static void main(String[] args) {
        Ecuacion obj = new Ecuacion();

        obj.setZ(20);
        obj.setX(20);
        obj.setC(15);
        obj.setV(3);

        System.out.println("X = " + obj.CalcularX());
    }
}