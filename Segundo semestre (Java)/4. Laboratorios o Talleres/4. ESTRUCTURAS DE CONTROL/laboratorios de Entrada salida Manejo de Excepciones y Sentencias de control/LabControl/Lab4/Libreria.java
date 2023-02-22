public class Libreria {
    private String nom;
    private int tipo, cant;
    private double costo, total;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
}