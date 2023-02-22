public class Serie {

    private double a;
    private double n;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double CalcularS() {
        double s = 0.00;

        s = a / n;

        return s;
    }

}
