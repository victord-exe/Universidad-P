public class Cuadrado {

    private double num;

    
    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double calcularC() {

        return Math.pow(num, 2);
    }

    public double calcularS(double suma, double calcularC) {
        suma = suma + num;
        return suma;
    }

}
