public class Ecuacion {
    private double x;
    
    public void setX(double x) {
        this.x = x;
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
