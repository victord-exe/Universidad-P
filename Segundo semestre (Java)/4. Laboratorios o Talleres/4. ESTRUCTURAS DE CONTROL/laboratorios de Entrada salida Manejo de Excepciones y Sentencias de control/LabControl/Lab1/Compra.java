public class Compra{
    private int cant;
    private double precio;

    public int getCant() {
        return cant;
    }
    public void setCant(int cant) {
        this.cant = cant;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    double calcularPD(){
        double pd = 0;
        pd = cant * precio;
        return pd;
    }
    
    double calcularD(double pd){
        double des = 0;
        if (cant >=30){
            des = pd * 25/100;
        }
        return des;
    }

    double calcularP (double d, double pd){
        double p = 0;
        p = pd - d;
        return p;
    }
}