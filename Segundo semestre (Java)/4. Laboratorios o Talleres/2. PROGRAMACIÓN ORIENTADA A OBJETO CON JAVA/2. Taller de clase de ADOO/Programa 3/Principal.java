public class Principal {

    public static void main(String[] args) {

        Edades obj = new Edades();
        obj.asignarA(20);
        obj.asignarB(19);
        obj.asignarC(30);

        System.out.println("El promedio de las tres edades es = " + obj.Promedio());
    }
}
