public class SolarSystem {

    public static void main(String[] args) {

        Planets obj = new Planets();

        obj.setNombre("Tierra");
        obj.setCantsat(1);
        obj.setMasa(5972 * 10 ^ 24);
        obj.setVolumen(1083 * 10 ^ 12);
        obj.setDiametro(1242);
        obj.setDistmedia(150);

        System.out.println("Las caracteristicas del planeta " + obj.getNombre() + " son: ");
        System.out.println("Posee " + obj.getCantsat() + " satélite (s) ");
        System.out.println("Tiene una masa de " + obj.getMasa() + " kg");
        System.out.println("Con un volumen de " + obj.getVolumen() + " km^3");
        System.out.println("Un diametro de " + obj.getDiametro() + " km");
        System.out.println("también tiene una densidad de " + obj.Calculard());
        System.out.println("Una distancia media al sol de " + obj.getDistmedia() + " millones de km");
        System.out.println("Y además, es un planeta de tipo " + obj.TipoP());

        Planets Saturno = new Planets();

        Saturno.setNombre("Saturno");
        Saturno.setCantsat(53);
        Saturno.setMasa(5683 * 10 ^ 26);
        Saturno.setVolumen(56832 * 10 ^ 26);
        Saturno.setDiametro(120660);
        Saturno.setDistmedia(14736);

        System.out.println("\n\nLas caracteristicas del planeta " + Saturno.getNombre() + " son: ");
        System.out.println("Posee " + Saturno.getCantsat() + " satélite (s) ");
        System.out.println("Tiene una masa de " + Saturno.getMasa() + " kg");
        System.out.println("Con un volumen de " + Saturno.getVolumen() + " km^3");
        System.out.println("Un diametro de " + Saturno.getDiametro() + " km");
        System.out.println("también tiene una densidad de " + Saturno.Calculard());
        System.out.println("Una distancia media al sol de " + Saturno.getDistmedia() + " millones de km");
        System.out.println("Y además, es un planeta de tipo " + Saturno.TipoP());

    }

}
