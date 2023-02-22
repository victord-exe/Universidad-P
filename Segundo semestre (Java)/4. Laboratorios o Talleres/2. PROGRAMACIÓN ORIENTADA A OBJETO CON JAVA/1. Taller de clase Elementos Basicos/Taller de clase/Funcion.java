public class Funcion {

    private int x;
    private int y;
    private int numero;
    // private double raiz;
    // private double potencia;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double calcularF(double raiz, double potencia) {
        raiz = Math.sqrt(x);
        potencia = Math.pow(y, numero);
        return raiz / (potencia - 1);
    }
}
