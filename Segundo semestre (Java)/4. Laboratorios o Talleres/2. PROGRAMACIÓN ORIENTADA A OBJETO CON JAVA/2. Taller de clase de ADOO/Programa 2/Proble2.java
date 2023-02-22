public class Proble2 {
    public static void main(String x[]) {
        Tiempo obj = new Tiempo();

        obj.asignarS(8500);
        System.out.println(obj.getSegundos() + " segundos en minutos: " + obj.calcularM());
        System.out.println(obj.getSegundos() + " segundos en horas: " + obj.calcularH());
    }
}
