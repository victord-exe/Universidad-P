
public class Cuadrados {

    private int num;

    public void asignar(int num) {
        this.num = num;
    }

    public double calcularC() {

        return Math.pow(num, 2);
    }

    public double calcularS(double suma, double calcularC) {
        suma = suma + num;
        return suma;
    }

    public int traerNum() {
        return num;
    }
}
