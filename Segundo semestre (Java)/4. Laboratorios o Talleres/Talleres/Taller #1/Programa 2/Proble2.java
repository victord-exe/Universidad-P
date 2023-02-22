public class Proble2 {
    public static void main (String x[]) {
        Tiempo obj = new Tiempo();
        obj.asignarS(8500);
        System.out.println("Minutos: "+obj.calcularM()+"   Horas: "+obj.calcularH());
    }
}
