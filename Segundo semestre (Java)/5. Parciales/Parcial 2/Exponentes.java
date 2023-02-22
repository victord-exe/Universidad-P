public class Exponentes {
    private double n1;
    private double n2;

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double Hallarvalor() {
        double result = 0;
        if (n1 >= n2) {
            result = Math.pow(n2, n1);
        } else {
            result = Math.pow(n1, n2);
        }
        return result;
    }

    public double Sumar(double suma) {
        suma = suma + Hallarvalor();
        return suma;
    }
}
