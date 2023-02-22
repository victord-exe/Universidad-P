
public class Finca {
    private double precio;


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double CalcularT(){
        double total;
        total = (precio + 1000)/5;
        return total;
    }


    
}