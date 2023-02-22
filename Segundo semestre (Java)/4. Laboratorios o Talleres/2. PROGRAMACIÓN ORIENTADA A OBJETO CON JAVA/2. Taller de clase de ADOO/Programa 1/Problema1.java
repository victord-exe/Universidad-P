public class Problema1 {
    public static void main(String[] args) {
        Ecuacion obj = new Ecuacion();

        obj.setA(20);
        obj.setB(20);
        obj.setC(15);
        obj.setD(3);

        System.out.println("\na = " + obj.getA());
        System.out.println("b = " + obj.getB());
        System.out.println("c = " + obj.getC());
        System.out.println("d = " + obj.getD());
        System.out.println("\n(a / b) + (c / d) = " + obj.CalcularX());
    }
}