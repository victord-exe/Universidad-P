package Problema2;
public class Polinomio {

    private int x;

    public void asignar(int x) {
        this.x = x;
    }

    public int calcularPolinomio(int polinomio) {
        polinomio = ((2 * x) * 3) + ((5 * x) - 3);
        return polinomio;
    }

    public int traer() {
        return x;
    }
}