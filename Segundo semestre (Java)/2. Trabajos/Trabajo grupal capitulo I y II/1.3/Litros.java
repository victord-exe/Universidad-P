public class Litros {

    private int lit;

    public int getLit() {
        return lit;
    }

    public void setLit(int lit) {
        this.lit = lit;
    }

    public double conversionG() {
        return lit / 4.41;
    }

    public double conversionP() {
        return lit / 0.46;
    }

    public double conversionB() {
        return lit / 158.99;
    }

}