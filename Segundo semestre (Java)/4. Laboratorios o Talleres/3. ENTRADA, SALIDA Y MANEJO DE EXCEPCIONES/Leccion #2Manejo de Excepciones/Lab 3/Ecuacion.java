public class Ecuacion {

    private int x;

    void asignar(int x1) {
        x = x1;
    }

    public double calcularY() {
        double y;
        if (x > 0)
            y = 3 * x + 6;
        else if (x < 0)
            y = Math.pow(x, 2) + 36;
        else
            y = 1;
        return y;
    }
}
