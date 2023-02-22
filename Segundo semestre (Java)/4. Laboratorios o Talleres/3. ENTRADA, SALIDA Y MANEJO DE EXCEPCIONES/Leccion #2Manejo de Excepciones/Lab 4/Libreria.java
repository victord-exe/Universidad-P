public class Libreria {

    private String nom;
    private int tipo, cant;
    private double costo, total;

    public void asignar(int t, int c, String n, double co, double total) {
        this.costo = co;
        this.cant = c;
        this.nom = n;
        this.tipo = t;
        this.total=total;
    }

    double calculartot( double cant, double costo) {
        return cant*costo;
    }

    public double calcular(double pago) {
        double des = 0.00;
        switch (tipo) {
            case 1: {
                des = pago * 30 / 100;
                total = pago - des;
                break;
            }
            case 2: {
                des = pago * 20 / 100;
                total = pago - des;
                break;
            }
            case 3: {
                des = pago * 10 / 100;
                total = pago - des;
                break;
            }
        }
        return des;
    }
    public double traerTotal(){
        return total;
    }
    public String traerNom() {
        return nom;
    }

    public int traerTipo() {
        return tipo;
    }

    public int traerCant() {
        return cant;
    }

    public double traerCosto() {
        return costo;
    }
}
