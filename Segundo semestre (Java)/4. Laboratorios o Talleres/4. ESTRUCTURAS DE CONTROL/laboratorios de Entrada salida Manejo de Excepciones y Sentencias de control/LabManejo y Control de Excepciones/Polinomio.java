public class Polinomio {
    private double x;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public double CalcularP(double poli){
        poli = ((2 * x * 3) + ((5 * x) - 3));
        return poli;
    }
}
