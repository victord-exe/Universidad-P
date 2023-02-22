public class Principal {

    public static void main(String args[]) {

        Litros obj = new Litros();

        obj.setLit(10);

        System.out.println("La conversión de Litros a galones es:" + obj.conversionG());
        System.out.println("La conversión de Litros a Pintas es:" + obj.conversionP());
        System.out.println("La connversión de Litros a Barriles es:" + obj.conversionB());

    }
}