package Lab_4;

public class Lab_4 {
    public static void main(String[] args) {
        double b = 0;
        double s = 0;

        Salario victor = new Salario();

        victor.setHorasT(10);
        victor.setTarifaH(25);
        victor.setCed("20-70-7414");

        s = victor.CalcularS(s);
        b = victor.CalcularB(s);

        System.out.println("Cédula no." + victor.getCed());
        System.out.println("Bono: " + b);
        System.out.println("Salario: " + s + b);
    }
}
