public class Compras {

    private int cantp;
    private double precio;

    void asignar(int cp, double p) {
        this.cantp = cp;
        this.precio = p;
    }

    double calcularPD() {
        return cantp * precio;
    }

    double calcularD(double pd) {
        double des = 0;
        if (cantp >= 30)
            des = pd * 25 / 100;
        return des;
    }

    double calcularP (double d, double pd ) {
        return pd - d;}
        
    int traer() {
        return cantp;
    }
}
